package com.company.services_reservas_app.entities;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table (name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String nome;
    @Column (nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String pais;

    @Column(nullable = true)
    private int numeroEstrelas;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = true)
    private double precoPorNoite;

    //Construtor padrão

    public Hotel() {
    }

    //Construtor com os parâmetros

    public Hotel(Long id, String nome, String endereco, String cidade, String estado, String pais, int numeroEstrelas, String descricao, double precoPorNoite) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.numeroEstrelas = numeroEstrelas;
        this.descricao = descricao;
        this.precoPorNoite = precoPorNoite;
    }


    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNumeroEstrelas() {
        return numeroEstrelas;
    }

    public void setNumeroEstrelas(int numeroEstrelas) {
        this.numeroEstrelas = numeroEstrelas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoPorNoite() {
        return precoPorNoite;
    }

    public void setPrecoPorNoite(double precoPorNoite) {
        this.precoPorNoite = precoPorNoite;
    }
}

