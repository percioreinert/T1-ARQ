package com.bcopstein.adaptadores.repositories;

import com.bcopstein.negocio.entities.ItemEstoque;
import com.bcopstein.negocio.repositories.IEstoqueRepository;

import org.springframework.stereotype.Repository;

@Repository
public class EstoqueRepository implements IEstoqueRepository{

    private IEstoqueRepositoryJPA repository;

    
    public EstoqueRepository(IEstoqueRepositoryJPA repository) {
        this.repository = repository;
    }

    public ItemEstoque findByCodProd(long codigo) {
        return repository.findByCodProd(codigo);
    }

    @Override
    public Iterable<ItemEstoque> findAll() {
        return repository.findAll();
    }

    @Override
    public ItemEstoque save(ItemEstoque item) {
        return repository.save(item);
    }

    // @Override
    // public boolean saveAll(List<Produto> produtos) {
    //     return repository.saveAll(produtos) != null;
    // }

    // @Override
    // public void delete(Produto produto) {
    //     repository.delete(produto);
    // }

    // @Override
    // public boolean update(Produto produto) {
    //     return repository.save(produto) != null;
    // }
}
}
