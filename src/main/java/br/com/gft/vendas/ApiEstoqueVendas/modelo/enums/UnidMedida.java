package br.com.gft.vendas.ApiEstoqueVendas.modelo.enums;

public enum UnidMedida {
	
	UNITARIO(1, "Unitário"),
	METRO(2, "Metro"),
	KG(3, "KG"),
	CAIXA(4, "Caixa"),
	PACOTE(5, "Pacote"),
	LITRO(6, "Litro"),
	KIT(7, "Kit"),
	SERVICO(8, "Serviço");

	private Integer id;
	private String descricao;

	UnidMedida(Integer id, String descricao) {
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
