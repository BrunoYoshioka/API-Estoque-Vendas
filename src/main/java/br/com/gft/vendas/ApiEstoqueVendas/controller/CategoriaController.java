package br.com.gft.vendas.ApiEstoqueVendas.controller;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.Categoria;
import br.com.gft.vendas.ApiEstoqueVendas.repository.CategoriaRepository;
import br.com.gft.vendas.ApiEstoqueVendas.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public Page<Categoria> listar(@PageableDefault(sort = "catId", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        return categoriaService.listarCategorias(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> encontrarPorId(@PathVariable Integer id) {
        Categoria categoria = categoriaService.encontrarPorId(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria categoria, UriComponentsBuilder uriBuilder) {
        categoria = categoriaService.cadastrar(categoria);
        URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getCatId()).toUri();
        return ResponseEntity.created(uri).body(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Integer id, @RequestBody Categoria categoria) {
        categoria.setCatId(id);
        categoria = categoriaService.atualizar(id, categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
