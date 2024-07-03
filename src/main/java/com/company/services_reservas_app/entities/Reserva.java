package com.company.services_reservas_app.entities;


public class Reserva {

    private String nomeCliente;
    private String dataEntrada;
    private String dataSaida;
    private String numeroHospedes;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getNumeroHospedes() {
        return numeroHospedes;
    }

    public void setNumeroHospedes(String numeroHospedes) {
        this.numeroHospedes = numeroHospedes;
    }
}
