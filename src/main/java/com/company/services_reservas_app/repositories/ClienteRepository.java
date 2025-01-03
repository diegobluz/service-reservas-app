package com.company.services_reservas_app.repositories;

import com.company.services_reservas_app.entities.response.ClienteVO;

import java.util.Optional;

public interface ClienteRepository {

    ClienteVO obterCpf(String cpf);

    ClienteVO save(ClienteVO cliente);
}
