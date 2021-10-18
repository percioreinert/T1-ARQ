package com.bcopstein.negocio.entities;

import javax.persistence.*;

@Entity(name = "item_vendas")
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private Venda venda;
    private int qtdProduto;
    private int precoUnit;
    private long imposto;

    @OneToOne(cascade = CascadeType.ALL, optional = false,  orphanRemoval = true)
    @JoinColumn(name = "cod_produto")
    private Produto produto;

    public ItemVenda(int qtdProduto, int precoUnit, long imposto, Produto produto) {
        this.qtdProduto = qtdProduto;
        this.precoUnit = precoUnit;
        this.produto = produto;
    }
    public long getImposto() {
        return imposto;
    }
    public void setImposto(long imposto) {
        this.imposto = imposto;
    }
    public int getPrecoUnit() {
        return precoUnit;
    }
    public void setPrecoUnit(int precoUnit) {
        this.precoUnit = precoUnit;
    }
    public int getQtdProduto(){return this.qtdProduto;}

    public long getCodigo() {
        return produto.getCodigo();
    }

    public Produto getProduto(){return this.produto;}
    public void setQtdProduto(int qtdProduto){this.qtdProduto = qtdProduto;}
}

