package com.bcopstein.negocio.entities;

import javax.persistence.*;

@Entity(name = "item_estoques")
public class ItemEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "cod_produto")
    private Produto produto;
    
    private int qtdProduto;

    public ItemEstoque() {}

    public ItemEstoque(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public int getQtdProduto(){return this.qtdProduto;}

    public long getCodigo() {
        return produto.getCodigo();
    }

    public void setQtdProduto(int qtdProduto){this.qtdProduto=qtdProduto;}

    public Produto getProduto(){return this.produto;}
}
