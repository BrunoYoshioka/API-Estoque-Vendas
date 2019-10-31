package br.com.gft.vendas.ApiEstoqueVendas.modelo;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.enums.StatusVenda;
import br.com.gft.vendas.ApiEstoqueVendas.modelo.enums.TipoPagamento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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
	private Float venTotal;
	private Long venNparcelas;
	private Float venDesconto;
	private Float venTotalLiquido;
	private Float venValorPago;
	private Float venTroco;
	
	public Venda() {
	}
	
	//construtor para q toda vez estancia e cria um objeto
	public Venda(Cliente cliente, LocalDateTime venDataHora, Long venNfiscal, List<ItensVenda> itensVenda,
			Float venTotal, Long venAvista, Long venNparcelas, StatusVenda venStatus, Float venDesconto,
			Float venTotalLiquido, Float venValorPago, Float venTroco, TipoPagamento tipoPagamento) {
		this.cliente = cliente;
		this.venDataHora = venDataHora;
		this.venNfiscal = venNfiscal;
		this.itensVenda = itensVenda;
		this.venTotal = venTotal;
		this.venNparcelas = venNparcelas;
		this.venStatus = venStatus;
		this.venDesconto = venDesconto;
		this.venTotalLiquido = venTotalLiquido;
		this.venValorPago = venValorPago;
		this.venTroco = venTroco;
		this.tipoPagamento = tipoPagamento;
	}


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
	public Float getVenTotal() {
		return venTotal;
	}
	public void setVenTotal(Float venTotal) {
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
	public Float getVenDesconto() {
		return venDesconto;
	}
	public void setVenDesconto(Float venDesconto) {
		this.venDesconto = venDesconto;
	}
	public Float getVenTotalLiquido() {
		return venTotalLiquido;
	}
	public void setVenTotalLiquido(Float venTotalLiquido) {
		this.venTotalLiquido = venTotalLiquido;
	}
	public Float getVenValorPago() {
		return venValorPago;
	}
	public void setVenValorPago(Float venValorPago) {
		this.venValorPago = venValorPago;
	}
	public Float getVenTroco() {
		return venTroco;
	}
	public void setVenTroco(Float venTroco) {
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
