package com.betpawa.server.service;

import com.betpawa.server.data.UserWalletRepository;
import com.betpawa.server.data.model.UserWalletBo;
import com.pawa.server.model.wallet.BalanceGrpc;
import com.pawa.server.model.wallet.Wallet;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@GRpcService
public class BalanceService extends BalanceGrpc.BalanceImplBase {

    private final UserWalletRepository userWalletRepository;

    @Autowired
    public BalanceService(UserWalletRepository userWalletRepository){
        this.userWalletRepository = userWalletRepository;
    }

    @Override
    public void balance(Wallet.BalanceRequest request, StreamObserver<Wallet.BalanceResponse> responseObserver) {

        try {
            log.info("userId: {} requested a balance", request.getUserId() );
            Wallet.BalanceResponse.Builder resultBuilder = Wallet.BalanceResponse.newBuilder();

            List<UserWalletBo> walletList = userWalletRepository.findByUserId(request.getUserId());

            walletList.forEach(x ->
                    resultBuilder.addWallet(
                            Wallet.BalanceResponse.UserWallet.newBuilder()
                                    .setUserId(x.getUserId())
                                    .setAmount(x.getAmount().doubleValue())
                                    .setCurrency(x.getCurrency())
                                    .build())
            );
            responseObserver.onNext(resultBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            if (log.isTraceEnabled()) {
                log.trace(e.getMessage(), e.fillInStackTrace());
            } else {
                log.error(e.getMessage());
            }
        }
    }
}
