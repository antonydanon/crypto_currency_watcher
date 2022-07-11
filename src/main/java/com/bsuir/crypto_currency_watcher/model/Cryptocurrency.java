package com.bsuir.crypto_currency_watcher.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "cryptocurrency")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Cryptocurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;

    @Column(name = "price_usd")
    private float priceUsd;
}
