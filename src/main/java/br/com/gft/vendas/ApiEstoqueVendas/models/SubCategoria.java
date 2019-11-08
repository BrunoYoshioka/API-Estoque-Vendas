package br.com.gft.vendas.ApiEstoqueVendas.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class SubCategoria {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer scatId;
	@NotNull @NotEmpty @Length(min=3)
	private String scatNome;
	@ManyToOne
	private Categoria categoria;
	
	
	public Integer getScatId() {
		return scatId;
	}

	public void setScatId(Integer scatId) {
		this.scatId = scatId;
	}

	public String getScatNome() {
		return scatNome;
	}

	public void setScatNome(String scatNome) {
		this.scatNome = scatNome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// Sobrescrita dos Métodos equals e hashCode para otimizar a consulta dos objetos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scatId == null) ? 0 : scatId.hashCode());
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
		SubCategoria other = (SubCategoria) obj;
		if (scatId == null) {
			if (other.scatId != null)
				return false;
		} else if (!scatId.equals(other.scatId))
			return false;
		return true;
	}
}
