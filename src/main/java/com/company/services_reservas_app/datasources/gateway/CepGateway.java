package com.company.services_reservas_app.datasources.gateway;

import com.company.services_reservas_app.datasources.repository.endereco.response.ResponseEndereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface CepGateway {

    @GetMapping("/{cep}/json")
    ResponseEndereco getEndereco(@PathVariable("cep") String cep);
}
