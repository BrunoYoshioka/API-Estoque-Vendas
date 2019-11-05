package br.com.gft.vendas.ApiEstoqueVendas.models.dtos;

import br.com.gft.vendas.ApiEstoqueVendas.models.Venda;
import br.com.gft.vendas.ApiEstoqueVendas.utils.ObjectMapperUtils;
import org.springframework.data.domain.Page;

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

    public Float venDesconto() {
        return venda.getVenDesconto();
    }

    public Float getVenValorPago() {
        return venda.getVenValorPago();
    }

    public Float getVenTroco() {
        return venda.getVenTroco();
    }

    public List<ItensVendaDTO> getItensVenda() {
        return ObjectMapperUtils.mapAll(venda.getItensVenda(), ItensVendaDTO.class);
    }

    public static Page<VendaDTO> converter(Page<Venda> vendas) {
        return vendas.map(VendaDTO::new);
    }
}
