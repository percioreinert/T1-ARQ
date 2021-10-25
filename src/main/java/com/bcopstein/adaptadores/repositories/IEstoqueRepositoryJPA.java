package com.bcopstein.adaptadores.repositories;

import com.bcopstein.negocio.entities.ItemEstoque;

import org.springframework.data.repository.CrudRepository;

public interface IEstoqueRepositoryJPA extends CrudRepository<ItemEstoque, Integer> {

    ItemEstoque findByProdutoCodigo(long codigo);
    int findQuantidadeByProduto(long codigo);
}
