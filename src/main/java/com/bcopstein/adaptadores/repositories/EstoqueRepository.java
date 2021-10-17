package com.bcopstein.adaptadores.repositories;

import com.bcopstein.negocio.entities.ItemEstoque;
import com.bcopstein.negocio.repositories.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EstoqueRepository implements IEstoqueRepository {

    private IEstoqueRepositoryJPA repository;

    @Autowired
    public EstoqueRepository(IEstoqueRepositoryJPA repository) {
        this.repository = repository;
    }

    //public ItemEstoque findByCodProd(long codigo) {
    //    return repository.findByCodProd(codigo);
    //}

    @Override
    public Iterable<ItemEstoque> findAll() {
        return repository.findAll();
    }

    @Override
    public ItemEstoque save(ItemEstoque item) {
        return repository.save(item);
    }

    @Override
    public boolean saveAll(List<ItemEstoque> itens) {
        return repository.saveAll(itens) != null;
    }

    @Override
    public void delete(ItemEstoque item) {
        repository.delete(item);
    }
}
