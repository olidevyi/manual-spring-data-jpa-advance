package com.olidev.pe.manualspringdatajpaadvance.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
// No se usa @Data por que esta teniendo fallas
@Getter
@Setter
@ToString
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence", // Cualquier nombre
            sequenceName = "address_sequence", // Cualquier nombre
            initialValue = 8100, // valor inicial
            allocationSize = 1 // Aumenta de 1 en 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "number")
    private String number;

    // Relación muchos a 1, muchas direcciones pueden pertenecer en un cliente
    @ManyToOne(
            fetch = FetchType.LAZY, // Se pone LAZY (carga perezosa) solo para esta prueba, cambiar según la necesidad la DB
            optional = false // Siempre tiene que haber una entidad Client asociado a esta entidad Address
    )
    @JoinColumn(name = "client_id") // Determina con quien relaciona la entidad Address
    private Client client;
}
