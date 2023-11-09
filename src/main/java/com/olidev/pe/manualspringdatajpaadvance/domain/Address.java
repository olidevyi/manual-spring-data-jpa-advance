package com.olidev.pe.manualspringdatajpaadvance.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence", // Cualquier nombre
            sequenceName = "address_sequence", // Cualquier nombre
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
}
