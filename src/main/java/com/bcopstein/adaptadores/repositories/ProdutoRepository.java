package com.bcopstein.adaptadores.repositories;

import com.bcopstein.negocio.entities.Produto;
import com.bcopstein.negocio.repositories.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepository implements IProdutoRepository {

    private final IProdutoRepositoryJPA repository;

    @Autowired
    public ProdutoRepository(IProdutoRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    public Produto findById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public Iterable<Produto> findAll() {
        return repository.findAll();
    }

    @Override
    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public boolean saveAll(List<Produto> produtos) {
        return repository.saveAll(produtos) != null;
    }

    @Override
    public void delete(Produto produto) {
        repository.delete(produto);
    }

    @Override
    public boolean update(Produto produto) {
        return repository.save(produto) != null;
    }
}
