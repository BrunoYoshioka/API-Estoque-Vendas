package br.com.gft.vendas.ApiEstoqueVendas.controller;

import br.com.gft.vendas.ApiEstoqueVendas.modelo.SubCategoria;
import br.com.gft.vendas.ApiEstoqueVendas.repository.SubcategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

//import javax.xml.ws.Response;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/subcategorias")
public class SubcategoriaController {

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @GetMapping("/")
    public Page<SubCategoria> listar(@PageableDefault(sort = "scatId", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        return subcategoriaRepository.findAll(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategoria> encontrarPorId(@PathVariable Integer id) {
        Optional<SubCategoria> optionalSubCategoria = subcategoriaRepository.findById(id);
        if(optionalSubCategoria.isPresent()) {
            return ResponseEntity.ok(optionalSubCategoria.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<SubCategoria> cadastrar(@RequestBody SubCategoria subCategoria, UriComponentsBuilder uriBuilder) {
        subcategoriaRepository.save(subCategoria);
        URI uri = uriBuilder.path("/subcategorias/{id}").buildAndExpand(subCategoria.getScatId()).toUri();
        return ResponseEntity.created(uri).body(subCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategoria> atualizar(@PathVariable Integer id, @RequestBody SubCategoria subCategoria) {
        subCategoria.setScatId(id);
        Optional<SubCategoria> optionalSubCategoria = subcategoriaRepository.findById(id);
        if(optionalSubCategoria.isPresent()) {
            optionalSubCategoria.get().setScatId(subCategoria.getScatId());
            optionalSubCategoria.get().setScatNome(subCategoria.getScatNome());
            optionalSubCategoria.get().setCategoria(subCategoria.getCategoria());
            subcategoriaRepository.save(optionalSubCategoria.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        Optional<SubCategoria> subCategoria = subcategoriaRepository.findById(id);
        if(subCategoria.isPresent()) {
            subcategoriaRepository.delete(subCategoria.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
