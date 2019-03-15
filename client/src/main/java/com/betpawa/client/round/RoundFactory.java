package com.betpawa.client.round;

import com.betpawa.client.round.action.BalanceAction;
import com.betpawa.client.round.action.DepositAction;
import com.betpawa.client.round.action.WithdrawAction;
import com.pawa.server.model.wallet.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RoundFactory {

    private static RoundFactory instant = new RoundFactory();
    private List<Round> rounds = new ArrayList<>();

    public static RoundFactory get() {
        instant.init();
        return instant;
    }

    public Round selectAny() {
        int number = ThreadLocalRandom.current().nextInt(0, rounds.size());
        return rounds.get(number);
    }

    private void init() {
        Round round = new Round("Round A");
        round.addAction(DepositAction.builder().amount(100).currency(Wallet.Currency.USD).build());
        round.addAction(WithdrawAction.builder().amount(200).currency(Wallet.Currency.USD).build());
        round.addAction(DepositAction.builder().amount(100).currency(Wallet.Currency.USD).build());
        round.addAction(BalanceAction.builder().build());
        round.addAction(WithdrawAction.builder().amount(100).currency(Wallet.Currency.USD).build());
        round.addAction(BalanceAction.builder().build());
        round.addAction(WithdrawAction.builder().amount(100).currency(Wallet.Currency.USD).build());
        rounds.add(round);

        round = new Round("Round B");
        round.addAction(WithdrawAction.builder().amount(100).currency(Wallet.Currency.GBP).build());
        round.addAction(DepositAction.builder().amount(300).currency(Wallet.Currency.GBP).build());
        round.addAction(WithdrawAction.builder().amount(100).currency(Wallet.Currency.GBP).build());
        round.addAction(WithdrawAction.builder().amount(100).currency(Wallet.Currency.GBP).build());
        round.addAction(WithdrawAction.builder().amount(100).currency(Wallet.Currency.GBP).build());
        rounds.add(round);

        round = new Round("Round C");
        round.addAction(BalanceAction.builder().build());
        round.addAction(DepositAction.builder().amount(100).currency(Wallet.Currency.USD).build());
        round.addAction(DepositAction.builder().amount(100).currency(Wallet.Currency.USD).build());
        round.addAction(WithdrawAction.builder().amount(100).currency(Wallet.Currency.USD).build());
        round.addAction(DepositAction.builder().amount(100).currency(Wallet.Currency.USD).build());
        round.addAction(BalanceAction.builder().build());
        round.addAction(WithdrawAction.builder().amount(200).currency(Wallet.Currency.USD).build());
        round.addAction(BalanceAction.builder().build());
        rounds.add(round);
    }
}
