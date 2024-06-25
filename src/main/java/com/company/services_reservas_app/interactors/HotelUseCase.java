package com.company.services_reservas_app.interactors;

import com.company.services_reservas_app.datasources.HotelDataSource;
import com.company.services_reservas_app.repositories.HotelRepository;
import com.company.services_reservas_app.entities.Hotel;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelUseCase {

    private final HotelRepository hotelRepository;

    public HotelUseCase(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel execute(Long id) {
        Hotel hotel = hotelRepository.getHotel(id);

        if (hotel == null) {
            System.out.println("Hotel não encontrado.");
        }


        return hotel;

    }
}
