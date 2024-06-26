package com.company.services_reservas_app.datasources;

import  com.company.services_reservas_app.entities.Hotel;
import com.company.services_reservas_app.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class HotelDataSource {
    @Autowired(required = true)
    private HotelRepository hotelRepository;

    public HotelDataSource(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    public Optional<Hotel> getHotel(Long id){
        return hotelRepository.findById(id);
    }


}
