package com.olidev.pe.manualspringdatajpaadvance.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @SequenceGenerator(
            name = "client_sequence", // Cualquier nombre
            sequenceName = "client_sequence", // Cualquier nombre
            initialValue = 1, // valor inicial
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
}
