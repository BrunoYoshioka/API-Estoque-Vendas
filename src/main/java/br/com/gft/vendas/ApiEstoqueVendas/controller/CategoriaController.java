package br.com.gft.vendas.ApiEstoqueVendas.controller;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.Categoria;
import br.com.gft.vendas.ApiEstoqueVendas.repository.CategoriaRepository;
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

    @GetMapping("/")
    public Page<Categoria> listar(@PageableDefault(sort = "catId", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        return categoriaRepository.findAll(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> encontrarPorId(@PathVariable Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent())
            return ResponseEntity.ok(categoria.get());
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria categoria, UriComponentsBuilder uriBuilder) {
        categoriaRepository.save(categoria);

        URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getCatId()).toUri();
        return ResponseEntity.created(uri).body(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Integer id, @RequestBody Categoria categoria) {
        categoria.setCatId(id);
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        if(optionalCategoria.isPresent()) {
            optionalCategoria.get().setCatId(categoria.getCatId());
            optionalCategoria.get().setCatNome(categoria.getCatNome());
            categoriaRepository.save(optionalCategoria.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        if(optionalCategoria.isPresent()) {
            categoriaRepository.delete(optionalCategoria.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
