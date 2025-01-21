package com.company.services_reservas_app.datasources.repository.endereco;

import com.company.services_reservas_app.datasources.gateway.CepGateway;
import com.company.services_reservas_app.datasources.repository.endereco.response.ResponseEndereco;
import com.company.services_reservas_app.datasources.repository.EnderecoRepositoryJPA;
import com.company.services_reservas_app.datasources.repository.mapper.EnderecoMapper;
import com.company.services_reservas_app.entities.Endereco;
import com.company.services_reservas_app.entities.response.EnderecoVO;
import com.company.services_reservas_app.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EnderecoDataSourceImpl implements EnderecoRepository {

    @Autowired
    private EnderecoRepositoryJPA enderecoRepository;

    @Autowired
    private CepGateway cepGateway;


    public EnderecoDataSourceImpl(EnderecoRepositoryJPA enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }


    @Override
    public ResponseEndereco obterEnderecoCep(String cep) {
        return cepGateway.getEndereco(cep);
    }

    @Override
    public EnderecoVO obterEnderecoCpf(String cpf) {
        Endereco entity = enderecoRepository.findByCpf(cpf);
        return EnderecoMapper.INSTANCE.map(entity);
    }

    @Override
    public EnderecoVO save(EnderecoVO vo) {
        Endereco endereco = toEnderecoBuilder(vo);
        Endereco entity = enderecoRepository.save(endereco);
        return EnderecoMapper.INSTANCE.map(entity);
    }

    private Endereco toEnderecoBuilder(EnderecoVO vo) {
        Endereco endereco = new Endereco();
        endereco.setCep(vo.getCep());
        endereco.setLogradouro(vo.getLogradouro());
        endereco.setBairro(vo.getBairro());
        endereco.setNumero(vo.getNumero());
        endereco.setComplemento(vo.getComplemento());
        endereco.setUf(vo.getUf());
        endereco.setLocalidade(vo.getLocalidade());
        endereco.setCpf(vo.getCpfCliente());
        endereco.setDataCadastro(LocalDateTime.now());
        endereco.setDataUltimaAtualizacao(LocalDateTime.now());
        return endereco;
    }
}
