package com.example.imobiliaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.imobiliaria.enums.Situacao;
import com.example.imobiliaria.model.Loteadora;
import com.example.imobiliaria.model.Terreno;
import com.example.imobiliaria.service.LoteadoraService;
import com.example.imobiliaria.service.TerrenoService;

@RestController
@RequestMapping("/api/loteadora")
public class LoteadoraController {
    
    @Autowired
    private LoteadoraService loteadoraService;

    @Autowired
    private TerrenoService terrenoService;

    @PostMapping("/")
    public Loteadora cadastrarLoteadora(@RequestBody Loteadora loteadora) {
        return loteadoraService.cadastrarLoteadora(loteadora);
    }

   @GetMapping("/{id}/comissao")
    public double calcularComissao(@PathVariable Long id) {
        Loteadora loteadora = loteadoraService.buscarLoteadoraPorId(id);
        List<Terreno> terrenosVendidos = terrenoService.buscarTerrenosPorLoteadoraESituacao(loteadora, Situacao.VENDIDO);
        double totalComissao = terrenosVendidos.stream()
                .mapToDouble(terreno -> terreno.getValorVenda() * loteadora.getPorcentagemComissao() / 100)
                .sum();
        return totalComissao;
    }

    @PutMapping("/{id}/aumentar-valor-venda")
    public List<Terreno> aumentarValorVendaTerrenos(@PathVariable Long id, @RequestParam double porcentagem) {
        Loteadora loteadora = loteadoraService.buscarLoteadoraPorId(id);
        List<Terreno> terrenos = terrenoService.buscarTerrenosPorLoteadora(loteadora);
        
        for (Terreno terreno : terrenos) {
            if (terreno.getSituacao() != Situacao.VENDIDO) {
                double novoValorVenda = terreno.getValorVenda() * ( porcentagem / 100);
                terreno.setValorVenda(novoValorVenda);
                terrenoService.cadastrarTerreno(terreno);
            }
        }
        
        return terrenos;
    }
}
