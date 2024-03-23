package com.example.educall_ecommerce.services;

import java.util.List;

import com.example.educall_ecommerce.dtos.ProdutoDTO;
import com.example.educall_ecommerce.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.educall_ecommerce.models.Categoria;
import com.example.educall_ecommerce.repositories.CategoriaRepository;
import com.example.educall_ecommerce.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto criarProduto(ProdutoDTO data) throws Exception {
        Produto novoProduto = new Produto(data);
        novoProduto.setCategoria((categoriaRepository.findById(data.categoria())
                .orElseThrow(() -> new Exception("Categoria não encontrado"))
        ));

        this.produtoRepository.save(novoProduto);
        return novoProduto;
    }


    public Produto salvarProduto(Produto produto, Long categoriaId) {


        //produto.setCategoria(categoria);
        return produtoRepository.save(produto);
    }

    @Transactional(readOnly = true)
    public List<Produto> findByCategoria(Long categoriaId) {
        return produtoRepository.findByCategoriaId(categoriaId);
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto updateProdutos(Long id, Produto updatedProdutos, Long categoriaId) {
        Produto produto = produtoRepository.findById(id)
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
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        produtoRepository.delete(produto);
    }

}