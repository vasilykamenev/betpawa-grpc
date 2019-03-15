package com.betpawa.server.service;

import com.betpawa.server.data.UserWalletRepository;
import com.betpawa.server.data.model.UserWalletBo;
import com.betpawa.server.exception.WalletException;
import com.google.rpc.Status;
import com.pawa.server.model.wallet.Wallet;
import com.pawa.server.model.wallet.WithdrawGrpc;
import io.grpc.protobuf.StatusProto;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Slf4j
@GRpcService
public class WithdrawService extends WithdrawGrpc.WithdrawImplBase {

    private final UserWalletRepository userWalletRepository;

    @Autowired
    public WithdrawService(UserWalletRepository userWalletRepository){
        this.userWalletRepository = userWalletRepository;
    }

    @Override
    public void withdraw(Wallet.WithdrawRequest request, StreamObserver<Wallet.WithdrawResponse> responseObserver) {

        Wallet.WithdrawResponse.Builder resultBuilder = Wallet.WithdrawResponse.newBuilder();
        try {
            log.info("Withdraw operation for user {}", request.getUserId());
            UserWalletBo userWallet = userWalletRepository.findByUserIdAndCurrency(request.getUserId(), request.getCurrency());
            if (userWallet == null) {
                throw new WalletException("Insufficient fund");
            }
            if (request.getCurrency().getNumber() == -1) {
                throw new WalletException("Unknown currency");
            }
            double amount = userWallet.getAmount().doubleValue() - request.getAmount();
            if (amount < 0) {
                throw new WalletException("Insufficient fund");
            }
            userWallet.setAmount(BigDecimal.valueOf(amount));
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
