package com.bcopstein.negocio.repositories;

import com.bcopstein.negocio.entities.ItemEstoque;


import java.util.List;

public interface IEstoqueRepository {

    Iterable<ItemEstoque> findAll();
    int findQtdProdutoByProduto(long codigo);
    ItemEstoque findByProduto(long codigo);
    ItemEstoque save(ItemEstoque item);
    boolean saveAll(List<ItemEstoque> itens);
    void delete(ItemEstoque item);
}
