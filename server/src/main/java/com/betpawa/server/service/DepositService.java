package com.betpawa.server.service;

import com.betpawa.server.data.UserWalletRepository;
import com.betpawa.server.data.model.UserWalletBo;
import com.betpawa.server.exception.WalletException;
import com.google.rpc.Status;
import com.pawa.server.model.wallet.DepositGrpc;
import com.pawa.server.model.wallet.Wallet;
import io.grpc.protobuf.StatusProto;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Slf4j
@GRpcService
public class DepositService extends DepositGrpc.DepositImplBase {

    private final UserWalletRepository userWalletRepository;

    @Autowired
    public DepositService(UserWalletRepository userWalletRepository){
        this.userWalletRepository = userWalletRepository;
    }

    @Override
    public void deposit(Wallet.DepositRequest request, StreamObserver<Wallet.DepositResponse> responseObserver) {
        Wallet.DepositResponse.Builder resultBuilder = Wallet.DepositResponse.newBuilder();
        try {
            log.info("New deposit from user {}", request.getUserId());

            if (request.getCurrency().getNumber() == -1) {
                throw new WalletException("Unknown currency");
            }

            UserWalletBo userWallet = userWalletRepository.findByUserIdAndCurrency(request.getUserId(), request.getCurrency());
            if (userWallet == null) {
                userWallet = new UserWalletBo();
                userWallet.setCurrency(request.getCurrency());
                userWallet.setUserId(request.getUserId());
                userWallet.setAmount(BigDecimal.valueOf(request.getAmount()));
            }
            userWallet.setAmount(BigDecimal.valueOf(request.getAmount()).add(userWallet.getAmount()));

            userWalletRepository.saveAndFlush(userWallet);

            responseObserver.onNext(resultBuilder.build());
            responseObserver.onCompleted();
        } catch (WalletException e) {
            responseObserver.onError(StatusProto.toStatusRuntimeException(
                    Status.newBuilder().setCode(13).setMessage(e.getMessage()).build()));
        } catch (Exception e) {
            if (log.isTraceEnabled()) {
                log.trace(e.getMessage(), e.fillInStackTrace());
            } else {
                log.error(e.getMessage());
            }
        }
    }
}
