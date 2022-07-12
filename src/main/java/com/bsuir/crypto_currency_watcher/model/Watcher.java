package com.bsuir.crypto_currency_watcher.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "watcher")
@NoArgsConstructor
@Getter
@Setter
@Builder
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
    @JsonManagedReference
    private Set<Cryptocurrency> cryptocurrencies;
}
