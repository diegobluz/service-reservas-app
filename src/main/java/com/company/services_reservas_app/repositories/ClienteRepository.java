package com.company.services_reservas_app.repositories;

import com.company.services_reservas_app.entities.Cliente;
import java.util.Optional;

public interface ClienteRepository{
    Optional<Cliente> obterCpf(String cpf);
}

