package com.bcopstein.adaptadores.repositories;

import com.bcopstein.negocio.entities.Produto;
import org.springframework.data.repository.CrudRepository;


public interface IProdutoRepositoryJPA extends CrudRepository<Produto, Long> {

}
