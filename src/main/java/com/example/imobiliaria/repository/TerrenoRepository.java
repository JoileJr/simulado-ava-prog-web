package com.example.imobiliaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.imobiliaria.enums.Situacao;
import com.example.imobiliaria.model.Loteadora;
import com.example.imobiliaria.model.Terreno;

public interface TerrenoRepository extends JpaRepository<Terreno, Long>{
    List<Terreno> findByLoteadora(Loteadora loteadora);
    List<Terreno> findByLoteadoraAndSituacao(Loteadora loteadora, Situacao situacao);
}
