package com.betpawa.server.data.model;


import com.pawa.server.model.wallet.Wallet;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "user_wallet", indexes = {@Index(name = "currency_user_idx", unique = true, columnList = "userId, currency")})
public class UserWalletBo implements Serializable {

    private static final long serialVersionUID = 7526472295622776150L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "wallet_id", allocationSize = 10)
    private Long id;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "currency", nullable = false)
    private Wallet.Currency currency;

}
