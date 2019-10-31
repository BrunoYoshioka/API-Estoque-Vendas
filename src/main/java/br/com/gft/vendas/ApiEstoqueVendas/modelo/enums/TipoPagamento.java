package br.com.gft.vendas.ApiEstoqueVendas.modelo.enums;

public enum TipoPagamento {
	
	A_VISTA(1, "A vista"),
	A_PRAZO(2, "A prazo");

	private Integer id;
	private String descricao;

	TipoPagamento(Integer id, String descricao) {
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
