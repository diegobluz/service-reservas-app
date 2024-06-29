package com.company.services_reservas_app.transportlayers.impl.http;

import com.company.services_reservas_app.entities.Cliente;
import com.company.services_reservas_app.interactors.ClienteUseCase;
import com.company.services_reservas_app.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClienteApiImpl {
    private final ClienteUseCase clienteUseCase;


    //iniciando a classe
    @Autowired
    public ClienteApiImpl(ClienteUseCase clienteUseCase){
        this.clienteUseCase = clienteUseCase;
    }
    //endpoint de criação de um cliente
    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(Cliente cliente){
        Cliente novoCliente = clienteUseCase.cadastrarCliente(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }
}
