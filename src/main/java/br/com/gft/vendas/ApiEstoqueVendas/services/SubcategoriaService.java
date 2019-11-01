package br.com.gft.vendas.ApiEstoqueVendas.services;

import br.com.gft.vendas.ApiEstoqueVendas.exceptions.ObjectNotFoundException;
import br.com.gft.vendas.ApiEstoqueVendas.modelo.SubCategoria;
import br.com.gft.vendas.ApiEstoqueVendas.repository.SubcategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubcategoriaService {

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    public Page<SubCategoria> listarSubcategorias(Pageable paginacao) {
        return subcategoriaRepository.findAll(paginacao);
    }

    public SubCategoria encontrarPorId(Integer id) {
        Optional<SubCategoria> subCategoria = subcategoriaRepository.findById(id);
        return subCategoria.orElseThrow(() -> new ObjectNotFoundException(
                "Subcategoria com id: " + id + " não encontrado!, tipo: " + SubCategoria.class.getName()
        ));
    }

    public SubCategoria cadastrar(SubCategoria subCategoria) {
        subCategoria.setScatId(null);
        return subcategoriaRepository.save(subCategoria);
    }

    public SubCategoria atualizar(Integer id, SubCategoria subCategoria) {
        SubCategoria subCategoriaEncontradaPorId = encontrarPorId(id);
        subCategoriaEncontradaPorId.setScatId(subCategoria.getScatId());
        subCategoriaEncontradaPorId.setScatNome(subCategoria.getScatNome());
        subCategoriaEncontradaPorId.setCategoria(subCategoria.getCategoria());
        return subcategoriaRepository.save(subCategoriaEncontradaPorId);
    }

    public void deletar(Integer id) {
        encontrarPorId(id);
        subcategoriaRepository.deleteById(id);
    }
}
