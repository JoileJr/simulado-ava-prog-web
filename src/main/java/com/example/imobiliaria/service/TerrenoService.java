package com.example.imobiliaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.imobiliaria.enums.Situacao;
import com.example.imobiliaria.exceptions.TerrenoNotFoundException;
import com.example.imobiliaria.model.Loteadora;
import com.example.imobiliaria.model.Terreno;
import com.example.imobiliaria.repository.TerrenoRepository;

@Service
public class TerrenoService {
    @Autowired
    private TerrenoRepository repository;
    
    public Terreno cadastrarTerreno(Terreno terreno) {
        return repository.save(terreno);
    }
    
    public Terreno buscarTerrenoPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new TerrenoNotFoundException(id));
    }
    
    public List<Terreno> buscarTerrenosPorLoteadora(Loteadora loteadora) {
        return repository.findByLoteadora(loteadora);
    }
    
    public List<Terreno> buscarTerrenosPorLoteadoraESituacao(Loteadora loteadora, Situacao situacao) {
        return repository.findByLoteadoraAndSituacao(loteadora, situacao);
    }
}
