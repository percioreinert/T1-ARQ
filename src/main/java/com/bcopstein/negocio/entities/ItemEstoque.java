package com.bcopstein.negocio.entities;

import javax.persistence.*;

@Entity
public class ItemEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinColumn(name = "codigo")
    private Produto produto;
    private int codigo;
}
