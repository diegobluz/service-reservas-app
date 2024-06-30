package com.company.services_reservas_app.transportlayers.impl.http;

import com.company.services_reservas_app.entities.Cliente;
import com.company.services_reservas_app.interactors.ClienteUseCase;
import com.company.services_reservas_app.transportlayers.openapi.api.SistemaDeReservaApi;
import com.company.services_reservas_app.transportlayers.openapi.model.ClienteRequest;
import com.company.services_reservas_app.mapper.ClienteMapper;
import com.company.services_reservas_app.transportlayers.openapi.model.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClienteApiImpl implements SistemaDeReservaApi {
    @Autowired(required = true)
    private final ClienteUseCase clienteUseCase;


    //iniciando a classe
    public ClienteApiImpl(ClienteUseCase clienteUseCase){
        this.clienteUseCase = clienteUseCase;
    }
    //endpoint de criação de um cliente
    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrarCliente(ClienteRequest clienteRequest){
        //Mapeia o objeto ClienteReuqest para o obj cliente usando o mapper
        Cliente cliente = ClienteMapper.INSTANCE.map(clienteRequest);
        //executa a regra de negocio dentro do UseCase
        clienteUseCase.execute(cliente);
        //mapeia a resposta do cliente para o obj ClienteResponse, preenchendo os campos necessarios
       ClienteResponse clienteResponse = ClienteMapper.INSTANCE.mapResponse("Nome", "Telefone", "Email", "CPF", "dataNascimento", "sexo", cliente.getEndereco());
        //retorna a resposta do cliente dentro de um response entity com status http 200 de OK
        return ResponseEntity.ok(clienteResponse);
    }
}
