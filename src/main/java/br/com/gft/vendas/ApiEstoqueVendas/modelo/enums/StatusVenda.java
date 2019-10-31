package br.com.gft.vendas.ApiEstoqueVendas.modelo.enums;

public enum StatusVenda {
    PAGO(1, "Pago"),
    CANCELADO(2, "Cancelado"),
    PENDENTE(3, "Pendente");

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
