package br.com.gft.vendas.ApiEstoqueVendas.services;

import java.util.List;

public interface IService {
    List<Object> listar();

    Object encontrarPorId(Integer id);

    Object cadastrar(Object obj);

    Object atualizar(Integer id, Object obj);

    void deletar(Integer id);
}
