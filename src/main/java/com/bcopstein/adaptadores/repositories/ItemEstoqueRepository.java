package com.bcopstein.adaptadores.repositories;

import com.bcopstein.negocio.entities.ItemEstoque;
import org.springframework.stereotype.Repository;

@Repository
public class ItemEstoqueRepository {

    private ItemEstoqueRepositoryJPA repository;

    public ItemEstoqueRepository(ItemEstoqueRepositoryJPA repository) {
        this.repository = repository;
    }

    public ItemEstoque findById(int codigo) {
        return repository.findById(codigo).get();
    }
}
