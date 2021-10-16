package com.bcopstein.negocio.services;

import java.util.ArrayList;
import java.util.List;

import com.bcopstein.negocio.entities.ItemCarrinho;
import com.bcopstein.negocio.entities.ItemEstoque;
import com.bcopstein.negocio.entities.Produto;
import com.bcopstein.negocio.repositories.IEstoqueRepository;
import com.bcopstein.negocio.repositories.IProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoService {

    private IProdutoRepository repository;
    private IEstoqueRepository estoqueRepository;
    private List<String> vendasEfetuadas;

    @Autowired
    public ProdutoService(IProdutoRepository repository, IEstoqueRepository estoqueRepository) {
        this.repository = repository;
        this.estoqueRepository = estoqueRepository;
    }


    public List<Produto> findAll() {
        Iterable<Produto> produtos = repository.findAll();
        List<Produto> produtosList = new ArrayList<>();

        for (Produto p : produtos) {
            produtosList.add(p);
        }
        return produtosList;
    }

    public Integer[] calculaSubtotal(ItemCarrinho[] itens) {
        Integer subtotal = 0;
        Integer imposto = 0;

        for (final ItemCarrinho it : itens) {
            // Procurar o produto pelo código
            final Produto prod = repository.findById(it.getCodigo());
            if (prod != null) {
                subtotal += (int) (prod.getPreco() * it.getQuantidade());
            } else {
                throw new IllegalArgumentException("Codigo invalido");
            }
        }
        imposto = (int) (subtotal * 0.1);
        final Integer[] resp = new Integer[3];
        resp[0] = subtotal;
        resp[1] = imposto;
        resp[2] = subtotal + imposto;
        return resp;
    }

    public boolean confirmaVenda(ItemCarrinho[] itens) {
        vendasEfetuadas = new ArrayList<>();
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        ArrayList<Integer> listaQtdades = new ArrayList<>();

        for (ItemCarrinho item : itens) {
            final Produto produto = repository.findById(item.getCodigo());

            if (produto == null) {
                return false;
            }

            listaQtdades.add(item.getQuantidade());
            listaProdutos.add(produto);
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < listaProdutos.size(); i++) {
            final Produto produto = listaProdutos.get(i);
            final int qtdade = listaQtdades.get(i);
            produto.saidaDeProduto(qtdade);

            builder.append(produto.getCodigo());
            builder.append(" ");
            builder.append(produto.getDescricao());
            builder.append(" ");
            builder.append(qtdade);
            builder.append("\n");
        }

        vendasEfetuadas.add(builder.toString());
        return true;
    }

    public List<String> vendasEfetuadas() {
        return this.vendasEfetuadas;
    }

    public boolean podeVender(Long codProd, Integer qtdade) {
        ItemEstoque item = estoqueRepository.findByCodProd(codProd);
        if(item == null) return false;
        int quantidade = estoqueRepository.findByCodProd(codProd).getQtdProduto();

        return quantidade >= qtdade;
    }
}
