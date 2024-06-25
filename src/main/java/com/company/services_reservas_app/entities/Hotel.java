package com.company.services_reservas_app.entities;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table (name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    private String endereco;
    private String cidade;
    private String estado;
    private String pais;


    private int numeroEstrelas;


    private String descricao;


    private double precoPorNoite;

    // Getters e Setters
}

