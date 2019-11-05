package br.com.gft.vendas.ApiEstoqueVendas.repositories;

import br.com.gft.vendas.ApiEstoqueVendas.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
