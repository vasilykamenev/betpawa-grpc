package com.betpawa.client.round.action;

import com.pawa.server.model.wallet.DepositGrpc;
import com.pawa.server.model.wallet.Wallet;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import static com.pawa.server.model.wallet.DepositGrpc.newBlockingStub;

@Slf4j
@Builder
public class DepositAction implements Action {

    private double amount;
    private Wallet.Currency currency;

    @Override
    public void doAction(long userId, ManagedChannel channel) {
        log.debug("userId: {} do action", userId);
        try {
            DepositGrpc.DepositBlockingStub stub = newBlockingStub(channel);
            stub.deposit(Wallet.DepositRequest.newBuilder()
                    .setAmount(amount)
                    .setCurrency(currency)
                    .setUserId(userId).build());
        } catch (StatusRuntimeException e) {
            log.error(e.getMessage());
        }
    }
}
