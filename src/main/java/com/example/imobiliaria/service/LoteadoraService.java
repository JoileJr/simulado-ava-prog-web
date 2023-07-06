package com.example.imobiliaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.imobiliaria.exceptions.LoteadoraNotFoundException;
import com.example.imobiliaria.model.Loteadora;
import com.example.imobiliaria.repository.LoteadoraRepository;

@Service
public class LoteadoraService {
    @Autowired
    private LoteadoraRepository repository;

    public Loteadora cadastrarLoteadora(Loteadora loteadora) {
        return repository.save(loteadora);
    }
    
    public Loteadora buscarLoteadoraPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new LoteadoraNotFoundException(id));
    }
}
