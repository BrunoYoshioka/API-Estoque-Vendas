package br.com.gft.vendas.ApiEstoqueVendas.repositories;

import br.com.gft.vendas.ApiEstoqueVendas.models.SubCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoriaRepository extends JpaRepository<SubCategoria, Integer> {
}
