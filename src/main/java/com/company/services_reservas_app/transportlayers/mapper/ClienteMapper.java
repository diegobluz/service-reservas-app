package com.company.services_reservas_app.transportlayers.mapper;

import com.company.service__reservas_app.transportlayers.openapi.model.RequestCliente;
import com.company.service__reservas_app.transportlayers.openapi.model.RequestEndereco;
import com.company.service__reservas_app.transportlayers.openapi.model.ResponseCliente;
import com.company.services_reservas_app.entities.response.ClienteVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.text.SimpleDateFormat;
import java.util.Date;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mappings({
            @Mapping(source = "request.nomeCompleto", target = "nomeCompleto"),
            @Mapping(source = "request.telefone", target = "telefone"),
            @Mapping(source = "request.email", target = "email"),
            @Mapping(source = "request.cpf", target = "cpf"),
            @Mapping(source = "request.dataNascimento", target = "dataNascimento", dateFormat = "dd-MM-yyyy"),
            @Mapping(source = "request.sexo", target = "sexo"),
            @Mapping(source = "endereco", target = "endereco")
    })
    ClienteVO map(RequestCliente request, RequestEndereco endereco);


    @Mapping(source = "vo.nomeCompleto", target = "nomeCompleto")
    @Mapping(source = "vo.telefone", target = "telefone")
    @Mapping(source = "vo.email", target = "email")
    @Mapping(source = "vo.cpf", target = "cpf")
    @Mapping(source = "vo.dataNascimento", target = "dataNascimento", qualifiedByName = "convertDataNascimento" )
    @Mapping(source = "vo.sexo", target = "sexo")
    ResponseCliente mapResponse(ClienteVO vo);


    @Named("convertDataNascimento")
    default String convertDataNascimento(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }

}
