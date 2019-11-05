package br.com.gft.vendas.ApiEstoqueVendas.repository;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{
	
	

}