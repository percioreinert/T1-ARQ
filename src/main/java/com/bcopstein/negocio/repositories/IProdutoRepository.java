package com.bcopstein.negocio.repositories;

import com.bcopstein.negocio.entities.Produto;

import java.util.List;

public interface IProdutoRepository {

    Produto findById(long id);
    Iterable<Produto> findAll();
    Produto save(Produto produto);
    boolean saveAll(List<Produto> produtos);
    void delete(Produto produto);
    boolean update(Produto produto);
}
