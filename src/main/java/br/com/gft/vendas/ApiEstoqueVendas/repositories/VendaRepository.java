package br.com.gft.vendas.ApiEstoqueVendas.repositories;

import br.com.gft.vendas.ApiEstoqueVendas.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{
}