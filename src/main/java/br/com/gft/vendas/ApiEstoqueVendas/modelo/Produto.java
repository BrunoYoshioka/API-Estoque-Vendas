package br.com.gft.vendas.ApiEstoqueVendas.modelo;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.enums.UnidMedida;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long prodId;
	private String prodNome;
	private String prodDescricao;
	private Float prodValorpago;
	private Float prodValorvenda;
	private Float prodQtde;
	private LocalDateTime prodDtCadastro = LocalDateTime.now(); 
	@Enumerated(EnumType.STRING)
	private UnidMedida unidMedida = UnidMedida.UNITARIO; // Deixar Unitário no padrão.
	// Muitos Produtos podem ter uma categoria
	@ManyToOne
	private Categoria categoria;
	// Muitos Produtos podem ter uma subcategoria
	@ManyToOne
	private SubCategoria subCategoria;
	
	
	
	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
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

	public Float getProdValorpago() {
		return prodValorpago;
	}

	public void setProdValorpago(Float prodValorpago) {
		this.prodValorpago = prodValorpago;
	}

	public Float getProdValorvenda() {
		return prodValorvenda;
	}

	public void setProdValorvenda(Float prodValorvenda) {
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

	public UnidMedida getUnidMedida() {
		return unidMedida;
	}

	public void setUnidMedida(UnidMedida unidMedida) {
		this.unidMedida = unidMedida;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public SubCategoria getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}

	// Sobrescrita dos Métodos equals e hashCode para otimizar a consulta dos objetos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prodId == null) ? 0 : prodId.hashCode());
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
		Produto other = (Produto) obj;
		if (prodId == null) {
			if (other.prodId != null)
				return false;
		} else if (!prodId.equals(other.prodId))
			return false;
		return true;
	}

}
