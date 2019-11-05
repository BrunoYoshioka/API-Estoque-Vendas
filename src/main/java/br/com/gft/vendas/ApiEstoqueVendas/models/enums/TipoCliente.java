package br.com.gft.vendas.ApiEstoqueVendas.models.enums;

public enum TipoCliente {
	
	PESSOA_FISICA(1, "PESSOA FÍSICA"),
	PESSOA_JURIDICA(2, "PESSOA JURÍDICA");

	private Integer id;
	private String descricao;

	TipoCliente(Integer id, String descricao) {
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
