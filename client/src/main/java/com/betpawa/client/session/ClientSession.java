package com.betpawa.client.session;

import com.betpawa.client.round.Round;
import com.betpawa.client.round.RoundFactory;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class ClientSession implements Runnable {

    private int roundsPerThread;
    private final String host;
    private final int port;
    private final CountDownLatch latch;
    private final ThreadPoolExecutor executorService;
    private final long userId;
    private RoundFactory roundFactory = RoundFactory.get();

    public ClientSession(String host, int port, int concurrentThreads, int roundsPerThread) {
        this.userId = ThreadLocalRandom.current().nextLong(1, 1000000);
        this.host = host;
        this.port = port;
        this.roundsPerThread = roundsPerThread;
        executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(concurrentThreads);
        latch = new CountDownLatch(roundsPerThread);
    }

    @Override
    public void run() {
        log.debug("userId: {}, Star the session", userId);

        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        while (roundsPerThread > 0) {
            Round round = roundFactory.selectAny();
            executorService.submit(() -> {
                try {
                    round.execute(userId, channel);
                } catch (Exception e) {
                    log.error(e.getMessage());
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });
            --roundsPerThread;
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
        }
        executorService.shutdown();
        channel.shutdown();
        log.debug("userId: {}, End of the session: {}, shutdown executor: {}", userId, channel.isShutdown(), executorService.isShutdown());
    }
}
