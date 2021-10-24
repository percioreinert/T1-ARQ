package com.bcopstein.negocio.entities;

import javax.persistence.*;

@Table(name = "item_estoques")
@Entity(name = "ItemEstoque")
public class ItemEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "cod_produto")
    private Produto produto;
    
    private int qtdProduto;

    public ItemEstoque() {}

    public ItemEstoque(Produto produto, int qtdProduto) {
        this.qtdProduto = qtdProduto;
        this.produto=produto;
    }

    public int getQtdProduto(){return this.qtdProduto;}

    public long getCodigo() {
        return produto.getCodigo();
    }

    public void setQtdProduto(int qtdProduto){this.qtdProduto=qtdProduto;}

    public Produto getProduto(){return this.produto;}
}
