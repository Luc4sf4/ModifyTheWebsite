package com.example.educall_ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.educall_ecommerce.models.Categoria;
import com.example.educall_ecommerce.models.Produtos;
import com.example.educall_ecommerce.repositories.CategoriaRepository;
import com.example.educall_ecommerce.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produtos salvarProduto(Produtos produto, Long categoriaId) {
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        produto.setCategoria(categoria);
        return produtoRepository.save(produto);
    }

    @Transactional(readOnly = true)
    public List<Produtos> findByCategoria(Long categoriaId) {
        return produtoRepository.findByCategoriaId(categoriaId);
    }

    public List<Produtos> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produtos findById(Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    public Produtos updateProdutos(Long id, Produtos updatedProdutos, Long categoriaId) {
        Produtos produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
        if (produto != null) {
            produto.setNome(updatedProdutos.getNome());
            produto.setPreco(updatedProdutos.getPreco());
            produto.setBase64(updatedProdutos.getBase64());
            produto.setCategoria(categoria);

            return produtoRepository.save(produto);

        }
        return null;

    }

    public void deletarProduto(Long id) {
        Produtos produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        produtoRepository.delete(produto);
    }

}