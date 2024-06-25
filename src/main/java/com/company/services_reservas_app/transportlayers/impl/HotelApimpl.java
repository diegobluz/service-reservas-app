package com.company.services_reservas_app.transportlayers.impl;

import com.company.services_reservas_app.entities.Hotel;
import com.company.services_reservas_app.interactors.HotelUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//RestController define a classe como controlador da API REST
@RestController
//RequestMapping é usada para mapear requisições web para os métodos criados dentro de uma controller
@RequestMapping("/")
public class HotelApimpl   {

    @Autowired(required = true)
    private HotelUseCase hotelUseCase;

    public HotelApimpl(HotelUseCase hotelUseCase){
        this.hotelUseCase = hotelUseCase;
    }



}
