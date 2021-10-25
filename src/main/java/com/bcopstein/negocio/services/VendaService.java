package com.bcopstein.negocio.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.bcopstein.negocio.entities.*;
import com.bcopstein.negocio.repositories.IEstoqueRepository;
import com.bcopstein.negocio.repositories.IVendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VendaService {

    private IVendaRepository vendaRepository;
    private EstoqueService estoqueService;
    private ProdutoService produtoService;

    private static long IMPOSTO = 10L;
    
    @Autowired
    public VendaService(IVendaRepository vendaRepository, EstoqueService estoqueService, ProdutoService produtoService) {
        this.vendaRepository = vendaRepository;
        this.estoqueService = estoqueService;
        this.produtoService = produtoService;
    }

    public Integer[] calculaSubtotal(ItemEstoque[] itens) {
        int subtotal = 0;
        int imposto = 0;
        for (ItemEstoque it : itens) {
            validaItemEstoque(it, 0);
            int quantidade = it.getQuantidade();
            it = estoqueService.getItemEstoque(it.getCodigo()); 
            validaItemEstoque(it, quantidade);
            subtotal += (int) (it.getProduto().getPreco() * quantidade);

        }
        imposto = (int)(subtotal * (IMPOSTO / 100.0));
        final Integer[] resp = new Integer[3];
        resp[0] = subtotal;
        resp[1] = imposto;
        resp[2] = subtotal + imposto;
        return resp;
    }
    
    public boolean confirmaVenda(ItemEstoque[] itens) {
        ArrayList<ItemVenda> listaItemVenda = new ArrayList<>();
        ArrayList<ItemEstoque> listaItemEstoque = new ArrayList<>();
        Venda venda = new Venda(LocalDateTime.now(), listaItemVenda);
        for (ItemEstoque item : itens) {

            if(item.getProduto() == null)
                return false;

            long codigoProduto = item.getCodigo();
            int quantidade = item.getQuantidade();
            
            if(quantidade <= 0)
                return false;

            ItemEstoque itemEstoque = listaItemEstoque.stream().filter(y -> y.getCodigo() == codigoProduto).findFirst().get().orElseThrow(null);
            
            if(itemEstoque == null || itemEstoque.getProduto() == null){
                itemEstoque = estoqueService.getItemEstoque(codigoProduto);
                
                if(itemEstoque == null || itemEstoque.getProduto() == null)
                    return false;
                
                listaItemEstoque.add(itemEstoque);
            }

            quantidade = itemEstoque.getQuantidade() - quantidade;

            if(quantidade >= 0)
                itemEstoque.setQuantidade(quantidade);
            else 
                return false;

            ItemVenda itemLista = listaItemVenda.stream().filter(x -> x.getCodigo() == codigoProduto).findFirst().get().orElseThrow(null);
            
            if(itemLista != null)
                itemLista.setQtdProduto(quantidade);
            else{
                itemLista = new ItemVenda(quantidade, itemEstoque.getProduto().getPreco(), IMPOSTO, itemEstoque.getProduto(), venda);
                listaItemVenda.add(itemLista);
            }
        }
        vendaRepository.save(venda);
        estoqueService.save(listaItemEstoque);
        return true;
    }

    public Iterable<Venda> vendasEfetuadas() {
        return vendaRepository.findAll();
    }
    public boolean podeVender(long codProd, int qtdade){
        if(qtdade <= 0)
            return false;
        ItemEstoque item = estoqueService.getItemEstoque(codProd);
        if(item == null || qtdade > item.getQuantidade() || item.getQuantidade() - qtdade < 0) 
            return false;

        item.setQuantidade(item.getQuantidade()-qtdade);
        return true;
    }
    private void validaItemEstoque(ItemEstoque itemEstoque, int quantidade){
        String errorMessage = "";
        
        if (itemEstoque == null)
            errorMessage = "item inválido";
        else if(itemEstoque.getQuantidade() - quantidade < 0) 
                errorMessage = "quantidade inválida";

        if(!errorMessage.isEmpty())
            throw new IllegalArgumentException(errorMessage);
    }
}
