package br.com.gft.vendas.ApiEstoqueVendas.modelo;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.enums.TipoCliente;

import javax.persistence.*;
import javax.print.DocFlavor.STRING;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cliCpfcnpj;
	private String cliNome;
	private String cliRgIe;
	private String cliRsocial;
	private String cliTipo = TipoCliente.PESSOA_FISICA.getDescricao();
	private String cliCep;
	private String cliEndereco;
	private String cliBairro;
	private String cliFone;
	private String cliCel;
	private String cliEmail;
	private String cliEndnumero;
	private String cliCidade;
	private String cliEstado;
	
	
	public String getCliCpfcnpj() {
		return cliCpfcnpj;
	}

	public void setCliCpfcnpj(String cliCpfcnpj) {
		this.cliCpfcnpj = cliCpfcnpj;
	}

	public String getCliNome() {
		return cliNome;
	}

	public void setCliNome(String cliNome) {
		this.cliNome = cliNome;
	}

	public String getCliRgIe() {
		return cliRgIe;
	}

	public void setCliRgIe(String cliRgIe) {
		this.cliRgIe = cliRgIe;
	}

	public String getCliRsocial() {
		return cliRsocial;
	}

	public void setCliRsocial(String cliRsocial) {
		this.cliRsocial = cliRsocial;
	}

	public String getCliTipo() {
		return cliTipo;
	}

	public void setCliTipo(String cliTipo) {
		this.cliTipo = cliTipo;
	}

	public String getCliCep() {
		return cliCep;
	}

	public void setCliCep(String cliCep) {
		this.cliCep = cliCep;
	}

	public String getCliEndereco() {
		return cliEndereco;
	}

	public void setCliEndereco(String cliEndereco) {
		this.cliEndereco = cliEndereco;
	}

	public String getCliBairro() {
		return cliBairro;
	}

	public void setCliBairro(String cliBairro) {
		this.cliBairro = cliBairro;
	}

	public String getCliFone() {
		return cliFone;
	}

	public void setCliFone(String cliFone) {
		this.cliFone = cliFone;
	}

	public String getCliCel() {
		return cliCel;
	}

	public void setCliCel(String cliCel) {
		this.cliCel = cliCel;
	}

	public String getCliEmail() {
		return cliEmail;
	}

	public void setCliEmail(String cliEmail) {
		this.cliEmail = cliEmail;
	}

	public String getCliEndnumero() {
		return cliEndnumero;
	}

	public void setCliEndnumero(String cliEndnumero) {
		this.cliEndnumero = cliEndnumero;
	}

	public String getCliCidade() {
		return cliCidade;
	}

	public void setCliCidade(String cliCidade) {
		this.cliCidade = cliCidade;
	}

	public String getCliEstado() {
		return cliEstado;
	}

	public void setCliEstado(String cliEstado) {
		this.cliEstado = cliEstado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// Sobrescrita dos Métodos equals e hashCode para otimizar a consulta dos objetos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliCpfcnpj == null) ? 0 : cliCpfcnpj.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cliCpfcnpj == null) {
			if (other.cliCpfcnpj != null)
				return false;
		} else if (!cliCpfcnpj.equals(other.cliCpfcnpj))
			return false;
		return true;
	}
	
}
