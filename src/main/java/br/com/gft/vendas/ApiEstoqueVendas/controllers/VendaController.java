package br.com.gft.vendas.ApiEstoqueVendas.controllers;

import br.com.gft.vendas.ApiEstoqueVendas.form.AtualizacaoVendaForm;
import br.com.gft.vendas.ApiEstoqueVendas.models.Venda;
import br.com.gft.vendas.ApiEstoqueVendas.models.dtos.VendaDTO;
import br.com.gft.vendas.ApiEstoqueVendas.services.VendaService;
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
@RequestMapping(value="/apivendas")
@CrossOrigin(origins="*") // definir qual dominio irá ser liberado, no meu caso todos
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@ApiOperation(value = "Retorna todas as vendas")
	@GetMapping("/vendas")
    public Page<VendaDTO> listar(@PageableDefault(sort = "venId", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        return vendaService.listar(paginacao);
    }

    @GetMapping("/venda/{id}")
    public ResponseEntity<Venda> encontrarPorId(@PathVariable Integer id) {
        Venda venda = vendaService.encontrarPorId(id);
	    return ResponseEntity.ok(venda);
    }

    @PostMapping("/venda")
    public ResponseEntity<Venda> cadastrar(@RequestBody @Valid Venda venda, UriComponentsBuilder uriBuilder) {
    	vendaService.cadastrar(venda);
        URI uri = uriBuilder.path("/Vendas/{id}").buildAndExpand(venda.getVenId()).toUri();
        return ResponseEntity.created(uri).body(venda);
    }

    @PutMapping("/venda/{id}")
    public ResponseEntity<Venda> atualizar(@PathVariable Integer id, @RequestBody @Valid AtualizacaoVendaForm vendaForm) {
        Venda venda = vendaService.atualizar(id, vendaForm);
        return ResponseEntity.ok(venda);
    }

}
