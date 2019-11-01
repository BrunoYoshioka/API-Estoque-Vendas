package br.com.gft.vendas.ApiEstoqueVendas.controller;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.SubCategoria;
import br.com.gft.vendas.ApiEstoqueVendas.services.SubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/subcategorias")
public class SubcategoriaController {

    @Autowired
    private SubcategoriaService subcategoriaService;

    @GetMapping("/")
    public Page<SubCategoria> listar(@PageableDefault(sort = "scatId", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        return subcategoriaService.listarSubcategorias(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategoria> encontrarPorId(@PathVariable Integer id) {
        SubCategoria subCategoria = subcategoriaService.encontrarPorId(id);
        return ResponseEntity.ok(subCategoria);
    }

    @PostMapping
    public ResponseEntity<SubCategoria> cadastrar(@RequestBody SubCategoria subCategoria, UriComponentsBuilder uriBuilder) {
        subCategoria = subcategoriaService.cadastrar(subCategoria);
        URI uri = uriBuilder.path("/subcategorias/{id}").buildAndExpand(subCategoria.getScatId()).toUri();
        return ResponseEntity.created(uri).body(subCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategoria> atualizar(@PathVariable Integer id, @RequestBody SubCategoria subCategoria) {
        subCategoria.setScatId(id);
        subCategoria = subcategoriaService.atualizar(id, subCategoria);
        return ResponseEntity.ok(subCategoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        subcategoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
