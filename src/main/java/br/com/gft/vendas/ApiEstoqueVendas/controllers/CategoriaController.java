package br.com.gft.vendas.ApiEstoqueVendas.controllers;

import br.com.gft.vendas.ApiEstoqueVendas.models.Categoria;
import br.com.gft.vendas.ApiEstoqueVendas.services.CategoriaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/apivendas")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping("/categorias")
    @ApiOperation(value = "Retorna uma lista de Categorias")
    public Page<Categoria> listar(@PageableDefault(sort="catId", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        return categoriaService.listar(paginacao);
    }

    @GetMapping("/categoria/{id}")
    @ApiOperation(value = "Encontra uma categoria pelo Id")
    public ResponseEntity<Categoria> encontrarPorId(@PathVariable Integer id) {
        Categoria categoria = categoriaService.encontrarPorId(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping("/categoria")
    @ApiOperation(value = "Cadastrar uma Categoria")
    public ResponseEntity<Categoria> cadastrar(@RequestBody @Valid Categoria categoria, UriComponentsBuilder uriBuilder) {
        categoria = categoriaService.cadastrar(categoria);
        URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getCatId()).toUri();
        return ResponseEntity.created(uri).body(categoria);
    }

    @PutMapping("/categoria/{id}")
    @ApiOperation(value = "Atualizar uma Categoria")
    public ResponseEntity<Categoria> atualizar(@PathVariable @Valid Integer id, @RequestBody Categoria categoria) {
        categoria.setCatId(id);
        categoria = categoriaService.atualizar(id, categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/categoria/{id}")
    @ApiOperation(value = "Deletar uma Categoria")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
