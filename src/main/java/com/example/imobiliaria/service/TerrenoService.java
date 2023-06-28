package com.example.imobiliaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.imobiliaria.model.Terreno;
import com.example.imobiliaria.repository.TerrenoRepository;

@Service
public class TerrenoService {
    @Autowired
    private TerrenoRepository repository;

    public List<Terreno> buscarTodos() {
        return repository.findAll();
    }

    public Terreno inserir(Terreno obj) {
        Terreno objNovo = repository.saveAndFlush(obj);
        return objNovo;
    }

    public Terreno alterar(Terreno obj) {
        return repository.saveAndFlush(obj);
    }

    public void excluir(Long id) {
        Terreno obj = repository.findById(id).get();
        repository.delete(obj);
    }
}
