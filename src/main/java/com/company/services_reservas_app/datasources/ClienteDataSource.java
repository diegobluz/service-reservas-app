package com.company.services_reservas_app.datasources;

import com.company.services_reservas_app.entities.Cliente;
import com.company.services_reservas_app.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClienteDataSource {
    @Autowired(required = true)
    private ClienteRepository clienteRepository;

    public ClienteDataSource(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }




}
