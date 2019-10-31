package br.com.gft.vendas.ApiEstoqueVendas.repository;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
