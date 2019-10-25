package br.com.gft.vendas.ApiEstoqueVendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
