package com.company.services_reservas_app.transportlayers.impl.http;

import com.company.services_reservas_app.entities.Reserva;
import com.company.services_reservas_app.interactors.HotelUseCase;
import com.company.services_reservas_app.mapper.HotelMapper;
import com.company.services_reservas_app.transportlayers.openapi.api.SistemaDeReservaApi;
import com.company.services_reservas_app.transportlayers.openapi.model.ReservaRequest;
import com.company.services_reservas_app.transportlayers.openapi.model.ReservaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

//RestController define a classe como controlador da API REST
@RestController
//RequestMapping é usada para mapear requisições web para os métodos criados dentro de uma controller
@RequestMapping("/")
public class HotelApiImpl implements SistemaDeReservaApi {

    @Autowired(required = true)
    private HotelUseCase hotelUseCase;

    public HotelApiImpl(HotelUseCase hotelUseCase){
        this.hotelUseCase = hotelUseCase;
    }
    //Pedido
    @Override
    public ResponseEntity<ReservaResponse> reservaId(ReservaRequest reservaRequest) {
       Reserva reserva = HotelMapper.INSTANCE.map(reservaRequest);
       hotelUseCase.execute(reserva);
       ReservaResponse reservaResponse = HotelMapper.INSTANCE.mapResponse("Nome", LocalDate.now().toString(),LocalDate.now().toString(),"1");
       return ResponseEntity.ok(reservaResponse);
    }
}