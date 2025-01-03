package com.company.services_reservas_app.transportlayers.http.cliente;

import com.company.service__reservas_app.transportlayers.openapi.api.ClienteApi;
import com.company.service__reservas_app.transportlayers.openapi.model.RequestCliente;
import com.company.service__reservas_app.transportlayers.openapi.model.ResponseCliente;
import com.company.services_reservas_app.entities.response.ClienteVO;
import com.company.services_reservas_app.interactors.ClienteUseCase;
import com.company.services_reservas_app.transportlayers.mapper.ClienteMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class ClienteApiImpl implements ClienteApi {

    private static final Log LOG = LogFactory.getLog(ClienteApiImpl.class);

    @Autowired(required = true)
    private final ClienteUseCase clienteUseCase;

    public ClienteApiImpl(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }

    @Override
    public ResponseEntity<ResponseCliente> createClient(RequestCliente clienteRequest) {
        LOG.info("Cadastrando novo cliente");

        ClienteVO vo = ClienteMapper.INSTANCE.map(clienteRequest, clienteRequest.getEndereco());

        Optional<ClienteVO> opCliente = clienteUseCase.execute(vo);

        ResponseCliente clienteResponse = ClienteMapper.INSTANCE.mapResponse(opCliente.get());

        return ResponseEntity.ok(clienteResponse);
    }


}
