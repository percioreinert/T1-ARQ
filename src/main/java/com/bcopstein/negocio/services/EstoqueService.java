package com.bcopstein.negocio.services;

import com.bcopstein.negocio.entities.ItemEstoque;
import com.bcopstein.negocio.repositories.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {

    private IEstoqueRepository estoqueRepository;
    
    @Autowired
    public EstoqueService(IEstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public boolean podeVender(Long codProd, Integer qtdade) {
        ItemEstoque item = estoqueRepository.findByProduto(codProd);
        if(item == null) return false;
        int quantidade = item.getQtdProduto();

        return quantidade >= qtdade;
    }
    public int getQuantidade(Long codProd){
        ItemEstoque item = estoqueRepository.findByProduto(codProd);
        if(item == null) return -1;
        return item.getQtdProduto();
    }
    public ItemEstoque getItemEstoque(Long codPro){
        return estoqueRepository.findByProduto(codPro);
    }
}
