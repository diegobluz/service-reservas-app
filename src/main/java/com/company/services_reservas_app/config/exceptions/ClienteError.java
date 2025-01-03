package com.company.services_reservas_app.config.exceptions;

public class ClienteError extends RuntimeException {

    private String status;
    private String code;
    private String description;

    public ClienteError(String status, String code, String description) {
        this.status = status;
        this.code = code;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}