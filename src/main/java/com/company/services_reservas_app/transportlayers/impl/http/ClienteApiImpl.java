package com.company.services_reservas_app.transportlayers.impl.http;

import com.company.services_reservas_app.entities.Cliente;
import com.company.services_reservas_app.interactors.ClienteUseCase;
import com.company.services_reservas_app.transportlayers.openapi.api.CreateClientApi;
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
public class ClienteApiImpl implements CreateClientApi {
    @Autowired(required = true)
    private final ClienteUseCase clienteUseCase;

    public ClienteApiImpl(ClienteUseCase clienteUseCase){
        this.clienteUseCase = clienteUseCase;
    }

    @Override
    public ResponseEntity<ClienteResponse> addClient(ClienteRequest clienteRequest) {
        Cliente cliente = ClienteMapper.INSTANCE.map(clienteRequest);
        //clienteUseCase.execute(cliente);
        ClienteResponse clienteResponse = ClienteMapper.INSTANCE.mapResponse("Nome", "Telefone", "Email", "CPF", "dataNascimento", "sexo");
        return ResponseEntity.ok(clienteResponse);
    }

}
