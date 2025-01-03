package com.company.services_reservas_app.transportlayers.mapper;

import com.company.service__reservas_app.transportlayers.openapi.model.RequestReserva;
import com.company.service__reservas_app.transportlayers.openapi.model.ResponseReserva;
import com.company.services_reservas_app.entities.response.ReservaVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface HotelMapper {
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    ReservaVO map(RequestReserva nome);
    @Mapping(source = "vo.nomeCliente", target = "nomeCliente")
    @Mapping(source = "vo.dataEntrada", target = "dataEntrada")
    @Mapping(source = "vo.dataSaida", target = "dataSaida")
    @Mapping(source = "vo.numeroHospedes", target = "numeroHospedes")
    ResponseReserva mapResponse(ReservaVO vo);


}
