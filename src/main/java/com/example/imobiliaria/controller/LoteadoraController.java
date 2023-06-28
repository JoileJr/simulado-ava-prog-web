package com.example.imobiliaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.imobiliaria.model.Loteadora;
import com.example.imobiliaria.service.LoteadoraService;

@RestController
@RequestMapping("/api/loteadora")
public class LoteadoraController {
    
    @Autowired
    private LoteadoraService service;

    @GetMapping("/")
    public List<Loteadora> buscarTodos(){
       return service.buscarTodos();
    }

    @PostMapping("/")
    public Loteadora inserir(@RequestBody Loteadora estado){
        return service.inserir(estado);
    }

    @PutMapping("/")
    public Loteadora alterar(@RequestBody Loteadora estado){
        return service.alterar(estado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}
