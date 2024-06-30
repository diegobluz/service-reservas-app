package com.company.services_reservas_app.mapper;

import com.company.services_reservas_app.entities.Cliente;
import com.company.services_reservas_app.entities.Endereco;
import com.company.services_reservas_app.transportlayers.openapi.model.ClienteRequest;
import com.company.services_reservas_app.transportlayers.openapi.model.ClienteResponse;
import org.mapstruct.Mapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente map(ClienteRequest cliente);

    @Mapping(source = "nomeCompleto", target = "nomeCompleto")
    @Mapping(source = "telefone", target = "telefone")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "dataNascimento", target = "dataNascimento")
    @Mapping(source = "sexo", target = "sexo")
    @Mapping(source = "endereco", target = "endereco")
    ClienteResponse mapResponse(String nomeCompleto, String telefone, String email, String cpf, String dataNascimento, String sexo, Endereco endereco);


}


