package com.bcopstein.negocio.repositories;

import com.bcopstein.negocio.entities.ItemEstoque;
import com.bcopstein.negocio.entities.Produto;

import java.util.List;

public interface EstoqueRepository {

    ItemEstoque findById(long id);
    Iterable<ItemEstoque> findAll();
    ItemEstoque findByCodProd();
    ItemEstoque save(ItemEstoque item);
    boolean saveAll(List<ItemEstoque> itens);
    void delete(ItemEstoque item);
    boolean update(ItemEstoque item);
}
