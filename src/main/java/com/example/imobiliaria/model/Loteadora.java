package com.example.imobiliaria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_loteadora")
public class Loteadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeFantasia;

    @Column(nullable = false)
    private String razaoSocial;

    private String endereco;
    
    private String telefone;

    @Column(nullable = false)
    private double porcentagemComissao;
    
}
