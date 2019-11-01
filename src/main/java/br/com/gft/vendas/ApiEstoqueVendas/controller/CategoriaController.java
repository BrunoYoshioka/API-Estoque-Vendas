package br.com.gft.vendas.ApiEstoqueVendas.controller;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.Categoria;
import br.com.gft.vendas.ApiEstoqueVendas.services.impl.CategoriaIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaIServiceImpl categoriaServiceImpl;

    @GetMapping("/")
    public List<Object> listar() {
        return categoriaServiceImpl.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> encontrarPorId(@PathVariable Integer id) {
        Categoria categoria = categoriaServiceImpl.encontrarPorId(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria categoria, UriComponentsBuilder uriBuilder) {
        categoria = categoriaServiceImpl.cadastrar(categoria);
        URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getCatId()).toUri();
        return ResponseEntity.created(uri).body(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Integer id, @RequestBody Categoria categoria) {
        categoria.setCatId(id);
        categoria = categoriaServiceImpl.atualizar(id, categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        categoriaServiceImpl.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
