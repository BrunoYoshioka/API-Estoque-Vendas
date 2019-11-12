package br.com.gft.vendas.ApiEstoqueVendas.models.dtos;

import br.com.gft.vendas.ApiEstoqueVendas.models.ItensVenda;
import br.com.gft.vendas.ApiEstoqueVendas.models.Venda;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendaDTO {

    private Venda venda;

    private VendaDTO(Venda venda) {
        this.venda = venda;
    }

    public Integer getVendaId() {
        return venda.getVenId();
    }

    public Long getVenNfiscal() {
        return venda.getVenNfiscal();
    }

    public Long getVenNParcelas() {
        return venda.getVenNparcelas();
    }

    public BigDecimal venDesconto() {
        return venda.getVenDesconto();
    }

    public BigDecimal getVenValorPago() {
        return venda.getVenValorPago();
    }

    public BigDecimal getVenTroco() {
        return venda.getVenTroco();
    }

    public List<ItensVendaDTO> getItensVenda() {
        List<ItensVendaDTO> itensVendaDTO = new ArrayList<>();
        for(ItensVenda itensVenda: venda.getItensVenda()) {
            ItensVendaDTO itemVendaDto = new ItensVendaDTO();
            BeanUtils.copyProperties(itensVenda , itemVendaDto);
            itensVendaDTO.add(itemVendaDto);
        }
        return itensVendaDTO;
    }

    public static Page<VendaDTO> converter(Page<Venda> vendas) {
        return vendas.map(VendaDTO::new);
    }
}
