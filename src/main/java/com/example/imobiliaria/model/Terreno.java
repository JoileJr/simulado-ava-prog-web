package com.example.imobiliaria.model;

import com.example.imobiliaria.enums.Situacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_terreno")
public class Terreno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String endereco;

    private String medidas;

    @Column(nullable = false)
    private double valorPedida;

    private double valorVenda;

    private Situacao situacao;

    @ManyToOne
    private Loteadora loteadora;

}
