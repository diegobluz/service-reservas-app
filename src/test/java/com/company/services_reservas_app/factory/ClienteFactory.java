package com.company.services_reservas_app.factory;

import com.company.services_reservas_app.entities.response.ClienteVO;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ClienteFactory {


    public static ClienteVO ClienteVoBuilder() {
        return getClienteVo();
    }

    public static ClienteVO ClienteVoCpfInvalido() {
        ClienteVO cliente = new ClienteVO();
        cliente = getClienteVo();
        cliente.setCpf("000.111.222-00");
        return cliente;
    }

    public static ClienteVO ClienteVoMenorIdade() {
        String date = LocalDate.of(LocalDate.now().getYear(), Month.DECEMBER, 01).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Date dateNasc = DateFactory.parseDate(date, "dd-MM-yyyy");
        ClienteVO cliente = new ClienteVO();
        cliente = getClienteVo();
        cliente.setDataNascimento(dateNasc);
        return cliente;
    }


    private static ClienteVO getClienteVo() {
        String date = LocalDate.of(2000, Month.DECEMBER, 01).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Date dateNasc = DateFactory.parseDate(date, "dd-MM-yyyy");

        ClienteVO cliente = new ClienteVO();
        cliente.setNomeCompleto("Luiz Antonio Vargas");
        cliente.setCpf("62276251751");
        cliente.setEmail("luizvargas@gmail.com");
        cliente.setDataNascimento(dateNasc);
        cliente.setTelefone("51857108885");
        cliente.setSexo("Masculino");

        return cliente;
    }
}
