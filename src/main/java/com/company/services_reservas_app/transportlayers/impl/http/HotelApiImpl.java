package com.company.services_reservas_app.transportlayers.impl.http;


import com.company.service__reservas_app.transportlayers.openapi.api.CreateReserveApi;
import com.company.service__reservas_app.transportlayers.openapi.model.ReservaRequest;
import com.company.service__reservas_app.transportlayers.openapi.model.ReservaResponse;
import com.company.services_reservas_app.entities.Reserva;
import com.company.services_reservas_app.interactors.HotelUseCase;
import com.company.services_reservas_app.transportlayers.impl.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;

@RestController
@RequestMapping("/")
public class HotelApiImpl implements CreateReserveApi {

    @Autowired(required = true)
    private HotelUseCase hotelUseCase;

    public HotelApiImpl(HotelUseCase hotelUseCase) {
        this.hotelUseCase = hotelUseCase;
    }

    @Override
    public ResponseEntity<ReservaResponse> addReserve(ReservaRequest reservaRequest) {
        Reserva reserva = HotelMapper.INSTANCE.map(reservaRequest);
        //hotelUseCase.execute(reserva);
        ReservaResponse reservaResponse = HotelMapper.INSTANCE.mapResponse("Nome", LocalDate.now().toString(), LocalDate.now().toString(), "1");
        return ResponseEntity.ok(reservaResponse);
    }
}
