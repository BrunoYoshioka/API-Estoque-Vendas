package br.com.gft.vendas.ApiEstoqueVendas.repositories;

import br.com.gft.vendas.ApiEstoqueVendas.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//usar JpaRepository para facilitar a vida do desenvolvedor, pq o JPA repository ja possui vários metodos prontos pra fazer persistencia no banco
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	//Cliente findById(Integer id);

}
