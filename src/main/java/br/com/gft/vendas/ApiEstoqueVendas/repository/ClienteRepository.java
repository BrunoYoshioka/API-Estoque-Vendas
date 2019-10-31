package br.com.gft.vendas.ApiEstoqueVendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.Cliente;
import org.springframework.stereotype.Repository;
//usar JpaRepository para facilitar a vida do desenvolvedor, pq o JPA repository ja possui vários metodos prontos pra fazer persistencia no banco
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findById(Integer id);

}
