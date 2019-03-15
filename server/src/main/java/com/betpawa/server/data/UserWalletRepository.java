package com.betpawa.server.data;

import com.betpawa.server.data.model.UserWalletBo;
import com.pawa.server.model.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserWalletRepository extends JpaRepository<UserWalletBo, Long> {

    List<UserWalletBo> findByUserId(long userId);

    UserWalletBo findByUserIdAndCurrency(long userId, Wallet.Currency currency);
}
