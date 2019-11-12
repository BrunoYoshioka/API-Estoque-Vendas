package br.com.gft.vendas.ApiEstoqueVendas.models.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoDTO {

    private Integer id;
    private String prodNome;
    private String prodDescricao;
    private BigDecimal prodValorpago;
    private BigDecimal prodValorvenda;
    private Float prodQtde;
    private LocalDateTime prodDtCadastro = LocalDateTime.now();

    public ProdutoDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProdNome() {
        return prodNome;
    }

    public void setProdNome(String prodNome) {
        this.prodNome = prodNome;
    }

    public String getProdDescricao() {
        return prodDescricao;
    }

    public void setProdDescricao(String prodDescricao) {
        this.prodDescricao = prodDescricao;
    }

    public BigDecimal getProdValorpago() {
        return prodValorpago;
    }

    public void setProdValorpago(BigDecimal prodValorpago) {
        this.prodValorpago = prodValorpago;
    }

    public BigDecimal getProdValorvenda() {
        return prodValorvenda;
    }

    public void setProdValorvenda(BigDecimal prodValorvenda) {
        this.prodValorvenda = prodValorvenda;
    }

    public Float getProdQtde() {
        return prodQtde;
    }

    public void setProdQtde(Float prodQtde) {
        this.prodQtde = prodQtde;
    }

    public LocalDateTime getProdDtCadastro() {
        return prodDtCadastro;
    }

    public void setProdDtCadastro(LocalDateTime prodDtCadastro) {
        this.prodDtCadastro = prodDtCadastro;
    }
}
