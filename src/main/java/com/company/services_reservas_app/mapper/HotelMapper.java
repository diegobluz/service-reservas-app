package com.company.services_reservas_app.mapper;



import com.company.services_reservas_app.entities.Reserva;
import com.company.services_reservas_app.transportlayers.openapi.model.ReservaRequest;
import com.company.services_reservas_app.transportlayers.openapi.model.ReservaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelMapper {
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

   Reserva map(ReservaRequest nome);
   @Mapping(source = "nomeCliente", target = "nomeCliente")
   @Mapping(source = "dataEntrada", target = "dataEntrada")
   @Mapping(source = "dataSaida", target = "dataSaida")
   @Mapping(source = "numeroHospedes", target = "numeroHospedes")
   ReservaResponse mapResponse(String nomeCliente, String dataEntrada, String dataSaida, String numeroHospedes);


}
