package com.bcopstein.adaptadores.repositories;

import com.bcopstein.negocio.entities.Venda;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IVendaRepositoryJPA extends CrudRepository<Venda, Long> {
    List<Venda> findByDateTimeBetween(LocalDateTime dateStart, LocalDateTime dateEnd);
}
