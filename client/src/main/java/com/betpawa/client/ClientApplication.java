package com.betpawa.client;

import com.betpawa.client.session.ClientSession;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class ClientApplication {

    public static void main(String[] args) {

        int users = 1;
        int concurrent_threads_per_user = 1;
        int rounds_per_thread = 1;
        String host = "localhost";
        int port = 6565;

        if (args.length > 0) {
            for (String arg : args) {
                String[] keyValue = arg.split("=");
                switch (keyValue[0]) {
                    case "users":
                        users = Integer.parseInt(keyValue[1]);
                        break;
                    case "threads":
                        concurrent_threads_per_user = Integer.parseInt(keyValue[1]);
                        break;
                    case "rounds":
                        rounds_per_thread = Integer.parseInt(keyValue[1]);
                        break;
                }
            }
        }


        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(100);

        while (users-- > 0) {
            threadPoolExecutor.submit(new ClientSession(host, port, concurrent_threads_per_user, rounds_per_thread));
        }

        threadPoolExecutor.shutdown();
    }

}
