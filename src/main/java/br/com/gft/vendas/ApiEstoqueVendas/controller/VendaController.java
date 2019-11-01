package br.com.gft.vendas.ApiEstoqueVendas.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.Venda;
import br.com.gft.vendas.ApiEstoqueVendas.repository.VendaRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/apivendas")
@CrossOrigin(origins="*") // definir qual dominio irá ser liberado, no meu caso todos
public class VendaController {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@ApiOperation(value = "Retorna todas as vendas")
	@GetMapping("/vendas")
    public Page<Venda> listar(@PageableDefault(sort = "venId", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        return vendaRepository.findAll(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> encontrarPorId(@PathVariable Integer id) {
        Optional<Venda> optionalVenda = vendaRepository.findById(id);
        if(optionalVenda.isPresent()) {
            return ResponseEntity.ok(optionalVenda.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Venda> cadastrar(@RequestBody Venda venda, UriComponentsBuilder uriBuilder) {
    	vendaRepository.save(venda);
        URI uri = uriBuilder.path("/Vendas/{id}").buildAndExpand(venda.getVenId()).toUri();
        return ResponseEntity.created(uri).body(venda);
    }

    // Não vai existir alteração da venda
//    @PutMapping("/{id}")
//    public ResponseEntity<Venda> atualizar(@PathVariable Integer id, @RequestBody Venda venda) {
//        Venda.setVenId(id);
//        Optional<venda> optionalVenda = vendaRepository.findById(id);
//        if(optionalVenda.isPresent()) {
//            optionalVenda.get().setVenId(Venda.getVenId());
//            optionalVenda.get().setVenNfiscal(venda.getVenNfiscal());
//            optionalVenda.get().setVenDataHora(venda.getVenDataHora());
//            optionalVenda.get().setVenStatus(venda.getVenStatus());
//            optionalVenda.get().setTipoPagamento(venda.getTipoPagamento());
//            optionalVenda.get().setCliente(venda.getCliente());
//            vendaRepository.save(optionalVenda.get());
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.notFound().build();
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deletar(@PathVariable Integer id) {
//        Optional<Venda> venda = vendaRepository.findById(id);
//        if(venda.isPresent()) {
//            vendaRepository.delete(venda.get());
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.notFound().build();
//    }

}
