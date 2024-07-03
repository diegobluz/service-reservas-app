package com.company.services_reservas_app.repositories;

import com.company.services_reservas_app.entities.Endereco;
import java.util.Optional;

public interface EnderecoRepository  {
    Optional<Endereco> obterEndereco(Endereco endereco);
}
