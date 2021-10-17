package com.bcopstein.negocio.entities;

import javax.persistence.*;

@Entity(name = "ItemEstoques")
public class ItemEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "codigo")
    private Produto produto;
    private int qtdProduto;

    public ItemEstoque() {}

    public int getQtdProduto(){return this.qtdProduto;}

    public long getCodigo() {
        return produto.getCodigo();
    }

    public void setQtdProduto(int qtdProduto){this.qtdProduto=qtdProduto;}

    public Produto getProduto(){return this.produto;}
}
