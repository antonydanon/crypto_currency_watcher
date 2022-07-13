package com.bsuir.crypto_currency_watcher.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import java.util.Set;

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

    @ManyToMany(mappedBy = "cryptocurrencies")
    @JsonBackReference
    private Set<Watcher> users;
}
