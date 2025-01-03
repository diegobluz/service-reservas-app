package com.company.services_reservas_app.datasources.repository;

import com.company.services_reservas_app.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ClienteRepositoryJPA extends JpaRepository<Cliente, Long> {

    Cliente findByCpf(String cpf);

    @Override
    List<Cliente> findAll();

}
