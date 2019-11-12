package br.com.gft.vendas.ApiEstoqueVendas.models;

import br.com.gft.vendas.ApiEstoqueVendas.models.enums.StatusVenda;
import br.com.gft.vendas.ApiEstoqueVendas.models.enums.TipoPagamento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venda {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer venId;

	@ManyToOne
	private Cliente cliente;
	// Uma venda para 1 ou mais itens dos produtos. (montar lista)
	@OneToMany(mappedBy = "venda")
	private List<ItensVenda> itensVenda = new ArrayList<>();
	// Uma venda para 1 ou mais parcelas. (montar lista)
	@OneToMany(mappedBy = "venId")
	private List<ParcelaVenda> parcelaVenda = new ArrayList<>();
	@Enumerated(EnumType.STRING)
	private TipoPagamento tipoPagamento;
	@Enumerated(EnumType.STRING)
	private StatusVenda venStatus;

	private LocalDateTime venDataHora = LocalDateTime.now();
	private Long venNfiscal;
	private BigDecimal venTotal;
	private Long venNparcelas;
	private BigDecimal venDesconto;
	private BigDecimal venTotalLiquido;
	private BigDecimal venValorPago;
	private BigDecimal venTroco;

	
	public Integer getVenId() {
		return venId;
	}
	public void setVenId(Integer venId) {
		this.venId = venId;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDateTime getVenDataHora() {
		return venDataHora;
	}
	public void setVenDataHora(LocalDateTime venDataHora) {
		this.venDataHora = venDataHora;
	}
	public Long getVenNfiscal() {
		return venNfiscal;
	}
	public void setVenNfiscal(Long venNfiscal) {
		this.venNfiscal = venNfiscal;
	}
	public List<ItensVenda> getItensVenda() {
		return itensVenda;
	}
	public void setItensVenda(List<ItensVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}
	public BigDecimal getVenTotal() {
		return venTotal;
	}
	public void setVenTotal(BigDecimal venTotal) {
		this.venTotal = venTotal;
	}
	public Long getVenNparcelas() {
		return venNparcelas;
	}
	public void setVenNparcelas(Long venNparcelas) {
		this.venNparcelas = venNparcelas;
	}
	public StatusVenda getVenStatus() {
		return venStatus;
	}
	public void setVenStatus(StatusVenda venStatus) {
		this.venStatus = venStatus;
	}
	public BigDecimal getVenDesconto() {
		return venDesconto;
	}
	public void setVenDesconto(BigDecimal venDesconto) {
		this.venDesconto = venDesconto;
	}
	public BigDecimal getVenTotalLiquido() {
		return venTotalLiquido;
	}
	public void setVenTotalLiquido(BigDecimal venTotalLiquido) {
		this.venTotalLiquido = venTotalLiquido;
	}
	public BigDecimal getVenValorPago() {
		return venValorPago;
	}
	public void setVenValorPago(BigDecimal venValorPago) {
		this.venValorPago = venValorPago;
	}
	public BigDecimal getVenTroco() {
		return venTroco;
	}
	public void setVenTroco(BigDecimal venTroco) {
		this.venTroco = venTroco;
	}
	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	// Sobrescrita dos Métodos equals e hashCode para otimizar a consulta dos objetos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((venId == null) ? 0 : venId.hashCode());
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
		Venda other = (Venda) obj;
		if (venId == null) {
			if (other.venId != null)
				return false;
		} else if (!venId.equals(other.venId))
			return false;
		return true;
	}
	
}
