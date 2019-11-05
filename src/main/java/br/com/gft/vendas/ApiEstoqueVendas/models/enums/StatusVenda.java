package br.com.gft.vendas.ApiEstoqueVendas.models.enums;

public enum StatusVenda {
    ATIVA(1, "Ativa"),
    PAGO(2, "Pago"),
    CANCELADO(3, "Cancelado"),
    PENDENTE(4, "Pendente");

    private Integer id;
    private String descricao;

    StatusVenda(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
