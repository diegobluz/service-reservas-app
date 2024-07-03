package com.company.services_reservas_app.interactors;


import com.company.services_reservas_app.config.exceptions.ClienteError;
import com.company.services_reservas_app.config.exceptions.EnderecoError;
import com.company.services_reservas_app.entities.Endereco;
import com.company.services_reservas_app.repositories.ClienteRepository;
import com.company.services_reservas_app.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;
import com.company.services_reservas_app.entities.Cliente;
import java.util.Optional;

@Service
public class ClienteUseCase {
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    public ClienteUseCase(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository){
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    /*public Cliente cadastrarCliente(Cliente cliente){
        if(clienteRepository.findByCpf(cliente.getCpf()).isPresent()){
            throw new IllegalArgumentException("CPF já cadastrado!");
        }
        Endereco endereco = enderecoRepository.save(cliente.getEndereco());
        cliente.setEndereco(endereco);
        return clienteRepository.save(cliente);
    }*/

    public Optional<Cliente> execute(Cliente cliente) {
        Optional<Cliente> opCliente = clienteRepository.obterCpf(cliente.getCpf());
        if(!opCliente.isPresent()){
            throw new ClienteError("erro 404", "Cliente não encontrado");
        }

        Endereco endereco = cliente.getEndereco();
        Optional<Endereco> optionalEndereco = enderecoRepository.obterEndereco(endereco);
        if(!optionalEndereco.isPresent()){
            throw new EnderecoError("erro 404", "Endereço não encontrado", endereco.getCep());
        }

        return null;
    }
}
