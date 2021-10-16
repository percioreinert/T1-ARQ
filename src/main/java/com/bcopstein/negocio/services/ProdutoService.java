package com.bcopstein.negocio.services;

import com.bcopstein.negocio.entities.Produto;
import com.bcopstein.negocio.repositories.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoService {

    private IProdutoRepository repository;

    @Autowired
    public ProdutoService(IProdutoRepository repository) {
        this.repository = repository;
    }


    public List<Produto> findAll() {
        Iterable<Produto> produtos = repository.findAll();
        List<Produto> produtosList = new ArrayList<>();

        for (Produto p : produtos) {
            produtosList.add(p);
        }
        return produtosList;
    }
}
