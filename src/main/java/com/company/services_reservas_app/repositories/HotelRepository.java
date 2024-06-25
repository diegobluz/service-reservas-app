package com.company.services_reservas_app.repositories;

import com.company.services_reservas_app.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Hotel getHotel(Long id);
}
