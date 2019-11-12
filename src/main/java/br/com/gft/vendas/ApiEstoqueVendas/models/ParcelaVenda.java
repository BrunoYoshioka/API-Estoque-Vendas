package br.com.gft.vendas.ApiEstoqueVendas.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class ParcelaVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pveId;
	private BigDecimal pveValor;
	private LocalDateTime pveDataPagto = LocalDateTime.now();
	private LocalDateTime pveDataVecto = LocalDateTime.now();

	@ManyToOne
	private Venda venId;
	
	//construtor para q toda vez estancia e cria um objeto
	public ParcelaVenda(Venda venId, Integer pveId, BigDecimal pveValor, LocalDateTime pveDataPagto,
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

	public Venda getVenId() {
		return venId;
	}

	public void setVenId(Venda venId) {
		this.venId = venId;
	}

	public Integer getPveId() {
		return pveId;
	}

	public void setPveId(Integer pveId) {
		this.pveId = pveId;
	}

	public BigDecimal getPveValor() {
		return pveValor;
	}

	public void setPveValor(BigDecimal pveValor) {
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
