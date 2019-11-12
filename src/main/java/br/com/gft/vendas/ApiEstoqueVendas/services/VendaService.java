package br.com.gft.vendas.ApiEstoqueVendas.services;

import br.com.gft.vendas.ApiEstoqueVendas.exceptions.ObjectNotFoundException;
import br.com.gft.vendas.ApiEstoqueVendas.models.Venda;
import br.com.gft.vendas.ApiEstoqueVendas.models.dtos.VendaDTO;
import br.com.gft.vendas.ApiEstoqueVendas.models.dtos.VendaAtualizarDTO;
import br.com.gft.vendas.ApiEstoqueVendas.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private JmsTemplate jmsTemplate;

    public Page<VendaDTO> listar(Pageable paginacao) {
        return VendaDTO.converter(vendaRepository.findAll(paginacao));
    }

    public Venda encontrarPorId(Integer id) {
        Optional<Venda> optionalVenda = vendaRepository.findById(id);
        return optionalVenda.orElseThrow(() -> new ObjectNotFoundException(
                "Venda com id " + id + "não encontrado!, Tipo " + Venda.class.getName()
        ));
    }

    public Venda cadastrar(Venda venda) {
        venda.setVenId(null);
        venda = vendaRepository.save(venda);
        jmsTemplate.convertAndSend("vendaQueue", venda);
        return venda;
    }

    public Venda atualizar(VendaAtualizarDTO form, Integer id) {
        Venda venda = encontrarPorId(id);
        venda.setVenStatus(form.getVenStatus());
        return venda;
    }
}
