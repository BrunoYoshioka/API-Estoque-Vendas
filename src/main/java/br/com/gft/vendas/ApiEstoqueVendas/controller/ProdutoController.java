package br.com.gft.vendas.ApiEstoqueVendas.controller;

import javax.validation.Valid;

import br.com.gft.vendas.ApiEstoqueVendas.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.Produto;
import br.com.gft.vendas.ApiEstoqueVendas.repository.ProdutoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value="/apivendas")
@CrossOrigin(origins="*") // definir qual dominio irá ser liberado, no meu caso todos
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoService produtoService;

	@ApiOperation(value = "Retorna uma lista de Produtos")
	@GetMapping("/produtos")
	public Page<Produto> listaProdutos(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao){
		return produtoService.listar(paginacao);
	}
	
	@ApiOperation(value = "Retorna um cliente unico")
	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> listaProdutoUnico(@PathVariable Integer id) {
		Produto produto = produtoService.encontrarPorId(id);
		return ResponseEntity.ok(produto);
	}
	
	@ApiOperation(value = "Salva um produto")
	@PostMapping("/produto")
	public ResponseEntity<Produto> salvaProduto(@RequestBody @Valid Produto produto, UriComponentsBuilder uriBuilder) {
		produto = produtoService.cadastrar(produto);
		URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getProdId()).toUri();
		return  ResponseEntity.created(uri).body(produto);
	}

	@ApiOperation(value = "Atualiza um produto")
	@PutMapping("/produto/{id}")
	public ResponseEntity<Produto> atualizaProduto(@RequestBody @Valid Produto produto, @PathVariable Integer id) {
		produto.setProdId(id);
		produto = produtoService.atualizar(id, produto);
		return ResponseEntity.ok(produto);
	}
	
	@ApiOperation(value = "Deleta um produto")
	@DeleteMapping("/produto/{id}")
	public ResponseEntity<Void> deletaProduto(@PathVariable @Valid Integer id) {
		produtoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
