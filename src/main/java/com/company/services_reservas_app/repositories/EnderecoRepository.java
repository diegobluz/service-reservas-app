package com.company.services_reservas_app.repositories;


import com.company.services_reservas_app.datasources.repository.endereco.response.ResponseEndereco;
import com.company.services_reservas_app.entities.response.EnderecoVO;

public interface EnderecoRepository {

    ResponseEndereco obterEnderecoCep(String cep);

    EnderecoVO obterEnderecoCpf(String cpf);

    EnderecoVO save(EnderecoVO endereco);
}
