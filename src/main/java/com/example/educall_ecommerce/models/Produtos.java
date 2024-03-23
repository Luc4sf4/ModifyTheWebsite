package com.example.educall_ecommerce.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "db_produtos") 
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String description;

    private BigDecimal preco;

    @Lob
    private String base64;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
