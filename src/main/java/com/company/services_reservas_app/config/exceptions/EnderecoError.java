package com.company.services_reservas_app.config.exceptions;

public class EnderecoError extends RuntimeException {
    private String code;
    private String description;

    private String cep;

    public EnderecoError(String code, String description, String cep) {
        this.code = code;
        this.description = description;
        this.cep = cep;
    }
}
