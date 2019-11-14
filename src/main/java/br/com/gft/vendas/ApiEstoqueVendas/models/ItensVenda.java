package br.com.gft.vendas.ApiEstoqueVendas.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ItensVenda {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itvId;
	private Integer itvQtde;
	private BigDecimal itvValor;
	private BigDecimal itvTotal;

	@JsonIgnore
	@ManyToOne
	private Venda venda;

	@ManyToOne
	private Produto produtos;
	
	
	public ItensVenda() {
	}
	
	//construtor para q toda vez estancia e cria um objeto
	public ItensVenda(Integer itvQtde, BigDecimal itvValor, BigDecimal itvTotal, Produto produtos) {
		this.itvQtde = itvQtde;
		this.itvValor = itvValor;
		this.itvTotal = itvTotal;
		this.produtos = produtos;
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

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itvId == null) ? 0 : itvId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensVenda other = (ItensVenda) obj;
		if (itvId == null) {
			if (other.itvId != null)
				return false;
		} else if (!itvId.equals(other.itvId))
			return false;
		return true;
	}

}
