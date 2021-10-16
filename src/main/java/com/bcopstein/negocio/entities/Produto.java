package com.bcopstein.negocio.entities;

import javax.persistence.*;

@Entity
public class Produto {

  @Id
  private Long codigo;
  private String descricao;
  private double preco;
  private int qtdade;

  public Produto(Long codigo, String descricao, double preco, int qtdade) {
    this.codigo = codigo;
    this.descricao = descricao;
    this.preco = preco;
    this.qtdade = qtdade;
  }

  public Produto() {

  }

  public Long getCodigo() {
    return codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public double getPreco() {
    return preco;
  }

  public int getQtdade() {
    return qtdade;
  }

  public void saidaDeProduto(int qtdade) {
    this.qtdade -= qtdade;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  @Override
  public String toString() {
    return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco
        + ", qtdade=" + qtdade + "]";
  }
}
