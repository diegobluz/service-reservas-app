package com.company.services_reservas_app.interactors;

import com.company.services_reservas_app.config.exceptions.ClienteError;
import com.company.services_reservas_app.entities.response.ClienteVO;
import com.company.services_reservas_app.entities.response.EnderecoVO;
import com.company.services_reservas_app.factory.ClienteFactory;
import com.company.services_reservas_app.repositories.ClienteRepository;
import com.company.services_reservas_app.repositories.EnderecoRepository;
import com.company.services_reservas_app.repositories.HotelRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ClienteUseCaseTest {

    @InjectMocks
    private ClienteUseCase clienteUseCase;

    @Mock
    private ClienteRepository clienteRepository;

    private ClienteVO clienteVO;

    @Mock
    private EnderecoRepository enderecoRepository;

    private EnderecoVO enderecoVO;




    @Test
    void cadastrar_cliente_com_sucesso() {

        ClienteVO clienteVO = ClienteFactory.ClienteVoBuilder();


        Mockito.when(clienteRepository.obterCpf(anyString()))
                .thenReturn(null);

        Mockito.when(clienteRepository.save(any()))
                .thenReturn(clienteVO);


        Optional<ClienteVO> response = clienteUseCase.execute(clienteVO);
        Assertions.assertNotNull(response);
    }

    @Test
    void error_cadastrar_cliente_cpf_invalido() {

        ClienteVO clienteVO = ClienteFactory.ClienteVoCpfInvalido();

        assertThrows(ClienteError.class, () -> clienteUseCase.execute(clienteVO));
    }

    @Test
    void error_cliente_ja_cadastrado_na_base() {

        ClienteVO clienteVO = ClienteFactory.ClienteVoBuilder();

        Mockito.when(clienteRepository.obterCpf(anyString()))
                .thenReturn(clienteVO);

        assertThrows(ClienteError.class, () -> clienteUseCase.execute(clienteVO));
    }


    @Test
    void  error_cadastrar_cliente_menor_de_idade() {

        ClienteVO clienteVO = ClienteFactory.ClienteVoMenorIdade();

        assertThrows(ClienteError.class, () -> clienteUseCase.execute(clienteVO));

    }


    @Test
    void error_cliente_exception() {

        ClienteVO clienteVO = ClienteFactory.ClienteVoBuilder();

        assertThrows(ClienteError.class, () -> clienteUseCase.execute(clienteVO));
    }

}