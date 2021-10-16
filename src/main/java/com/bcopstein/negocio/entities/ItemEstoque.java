package com.bcopstein.negocio.entities;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class ItemEstoque {

    @OneToMany
    @JoinColumn(name = "codigo")
    private Produto produto;
    private int codigo;
}
