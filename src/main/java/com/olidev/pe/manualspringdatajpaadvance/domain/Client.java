package com.olidev.pe.manualspringdatajpaadvance.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
// No se usa @Data por que esta teniendo fallas
@Getter
@Setter
@ToString
public class Client {
    @Id
    @SequenceGenerator(
            name = "client_sequence", // Cualquier nombre
            sequenceName = "client_sequence", // Cualquier nombre
            initialValue = 999, // valor inicial
            allocationSize = 1 // Aumenta de 1 en 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long id;
    @Column(name = "name")
    private String name;

    // Relación 1 a 1 en el ORM
    @OneToOne
    private User user;

    // Relación 1 a muchos, un cliente puede tener muchas direcciones
    @OneToMany(
            fetch = FetchType.EAGER, // Cuando se retorne un objeto Client traerá toda la data cargada total, lo contrario es FetchType.LAZY (carga perezosa)
            cascade = CascadeType.ALL
    )
    // Como no deben repetir las direcciones se usa un Set<> y no un List<>
    private Set<Address> addresses = new HashSet<>();

    // Relacion de muchos a muchos
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_product", // representa una nueva entidad (y tabla en la DB de ser el caso) con nombre client_product que representa la relación de las entidades Client y Product
            joinColumns = {
                    @JoinColumn(name = "fk_client") // Columna 1 de la entidad client_product
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "fk_product") // Columna 2 de la entidad client_product
            }
    )
    private Set<Product> products = new HashSet<>();
}
