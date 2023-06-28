package com.example.imobiliaria.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_loteadora")
public class Loteadora {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String razao_social;
    private String endereco;
    private String telefone;
    private Double comissao;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "loteadora_terreno",
            joinColumns = @JoinColumn(name = "loteadora_id"),
            inverseJoinColumns = @JoinColumn(name = "terreno_id"))
    private List<Terreno> terrenos = new ArrayList<>();
    
}
