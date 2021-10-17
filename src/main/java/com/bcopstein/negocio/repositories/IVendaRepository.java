package com.bcopstein.negocio.repositories;

import java.util.List;
import java.time.LocalDateTime;

import com.bcopstein.negocio.entities.Venda;

public interface IVendaRepository{
    
    Venda findById(long id);
    Iterable<Venda> findAll();
    Venda save(Venda item);
    boolean saveAll(List<Venda> itens);
    boolean update(Venda item);
    void delete(Venda item);
    List<Venda> findByDateTimeBetween(LocalDateTime dateStart, LocalDateTime dateEnd);
}
