package com.company.services_reservas_app.repositories;

import com.company.services_reservas_app.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
