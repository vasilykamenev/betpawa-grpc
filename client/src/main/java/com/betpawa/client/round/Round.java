package com.betpawa.client.round;

import com.betpawa.client.round.action.Action;
import io.grpc.ManagedChannel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public class Round {

    private final String name;

    @Getter
    private LinkedList<Action> actions = new LinkedList<>();

    public Round(String name) {
        this.name = name;
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public void execute(long userId, ManagedChannel channel) {
        log.info("userId: {}, Start round {}", userId, name);

        actions.forEach(x -> x.doAction(userId, channel));

        log.info("userId: {}, Finished round {}", userId, name);
    }
}
