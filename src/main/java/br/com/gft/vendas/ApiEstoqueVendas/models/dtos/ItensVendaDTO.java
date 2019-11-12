package br.com.gft.vendas.ApiEstoqueVendas.models.dtos;

import br.com.gft.vendas.ApiEstoqueVendas.models.Produto;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

public class ItensVendaDTO {
    private Integer itvId;
    private Integer itvQtde;
    private BigDecimal itvValor;
    private BigDecimal itvTotal;
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

    public BigDecimal getItvValor() {
        return itvValor;
    }

    public void setItvValor(BigDecimal itvValor) {
        this.itvValor = itvValor;
    }

    public BigDecimal getItvTotal() {
        return itvTotal;
    }

    public void setItvTotal(BigDecimal itvTotal) {
        this.itvTotal = itvTotal;
    }

    public ProdutoDTO getProdutos() {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        BeanUtils.copyProperties(produtos, produtoDTO);
        return produtoDTO;
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }
}
