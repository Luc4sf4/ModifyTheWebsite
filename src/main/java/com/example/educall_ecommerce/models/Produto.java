package com.example.educall_ecommerce.models;

import java.math.BigDecimal;

import com.example.educall_ecommerce.dtos.ProdutoDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name="db_produtos")
@Entity(name="db_produtos")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;

    private String description;

    private BigDecimal preco;

    @Column(columnDefinition="TEXT")
    private String base64;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Produto(ProdutoDTO data) {
        this.nome = data.nome();
        this.description = data.description();
        this.preco = data.preco();
        this.base64 = data.base64();
    }
}
