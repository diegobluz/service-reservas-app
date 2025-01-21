package com.company.services_reservas_app.datasources.repository;

import com.company.services_reservas_app.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnderecoRepositoryJPA extends JpaRepository<Endereco, Long> {

    Endereco findByCpf(String cpf);

    List<Endereco> findByCep(String cep);
}
