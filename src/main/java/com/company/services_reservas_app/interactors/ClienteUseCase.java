package com.company.services_reservas_app.interactors;

import com.company.services_reservas_app.config.exceptions.ClienteError;
import com.company.services_reservas_app.datasources.repository.endereco.response.ResponseEndereco;
import com.company.services_reservas_app.entities.response.ClienteVO;
import com.company.services_reservas_app.entities.response.EnderecoVO;
import com.company.services_reservas_app.repositories.ClienteRepository;
import com.company.services_reservas_app.repositories.EnderecoRepository;
import com.company.services_reservas_app.utils.DateUtils;
import com.company.services_reservas_app.utils.ValidadorCPF;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteUseCase {

    private static final Log LOG = LogFactory.getLog(ClienteUseCase.class);

    private static String MSG_CLIENTE_JA_CADASTRADO = "Cliente já cadastrado na base de dados.";
    private static String MSG_CPF_OBIRIGATORIO = "O CPF não pode ser null e deve ser valido.";
    private static String MSG_ENDERECO_INVALIDO = "O cep informadao não é valido.";
    private static String MSG_CPF_INVALIDO = "O CPF deve ser valido.";

    private static String MSG_CLIENTE_MENOR_IDADE = "Não é possível cadastrar um cliente menor de idade.";


    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;


    public ClienteUseCase(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }


    public Optional<ClienteVO> execute(ClienteVO cliente) {

        Optional<ClienteVO> responseCliente = Optional.empty();
        try {
            /*
             * verifica se cpf é valido
             */
            validarCpf(cliente);

            /*
             * Verifica cliente na base de dados
             */
            obterCliente(cliente.getCpf());

            /*
             * Valida se cliente é maior de 18
             */
            validarDataNasc(cliente.getDataNascimento());
            /*
             * Validar cep do cliente
             */
            EnderecoVO requestEndereco = cliente.getEndereco();
            ResponseEndereco endereco = obterEndereco(requestEndereco);

            responseCliente = saveCliente(cliente, endereco, requestEndereco);
        }catch (ClienteError e){

            LOG.error("Cliente Error: " + e.getStatus() +  " -  Code: "+e.getCode() + " -  descricao: "+ e.getDescription());
            throw new ClienteError( e.getStatus(), e.getCode(), e.getDescription());
        }
        catch (Exception e){

            LOG.error(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            throw new ClienteError(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR), "INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }

        return responseCliente;
    }

    private Optional<ClienteVO> saveCliente(ClienteVO cliente, ResponseEndereco responseEndereco, EnderecoVO requestEndereco) {
        EnderecoVO enderecoBuilder = enderecoBuilder(responseEndereco, cliente.getCpf(), requestEndereco);

        EnderecoVO endereco = enderecoRepository.save(enderecoBuilder);
        cliente.setEndereco(endereco);
        ClienteVO save = clienteRepository.save(cliente);
        return clienteBuilder(save, endereco);
    }

    private Optional<ClienteVO> clienteBuilder(ClienteVO cliente, EnderecoVO endereco) {
        cliente.setEndereco(endereco);
        return Optional.of(cliente);
    }


    private EnderecoVO enderecoBuilder(ResponseEndereco endereco, String cpf, EnderecoVO requestEndereco) {

        EnderecoVO vo = new EnderecoVO();

        vo.setCep(endereco.getCep());
        vo.setLogradouro(endereco.getLogradouro());
        vo.setBairro(endereco.getBairro());
        vo.setNumero(requestEndereco.getNumero());
        vo.setComplemento(requestEndereco.getComplemento());
        vo.setUf(endereco.getUf());
        vo.setLocalidade(endereco.getLocalidade());
        vo.setCpfCliente(cpf);
        return vo;
    }

    private ResponseEndereco obterEndereco(EnderecoVO end) {
        ResponseEndereco endereco = enderecoRepository.obterEnderecoCep(end.getCep());

        if (Objects.isNull(endereco)) {
            LOG.info(MSG_ENDERECO_INVALIDO);
            throw new ClienteError(String.valueOf(HttpStatus.BAD_REQUEST.value()), "ERROR_CEP_INVALIDO", MSG_ENDERECO_INVALIDO);
        }
        return endereco;
    }


    private void validarCpf(ClienteVO cliente){
        LOG.info("Validando o CPF");
        boolean isCPF = ValidadorCPF.isValid(cliente.getCpf());

        if (Strings.isEmpty(cliente.getCpf()) || !isCPF) {
            LOG.info(MSG_CPF_OBIRIGATORIO);
            throw new ClienteError(String.valueOf(HttpStatus.BAD_REQUEST.value()), "ERROR_CPF_INVALIDO", MSG_CPF_OBIRIGATORIO);
        }
    }

    private void obterCliente(String cpf){

        LOG.info("Verificar na base de dados o CPF do cliente");

        ClienteVO cliente = clienteRepository.obterCpf(cpf);

        if (Objects.nonNull(cliente)) { // Ou pode usar  !Objects.isNull(cliente)
            LOG.info(MSG_CLIENTE_JA_CADASTRADO);
            throw new ClienteError(String.valueOf(HttpStatus.BAD_REQUEST.value()),"ERROR_CPF_CADASTRADO", MSG_CLIENTE_JA_CADASTRADO);
        }
    }

    private void validarDataNasc(Date date) {

        LocalDate dataNasc = DateUtils.parseLocalDate(date);

        Period idade = Period.between(dataNasc, LocalDate.now());
        boolean isMaioridade = idade.getYears() < 18;

        if (isMaioridade) {
            LOG.info(MSG_CLIENTE_MENOR_IDADE);
            throw new ClienteError(String.valueOf(HttpStatus.BAD_REQUEST.value()),"ERROR_DATA_NASCIMENTO", MSG_CLIENTE_MENOR_IDADE);
        }
    }






}
