package br.com.gft.vendas.ApiEstoqueVendas.controller;

import java.util.Optional;

import javax.validation.Valid;

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

	@ApiOperation(value = "Retorna uma lista de Clientes")
	@GetMapping("/clientes")
	public Page<Cliente> listaClientes(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10)Pageable paginacao) {
		return clienteRepository.findAll(paginacao);
	}

	@ApiOperation(value = "Retorna um cliente unico")
	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> listaClienteUnico(@PathVariable Integer id) {
		Optional<Cliente> optionalCliente = clienteRepository.findById(id);
		if(optionalCliente.isPresent()) {
            return ResponseEntity.ok(optionalCliente.get());
        }
        return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Salva um cliente")
	@PostMapping("/cliente")
	public Cliente salvaCliente(@RequestBody @Valid Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@ApiOperation(value = "Deleta um cliente")
	@DeleteMapping("/cliente")
	public void deletaCliente(@RequestBody @Valid Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	@ApiOperation(value = "Atualiza um cliente")
	@PutMapping("/cliente")
	public Cliente atualizaCliente(@RequestBody @Valid Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}
