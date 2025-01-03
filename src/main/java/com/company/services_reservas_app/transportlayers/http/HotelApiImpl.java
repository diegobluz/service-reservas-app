package com.company.services_reservas_app.transportlayers.http;


import com.company.service__reservas_app.transportlayers.openapi.api.ReservasApi;
import com.company.service__reservas_app.transportlayers.openapi.model.RequestReserva;
import com.company.service__reservas_app.transportlayers.openapi.model.ResponseReserva;
import com.company.services_reservas_app.interactors.HotelUseCase;
import com.company.services_reservas_app.transportlayers.http.cliente.ClienteApiImpl;
import com.company.services_reservas_app.transportlayers.mapper.HotelMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HotelApiImpl implements ReservasApi {

    private static final Log LOG = LogFactory.getLog(ClienteApiImpl.class);

    @Autowired(required = true)
    private final HotelUseCase hotelUseCase;

    public HotelApiImpl(HotelUseCase hotelUseCase) {
        this.hotelUseCase = hotelUseCase;
    }


    @Override
    public ResponseEntity<ResponseReserva> createReserva(RequestReserva request) {
        LOG.info("Cadastrando novo cliente");

        HotelMapper.INSTANCE.map(request);

        return ResponseEntity.ok(null);
    }
}
