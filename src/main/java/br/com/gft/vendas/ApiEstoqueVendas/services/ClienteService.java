package br.com.gft.vendas.ApiEstoqueVendas.services;

import br.com.gft.vendas.ApiEstoqueVendas.exceptions.ObjectNotFoundException;
import br.com.gft.vendas.ApiEstoqueVendas.models.Cliente;
import br.com.gft.vendas.ApiEstoqueVendas.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Page<Cliente> listar(Pageable paginacao) {
        return clienteRepository.findAll(paginacao);
    }

    public Cliente encontrarPorId(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente com id " + id + " não encontrado! Tipo " + Cliente.class.getName()
        ));
    }

    public Cliente cadastrar(Cliente cliente) {
        cliente.setId(null);
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Integer id, Cliente cliente) {
        Cliente clienteEncontradoPorId = encontrarPorId(id);
        clienteEncontradoPorId.setId(cliente.getId());
        clienteEncontradoPorId.setCliBairro(cliente.getCliBairro());
        clienteEncontradoPorId.setCliCel(cliente.getCliCel());
        clienteEncontradoPorId.setCliCep(cliente.getCliCep());
        clienteEncontradoPorId.setCliCidade(cliente.getCliCidade());
        clienteEncontradoPorId.setCliCpfcnpj(cliente.getCliCpfcnpj());
        clienteEncontradoPorId.setCliEmail(cliente.getCliEmail());
        clienteEncontradoPorId.setCliEndereco(cliente.getCliEndnumero());
        clienteEncontradoPorId.setCliEstado(cliente.getCliEstado());
        clienteEncontradoPorId.setCliEndnumero(cliente.getCliEndnumero());
        clienteEncontradoPorId.setCliFone(cliente.getCliFone());
        clienteEncontradoPorId.setCliNome(cliente.getCliNome());
        clienteEncontradoPorId.setCliRgIe(cliente.getCliRgIe());
        clienteEncontradoPorId.setCliRsocial(cliente.getCliRsocial());
        clienteEncontradoPorId.setCliTipo(cliente.getCliTipo());
        return clienteRepository.save(clienteEncontradoPorId);
    }

    public void deletar(Integer id) {
        Cliente cliente = encontrarPorId(id);
        clienteRepository.delete(cliente);
    }
}