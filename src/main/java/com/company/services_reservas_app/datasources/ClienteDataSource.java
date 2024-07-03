package com.company.services_reservas_app.datasources;

import com.company.services_reservas_app.entities.Cliente;
import com.company.services_reservas_app.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClienteDataSource implements ClienteRepository {
    //@Autowired(required = true)
    //private ClienteRepositoryJPA clienteRepository;

    //public ClienteDataSource(ClienteRepositoryJPA clienteRepository){
      //  this.clienteRepository = clienteRepository;
    //}

    @Override
    public Optional<Cliente> obterCpf(String cpf) {
        //clienteRepository.findByCpf(cpf);
        return Optional.empty();
    }
}
