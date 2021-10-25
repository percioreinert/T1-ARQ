package com.bcopstein.adaptadores.controllers;

import java.util.List;

import com.bcopstein.negocio.entities.ItemEstoque;
import com.bcopstein.negocio.entities.Produto;
import com.bcopstein.negocio.entities.Venda;
import com.bcopstein.negocio.services.EstoqueService;
import com.bcopstein.negocio.services.ProdutoService;
import com.bcopstein.negocio.services.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/vendas")
public class SvFachadaRemota {

  private VendaService vService;
  ProdutoService pService;
  EstoqueService sEstoque;

  @Autowired
  public SvFachadaRemota(VendaService vService, ProdutoService pService, EstoqueService sEstoque) {
    this.vService = vService;
    this.pService=pService;
    this.sEstoque=sEstoque;
  }

  @GetMapping("/produtos")
  @CrossOrigin(origins = "*")
  public List<Produto> listaProdutos() {
    return pService.findAll();
  }

  @GetMapping("/autorizacao")
  @CrossOrigin(origins = "*")
  public boolean podeVender(@RequestParam final long codProd,
                            @RequestParam final int qtdade) {
    return vService.podeVender(codProd, qtdade);
  }

  @PostMapping("/confirmacao")
  @CrossOrigin(origins = "*")
  public boolean confirmaVenda(@RequestBody final ItemEstoque[] itens) {
    // for(ItemEstoque item : itens){
    //   sEstoque.save(item);
    // }
    vService.confirmaVenda(itens);
    return true;
  }

  @GetMapping("/historico")
  @CrossOrigin(origins = "*")
  public Iterable<Venda> vendasEfetuadas() {
    return vService.vendasEfetuadas();
  }

  @PostMapping("/subtotal")
  @CrossOrigin(origins = "*")
  public Integer[] calculaSubtotal(@RequestBody final ItemEstoque[] itens) {
    return vService.calculaSubtotal(itens);
  }
}
