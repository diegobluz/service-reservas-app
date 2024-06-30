package com.company.services_reservas_app.interactors;


import com.company.services_reservas_app.entities.Endereco;
import com.company.services_reservas_app.repositories.ClienteRepository;
import com.company.services_reservas_app.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;
import com.company.services_reservas_app.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
public class ClienteUseCase {
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public ClienteUseCase(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository){
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public Cliente cadastrarCliente(Cliente cliente){
        if(clienteRepository.findByCpf(cliente.getCpf()).isPresent()){
            throw new IllegalArgumentException("CPF já cadastrado!");
        }
        Endereco endereco = enderecoRepository.save(cliente.getEndereco());
        cliente.setEndereco(endereco);
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> execute(Cliente cliente) {
        return null;
    }







}
