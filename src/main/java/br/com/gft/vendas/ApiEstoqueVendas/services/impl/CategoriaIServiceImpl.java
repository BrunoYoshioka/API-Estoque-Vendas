package br.com.gft.vendas.ApiEstoqueVendas.services.impl;

import br.com.gft.vendas.ApiEstoqueVendas.exceptions.ObjectNotFoundException;
import br.com.gft.vendas.ApiEstoqueVendas.modelo.Categoria;
import br.com.gft.vendas.ApiEstoqueVendas.repository.CategoriaRepository;
import br.com.gft.vendas.ApiEstoqueVendas.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaIServiceImpl implements IService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Object> listar() {
        return new ArrayList<>(categoriaRepository.findAll());
    }

    public Categoria encontrarPorId(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException(
                "Categoria com id " + id + " não encontrado!, Tipo: " + Categoria.class.getName()
        ));
    }

    public Categoria cadastrar(Object categoria) {
        Categoria cat = (Categoria) categoria;
        cat.setCatId(null);
        return categoriaRepository.save(cat);
    }

    public Categoria atualizar(Integer id, Object categoria) {
        Categoria categoriaEncontradaPorId = encontrarPorId(id);
        Categoria cat = (Categoria) categoria;
        categoriaEncontradaPorId.setCatId(cat.getCatId());
        categoriaEncontradaPorId.setCatNome(cat.getCatNome());
        return categoriaRepository.save(categoriaEncontradaPorId);
    }

    public void deletar(Integer id) {
        encontrarPorId(id);
        categoriaRepository.deleteById(id);
    }
}
