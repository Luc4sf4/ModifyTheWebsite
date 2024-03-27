package com.example.educall_ecommerce.controllers;

import java.util.Base64;
import java.util.List;

import com.example.educall_ecommerce.dtos.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.educall_ecommerce.models.Produto;
import com.example.educall_ecommerce.services.ProdutoService;

@RestController
@RequestMapping("cadastros/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/save")
    public ResponseEntity<Produto> saveProduct(@RequestBody ProdutoDTO produto) throws Exception {
        var novoProduto = this.produtoService.criarProduto(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public List<Produto> getProdutos() {
        return produtoService.getAllProdutos();
    }

    @GetMapping("/porcategoria/{categoriaId}")
    public ResponseEntity<List<Produto>> getProductCategory(@PathVariable Long categoriaId) {

        var produtos = this.produtoService.findByCategoria(categoriaId);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id, @RequestParam Produto produto){
        if(produto.getId() == null){
            return "Não encontrado para delete";
        }
        produtoService.deletarProduto(id);

        return "deletado com sucesso!";

    }

    @GetMapping("/imagem/{id}")
public ResponseEntity<byte[]> getImagemProduto(@PathVariable String id) {
    Produto produto = produtoService.findById(id);
    if (produto == null || produto.getBase64() == null) {
        return ResponseEntity.notFound().build();
    }

    byte[] imagemBytes = Base64.getDecoder().decode(produto.getBase64());

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.IMAGE_JPEG);

    return new ResponseEntity<>(imagemBytes, headers, HttpStatus.OK);
}

}