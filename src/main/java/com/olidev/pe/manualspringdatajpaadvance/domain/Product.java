package com.olidev.pe.manualspringdatajpaadvance.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
// No se usa @Data por que esta teniendo fallas
@Getter
@Setter
@ToString
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence", // Cualquier nombre
            sequenceName = "product_sequence", // Cualquier nombre
            initialValue = 150, // valor inicial
            allocationSize = 3 // Aumenta de 3 en 3
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    @Column(name = "name")
    private  String name;
    @Column(name = "price")
    private  Double price;
}
