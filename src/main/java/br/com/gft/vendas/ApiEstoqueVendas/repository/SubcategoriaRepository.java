package br.com.gft.vendas.ApiEstoqueVendas.repository;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.SubCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoriaRepository extends JpaRepository<SubCategoria, Integer> {
}
