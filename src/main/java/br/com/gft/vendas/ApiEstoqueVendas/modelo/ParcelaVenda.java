package br.com.gft.vendas.ApiEstoqueVendas.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ParcelaVenda {
	
	@ManyToOne
	private Long venId;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pveId;
	private Float pveValor;
	private LocalDateTime pveDataPagto = LocalDateTime.now();
	private LocalDateTime pveDataVecto = LocalDateTime.now();
	
	//construtor para q toda vez estancia e cria um objeto
	public ParcelaVenda(Long venId, Long pveId, Float pveValor, LocalDateTime pveDataPagto,
			LocalDateTime pveDataVecto) {
		super();
		this.venId = venId;
		this.pveId = pveId;
		this.pveValor = pveValor;
		this.pveDataPagto = pveDataPagto;
		this.pveDataVecto = pveDataVecto;
	}
	
	public ParcelaVenda() {
	}

	public Long getVenId() {
		return venId;
	}

	public void setVenId(Long venId) {
		this.venId = venId;
	}

	public Long getPveId() {
		return pveId;
	}

	public void setPveId(Long pveId) {
		this.pveId = pveId;
	}

	public Float getPveValor() {
		return pveValor;
	}

	public void setPveValor(Float pveValor) {
		this.pveValor = pveValor;
	}

	public LocalDateTime getPveDataPagto() {
		return pveDataPagto;
	}

	public void setPveDataPagto(LocalDateTime pveDataPagto) {
		this.pveDataPagto = pveDataPagto;
	}

	public LocalDateTime getPveDataVecto() {
		return pveDataVecto;
	}

	public void setPveDataVecto(LocalDateTime pveDataVecto) {
		this.pveDataVecto = pveDataVecto;
	}
	
	

}
