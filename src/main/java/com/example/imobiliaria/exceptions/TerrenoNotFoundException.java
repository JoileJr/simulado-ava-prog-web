package com.example.imobiliaria.exceptions;

public class TerrenoNotFoundException extends RuntimeException{
    public TerrenoNotFoundException(Long id) {
        super("Loteadora não encontrada com o ID: " + id);
    }
}
