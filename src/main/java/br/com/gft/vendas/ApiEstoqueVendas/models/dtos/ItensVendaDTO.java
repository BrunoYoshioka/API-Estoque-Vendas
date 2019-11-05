package br.com.gft.vendas.ApiEstoqueVendas.models.dtos;

import br.com.gft.vendas.ApiEstoqueVendas.models.Produto;
import br.com.gft.vendas.ApiEstoqueVendas.utils.ObjectMapperUtils;

public class ItensVendaDTO {
    private Integer itvId;
    private Integer itvQtde;
    private Double itvValor;
    private Double itvTotal;
    private Produto produtos;

    public ItensVendaDTO() {
    }

    public Integer getItvId() {
        return itvId;
    }

    public void setItvId(Integer itvId) {
        this.itvId = itvId;
    }

    public Integer getItvQtde() {
        return itvQtde;
    }

    public void setItvQtde(Integer itvQtde) {
        this.itvQtde = itvQtde;
    }

    public Double getItvValor() {
        return itvValor;
    }

    public void setItvValor(Double itvValor) {
        this.itvValor = itvValor;
    }

    public Double getItvTotal() {
        return itvTotal;
    }

    public void setItvTotal(Double itvTotal) {
        this.itvTotal = itvTotal;
    }

    public ProdutoDTO getProdutos() {
        return ObjectMapperUtils.map(produtos, ProdutoDTO.class);
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }
}
