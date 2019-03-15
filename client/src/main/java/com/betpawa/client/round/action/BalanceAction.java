package com.betpawa.client.round.action;

import com.pawa.server.model.wallet.BalanceGrpc;
import com.pawa.server.model.wallet.Wallet;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import static com.pawa.server.model.wallet.BalanceGrpc.newBlockingStub;

@Slf4j
@Builder
public class BalanceAction implements Action {

    @Override
    public void doAction(long userId, ManagedChannel channel) {
        log.debug("userId: {} do action", userId);
        try {
            BalanceGrpc.BalanceBlockingStub stub = newBlockingStub(channel);
            Wallet.BalanceResponse response = stub.balance(Wallet.BalanceRequest.newBuilder()
                    .setUserId(userId).build());
            if (log.isDebugEnabled()) {
                log.debug("Response: ");
                response.getWalletList().forEach(x -> log.debug("userId: {}, amount: {}, currency: {}", x.getUserId(), x.getAmount(), x.getCurrency()));
            }
        } catch (StatusRuntimeException e) {
            log.error(e.getMessage());
        }

    }
}
