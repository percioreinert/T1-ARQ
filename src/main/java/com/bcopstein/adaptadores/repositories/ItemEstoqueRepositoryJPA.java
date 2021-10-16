package com.bcopstein.adaptadores.repositories;

import com.bcopstein.negocio.entities.ItemEstoque;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemEstoqueRepositoryJPA extends CrudRepository<ItemEstoque, Integer> {

    ItemEstoque findByCodigo(int codigo);
}
