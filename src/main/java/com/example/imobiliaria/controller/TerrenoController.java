package com.example.imobiliaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.imobiliaria.enums.Situacao;
import com.example.imobiliaria.model.Terreno;
import com.example.imobiliaria.service.TerrenoService;

@RestController
@RequestMapping("/api/terreno")
public class TerrenoController {

    @Autowired
    private TerrenoService service;

    @PostMapping("/")
    public Terreno cadastrarTerreno(@RequestBody Terreno terreno) {
        return service.cadastrarTerreno(terreno);
    }

    @PutMapping("/{id}/vender")
    public Terreno marcarTerrenoComoVendido(@PathVariable Long id, @RequestParam double valorVenda) {
        Terreno terreno = service.buscarTerrenoPorId(id);
        terreno.setValorVenda(valorVenda);
        terreno.setSituacao(Situacao.VENDIDO);
        return service.cadastrarTerreno(terreno);
    }

}    
