package com.example.educall_ecommerce.dtos;


import java.math.BigDecimal;

public record ProdutoDTO(String nome, String description, BigDecimal preco, String base64, Long categoria) {
}


