package com.betpawa.server.service;

import com.betpawa.server.config.JpaConfig;
import com.betpawa.server.data.UserWalletRepository;
import com.pawa.server.model.wallet.BalanceGrpc;
import com.pawa.server.model.wallet.DepositGrpc;
import com.pawa.server.model.wallet.Wallet;
import com.pawa.server.model.wallet.WithdrawGrpc;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@EnableAutoConfiguration
@ContextConfiguration(classes = JpaConfig.class)
public class ServiceTest {


    @Rule
    public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private UserWalletRepository userWalletRepository;

    private WithdrawGrpc.WithdrawFutureStub withdrawFutureStub;
    private DepositGrpc.DepositFutureStub depositFutureStub;
    private BalanceGrpc.BalanceFutureStub balanceFutureStub;


    public EntityManager getEntityManager() {
        return testEntityManager.getEntityManager();
    }

    @Before
    public void init() throws IOException {
        String serverName = InProcessServerBuilder.generateName();
        grpcCleanup.register(
                InProcessServerBuilder.forName(serverName).directExecutor()
                        .addService(new WithdrawService(userWalletRepository)).build().start());
        withdrawFutureStub = WithdrawGrpc.newFutureStub(
                grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));

        serverName = InProcessServerBuilder.generateName();
        grpcCleanup.register(
                InProcessServerBuilder.forName(serverName).directExecutor()
                        .addService(new DepositService(userWalletRepository)).build().start());
        depositFutureStub = DepositGrpc.newFutureStub(
                grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));

        serverName = InProcessServerBuilder.generateName();
        grpcCleanup.register(
                InProcessServerBuilder.forName(serverName).directExecutor()
                        .addService(new BalanceService(userWalletRepository)).build().start());
        balanceFutureStub = BalanceGrpc.newFutureStub(
                grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));

    }

    @Test
    public void wallet_test_action_scenario() throws ExecutionException, InterruptedException {

        withdraw_insufficient();
        deposit_ok();
        balance_ok();
        withdraw_insufficient();
        deposit_ok();
        balance_ok();
        withdraw_insufficient();
        deposit_ok();
        balance_ok();
        withdraw_ok();
        balance_ok();
        withdraw_insufficient();
    }

    private void withdraw_ok() throws ExecutionException, InterruptedException {
        assertTrue(withdraw() != null);
    }

    private void withdraw_insufficient() {
        try {
            withdraw();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Insufficient fund"));
        }
    }

    private void deposit_ok() throws ExecutionException, InterruptedException {
        assertTrue( deposit() != null);
    }

    private void balance_ok() throws ExecutionException, InterruptedException {
        assertTrue(balance() != null);
    }

    private Wallet.WithdrawResponse withdraw() throws InterruptedException, ExecutionException {

        Wallet.WithdrawRequest withdrawRequest = Wallet.WithdrawRequest.newBuilder()
                .setUserId(1L)
                .setAmount(200.0)
                .setCurrency(Wallet.Currency.USD)
                .build();

       return withdrawFutureStub.withdraw(withdrawRequest).get();
    }

    private Wallet.DepositResponse deposit() throws ExecutionException, InterruptedException {

        Wallet.DepositRequest depositRequest = Wallet.DepositRequest.newBuilder()
                .setUserId(1L)
                .setAmount(100.0)
                .setCurrency(Wallet.Currency.USD)
                .build();

        return depositFutureStub.deposit(depositRequest).get();
    }

    private Wallet.BalanceResponse balance() throws ExecutionException, InterruptedException {

        Wallet.BalanceRequest balanceRequest = Wallet.BalanceRequest.newBuilder().build();

        return balanceFutureStub.balance(balanceRequest).get();
    }


}