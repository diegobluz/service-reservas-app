package com.company.services_reservas_app.config.exceptions;

public class ClienteError extends RuntimeException {

    private String code;
    private String description;



    public ClienteError(String code, String description) {
        this.code = code;
        this.description = description;
    }
}