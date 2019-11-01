package br.com.gft.vendas.ApiEstoqueVendas.services;

import br.com.gft.vendas.ApiEstoqueVendas.exceptions.ObjectNotFoundException;
import br.com.gft.vendas.ApiEstoqueVendas.modelo.Categoria;
import br.com.gft.vendas.ApiEstoqueVendas.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Page<Categoria> listarCategorias(Pageable paginacao) {
        return categoriaRepository.findAll(paginacao);
    }

    public Categoria encontrarPorId(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException(
                "Categoria com id " + id + " não encontrado!, Tipo: " + Categoria.class.getName()
        ));
    }

    public Categoria cadastrar(Categoria categoria) {
        categoria.setCatId(null);
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Integer id, Categoria categoria) {
        Categoria categoriaEncontradaPorId = encontrarPorId(id);
        categoriaEncontradaPorId.setCatId(categoria.getCatId());
        categoriaEncontradaPorId.setCatNome(categoria.getCatNome());
        return categoriaRepository.save(categoriaEncontradaPorId);
    }

    public void deletar(Integer id) {
        encontrarPorId(id);
        categoriaRepository.deleteById(id);
    }
}
