package com.example.imobiliaria.exceptions;

public class LoteadoraNotFoundException extends RuntimeException {
    public LoteadoraNotFoundException(Long id) {
        super("Loteadora não encontrada com o ID: " + id);
    }
}
