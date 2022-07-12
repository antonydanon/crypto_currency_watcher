package com.bsuir.crypto_currency_watcher.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "watcher")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Watcher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(name = "price_at_registration")
    private float priceAtRegistration;

    @ManyToMany (cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "watchers_cryptocurrencies",
            joinColumns = @JoinColumn(name = "watcher_id"),
            inverseJoinColumns = @JoinColumn(name = "cryptocurrency_id")
    )
    private Set<Cryptocurrency> cryptocurrencies;
}
