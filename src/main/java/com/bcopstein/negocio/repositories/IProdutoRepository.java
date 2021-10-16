package com.bcopstein.negocio.repositories;

import com.bcopstein.negocio.entities.Produto;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IProdutoRepository {

    Produto findById(long id);
    Iterable<Produto> findAll();
    Produto findByCodProd();
    Produto save(Produto produto);
    boolean saveAll(List<Produto> produtos);
    void delete(Produto produto);
    boolean update(Produto produto);
}
