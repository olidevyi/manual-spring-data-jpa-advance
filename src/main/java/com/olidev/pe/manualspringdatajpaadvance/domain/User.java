package com.olidev.pe.manualspringdatajpaadvance.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_auth")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence", // Cualquier nombre
            sequenceName = "user_sequence", // Cualquier nombre
            initialValue = 1, // valor inicial
            allocationSize = 1 // Aumenta de 1 en 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
}
