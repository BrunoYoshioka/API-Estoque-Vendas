package br.com.gft.vendas.ApiEstoqueVendas.controllers;

import br.com.gft.vendas.ApiEstoqueVendas.models.Cliente;
import br.com.gft.vendas.ApiEstoqueVendas.repositories.ClienteRepository;
import br.com.gft.vendas.ApiEstoqueVendas.services.ClienteService;
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
@RequestMapping(value = "/apivendas")
@CrossOrigin(origins = "*") // definir qual dominio irá ser liberado, no meu caso todos
public class ClienteController {

	// Injetando o ClienteRepository
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/clientes")
	@ApiOperation(value = "Retorna uma lista de Clientes")
	public Page<Cliente> listaClientes(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10)Pageable paginacao) {
		return clienteService.listar(paginacao);
	}

	@GetMapping("/cliente/{id}")
	@ApiOperation(value = "Retorna um Cliente pelo Id")
	public ResponseEntity<Cliente> listaClienteUnico(@PathVariable Integer id) {
		Cliente cliente = clienteService.encontrarPorId(id);
        return ResponseEntity.ok(cliente);
	}

	@PostMapping("/cliente")
	@ApiOperation(value = "Cadastrar um cliente")
	public ResponseEntity<Cliente> salvaCliente(@RequestBody @Valid Cliente cliente, UriComponentsBuilder uriBuilder) {
		cliente = clienteService.cadastrar(cliente);
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(cliente);
	}

	@PutMapping("/cliente/{id}")
	@ApiOperation(value = "Atualizar um cliente")
	public ResponseEntity<Cliente> atualizaCliente(@RequestBody @Valid Cliente cliente, @PathVariable Integer id) {
		cliente.setId(id);
		cliente = clienteService.atualizar(id, cliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/cliente/{id}")
	@ApiOperation(value = "Deletar um cliente")
	public ResponseEntity<Void> deletaCliente(@PathVariable @Valid Integer id) {
		clienteService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
