package com.betpawa.client.round.action;

import io.grpc.ManagedChannel;

public interface Action {

    void doAction(long userId, ManagedChannel channel);
}
