package br.com.gft.vendas.ApiEstoqueVendas.models;

import br.com.gft.vendas.ApiEstoqueVendas.models.enums.UnidMedida;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Produto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty @NotNull @Length(min=5)
	private String prodNome;
	@NotEmpty @NotNull @Length(min=5)
	private String prodDescricao;
	private BigDecimal prodValorpago;
	private BigDecimal prodValorvenda;
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
	
	
	
	public Integer getProdId() {
		return id;
	}

	public void setProdId(Integer prodId) {
		this.id = prodId;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto {id=" + id + ", prodNome=" + prodNome + ", prodDescricao=" + prodDescricao + ", prodValorpago="
				+ prodValorpago + ", prodValorvenda=" + prodValorvenda + ", prodQtde=" + prodQtde + ", prodDtCadastro="
				+ prodDtCadastro + ", unidMedida=" + unidMedida + ", categoria=" + categoria + ", subCategoria="
				+ subCategoria + "}";
	}

}
