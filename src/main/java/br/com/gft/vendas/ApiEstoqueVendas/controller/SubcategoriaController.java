package br.com.gft.vendas.ApiEstoqueVendas.controller;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.SubCategoria;
import br.com.gft.vendas.ApiEstoqueVendas.services.impl.SubcategoriaIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/subcategorias")
public class SubcategoriaController {

    @Autowired
    private SubcategoriaIServiceImpl subcategoriaServiceImpl;

    @GetMapping("/")
    public List<Object> listar() {
        return subcategoriaServiceImpl.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategoria> encontrarPorId(@PathVariable Integer id) {
        SubCategoria subCategoria = subcategoriaServiceImpl.encontrarPorId(id);
        return ResponseEntity.ok(subCategoria);
    }

    @PostMapping
    public ResponseEntity<SubCategoria> cadastrar(@RequestBody SubCategoria subCategoria, UriComponentsBuilder uriBuilder) {
        subCategoria = subcategoriaServiceImpl.cadastrar(subCategoria);
        URI uri = uriBuilder.path("/subcategorias/{id}").buildAndExpand(subCategoria.getScatId()).toUri();
        return ResponseEntity.created(uri).body(subCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategoria> atualizar(@PathVariable Integer id, @RequestBody SubCategoria subCategoria) {
        subCategoria.setScatId(id);
        subCategoria = subcategoriaServiceImpl.atualizar(id, subCategoria);
        return ResponseEntity.ok(subCategoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        subcategoriaServiceImpl.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
