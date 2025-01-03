package com.company.services_reservas_app.datasources.repository.cliente;

import com.company.services_reservas_app.datasources.repository.ClienteRepositoryJPA;
import com.company.services_reservas_app.datasources.repository.mapper.ClienteMapper;
import com.company.services_reservas_app.entities.Cliente;
import com.company.services_reservas_app.entities.response.ClienteVO;
import com.company.services_reservas_app.repositories.ClienteRepository;
import com.company.services_reservas_app.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClienteDataSourceImpl implements ClienteRepository {

    @Autowired
    private ClienteRepositoryJPA clienteRepository;

    public ClienteDataSourceImpl(ClienteRepositoryJPA clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public ClienteVO obterCpf(String cpf) {
        /*
         * Consulta na base o cpf do cliente
         */
        Cliente cliente = clienteRepository.findByCpf(cpf);
        if (cliente != null) { // Poderia usar !Objects.isNull(cliente)
            String dtNasc = converterDataNascimento(cliente.getDataNascimento());
            return ClienteMapper.INSTANCE.map(cliente, dtNasc);
        }
        return null;
    }


    public ClienteVO save(ClienteVO vo) {

        Cliente cliente = clienteBuilder(vo);
        Cliente entity = clienteRepository.save(cliente);

        return ClienteMapper.INSTANCE.map(entity);
    }

    private Cliente clienteBuilder(ClienteVO vo) {
        Cliente cliente = new Cliente();
        cliente.setNomeCompleto(vo.getNomeCompleto());
        cliente.setCpf(vo.getCpf());
        cliente.setEmail(vo.getEmail());
        cliente.setDataNascimento(vo.getDataNascimento());
        cliente.setTelefone(vo.getTelefone());
        cliente.setSexo(vo.getSexo());
        //cliente.setEndereco(vo.getEndereco());
        return cliente;
    }

    private String converterDataNascimento(Date datetNasc) {
        /*
         * DataUtils - formata a data conforme o necessario
         *      obtem a data do banco no formato YYYY-MM-DD e converte para DD-MM-YYYY
         */
        String dtNasc = DateUtils.convertDateFormat(datetNasc.toString(),
                DateUtils.DATE_FORMAT_YYYY_MM_DD,
                DateUtils.DATE_FORMAT_DD_MM_YYYY);
        return dtNasc;
    }




}
