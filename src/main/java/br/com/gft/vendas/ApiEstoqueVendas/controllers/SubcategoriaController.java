package br.com.gft.vendas.ApiEstoqueVendas.controllers;

import br.com.gft.vendas.ApiEstoqueVendas.models.SubCategoria;
import br.com.gft.vendas.ApiEstoqueVendas.services.SubcategoriaService;
import io.swagger.annotations.Api;
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
@Api(value = "API REST VENDAS")
@RequestMapping("/apivendas")
public class SubcategoriaController {

    @Autowired
    private SubcategoriaService subcategoriaService;

    @GetMapping("/subcategorias")
    @ApiOperation(value = "Retorna lista de Subcategorias")
    public Page<SubCategoria> listar(@PageableDefault(sort = "scatId", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        return subcategoriaService.listar(paginacao);
    }

    @GetMapping("/subcategoria/{id}")
    @ApiOperation(value = "Retorna uma Subcategoria pelo Id")
    public ResponseEntity<SubCategoria> encontrarPorId(@PathVariable Integer id) {
        SubCategoria subCategoria = subcategoriaService.encontrarPorId(id);
        return ResponseEntity.ok(subCategoria);
    }

    @PostMapping("/subcategoria")
    @ApiOperation(value = "Cadastra uma Subcategoria")
    public ResponseEntity<SubCategoria> cadastrar(@RequestBody @Valid SubCategoria subCategoria, UriComponentsBuilder uriBuilder) {
        subCategoria = subcategoriaService.cadastrar(subCategoria);
        URI uri = uriBuilder.path("/subcategorias/{id}").buildAndExpand(subCategoria.getScatId()).toUri();
        return ResponseEntity.created(uri).body(subCategoria);
    }

    @PutMapping("/subcategoria/{id}")
    @ApiOperation(value = "Atualiza os dados de uma subcategoria")
    public ResponseEntity<SubCategoria> atualizar(@PathVariable @Valid Integer id, @RequestBody SubCategoria subCategoria) {
        subCategoria.setScatId(id);
        subCategoria = subcategoriaService.atualizar(id, subCategoria);
        return ResponseEntity.ok(subCategoria);
    }

    @DeleteMapping("/subcategoria/{id}")
    @ApiOperation(value = "Deleta uma Subcategoria")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        subcategoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
