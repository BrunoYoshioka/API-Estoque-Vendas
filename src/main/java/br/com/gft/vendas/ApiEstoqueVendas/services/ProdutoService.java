package br.com.gft.vendas.ApiEstoqueVendas.services;

import br.com.gft.vendas.ApiEstoqueVendas.exceptions.ObjectNotFoundException;
import br.com.gft.vendas.ApiEstoqueVendas.models.Produto;
import br.com.gft.vendas.ApiEstoqueVendas.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Page<Produto> listar(Pageable paginacao) {
        return produtoRepository.findAll(paginacao);
    }

    public Produto encontrarPorId(Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElseThrow(() -> new ObjectNotFoundException(
                "Produto com id " + "não encontrado!, tipo " + Produto.class.getName()
        ));
    }

    public Produto cadastrar(Produto produto) {
        produto.setProdId(null);
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Integer id, Produto produto) {
        Produto produtoEncontradoPorId = encontrarPorId(id);
        produtoEncontradoPorId.setProdId(produto.getProdId());
        produtoEncontradoPorId.setCategoria(produto.getCategoria());
        produtoEncontradoPorId.setProdDescricao(produto.getProdDescricao());
        produtoEncontradoPorId.setProdDtCadastro(produto.getProdDtCadastro());
        produtoEncontradoPorId.setProdNome(produto.getProdNome());
        produtoEncontradoPorId.setProdQtde(produto.getProdQtde());
        return produtoRepository.save(produtoEncontradoPorId);
    }

    public void deletar(Integer id) {
        Produto produto = encontrarPorId(id);
        produtoRepository.delete(produto);
    }
    
    @JmsListener(destination = "produtoQueue", containerFactory = "myFactory")
    private void receiveMessage(Produto produto) throws JmsException {
    	System.out.println("Received <" + produto.toString() + ">");
    	produtoRepository.save(produto);
    }

}
