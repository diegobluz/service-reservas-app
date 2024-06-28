package com.company.services_reservas_app.interactors;

import com.company.services_reservas_app.entities.Reserva;
import com.company.services_reservas_app.repositories.HotelRepository;
import com.company.services_reservas_app.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelUseCase {

    private final HotelRepository hotelRepository;

    public HotelUseCase(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Optional<Hotel> execute(Reserva reserva) {
        return null;
    }

}
