package com.company.services_reservas_app.repositories;

import com.company.services_reservas_app.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
