package com.company.services_reservas_app.datasources;

import  com.company.services_reservas_app.entities.Hotel;
import com.company.services_reservas_app.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelDataSource {
    @Autowired(required = true)
    private HotelRepository hotelRepository;

    public HotelDataSource(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }
}
