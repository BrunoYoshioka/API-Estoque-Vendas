package br.com.gft.vendas.ApiEstoqueVendas.controller;

import java.util.Optional;

import javax.validation.Valid;

import br.com.gft.vendas.ApiEstoqueVendas.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.Cliente;
import br.com.gft.vendas.ApiEstoqueVendas.repository.ClienteRepository;

//import javax.xml.ws.Response;
import java.net.URI;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/apivendas")
@CrossOrigin(origins = "*") // definir qual dominio irá ser liberado, no meu caso todos
public class ClienteController {

	// Injetando o ClienteRepository
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;

	@ApiOperation(value = "Retorna uma lista de Clientes")
	@GetMapping("/clientes")
	public Page<Cliente> listaClientes(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10)Pageable paginacao) {
		return clienteService.listar(paginacao);
	}

	@ApiOperation(value = "Retorna um cliente unico")
	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> listaClienteUnico(@PathVariable Integer id) {
		Cliente cliente = clienteService.encontrarPorId(id);
        return ResponseEntity.ok(cliente);
	}

	@ApiOperation(value = "Salva um cliente")
	@PostMapping("/cliente")
	public ResponseEntity<Cliente> salvaCliente(@RequestBody @Valid Cliente cliente, UriComponentsBuilder uriBuilder) {
		cliente = clienteService.cadastrar(cliente);
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(cliente);
	}

	@ApiOperation(value = "Atualiza um cliente")
	@PutMapping("/cliente/{id}")
	public ResponseEntity<Cliente> atualizaCliente(@RequestBody @Valid Cliente cliente, @PathVariable Integer id) {
		cliente.setId(id);
		cliente = clienteService.atualizar(id, cliente);
		return ResponseEntity.ok(cliente);
	}

	@ApiOperation(value = "Deleta um cliente")
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<Void> deletaCliente(@PathVariable @Valid Integer id) {
		clienteService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
