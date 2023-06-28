package com.example.imobiliaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.imobiliaria.model.Loteadora;
import com.example.imobiliaria.repository.LoteadoraRepository;

@Service
public class LoteadoraService {
    @Autowired
    private LoteadoraRepository repository;

    public List<Loteadora> buscarTodos() {
        return repository.findAll();
    }

    public Loteadora inserir(Loteadora obj) {
        Loteadora objNovo = repository.saveAndFlush(obj);
        return objNovo;
    }

    public Loteadora alterar(Loteadora obj) {
        return repository.saveAndFlush(obj);
    }

    public void excluir(Long id) {
        Loteadora obj = repository.findById(id).get();
        repository.delete(obj);
    }
}
