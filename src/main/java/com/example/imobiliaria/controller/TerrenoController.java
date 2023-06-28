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

import com.example.imobiliaria.model.Terreno;
import com.example.imobiliaria.service.TerrenoService;

@RestController
@RequestMapping("/api/terreno")
public class TerrenoController {

    @Autowired
    private TerrenoService service;

    @GetMapping("/")
    public List<Terreno> buscarTodos(){
       return service.buscarTodos();
    }

    @PostMapping("/")
    public Terreno inserir(@RequestBody Terreno obj){
        return service.inserir(obj);
    }

    @PutMapping("/")
    public Terreno alterar(@RequestBody Terreno obj){
        return service.alterar(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}
