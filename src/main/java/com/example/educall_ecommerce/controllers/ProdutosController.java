package com.example.educall_ecommerce.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.educall_ecommerce.models.Produtos;
import com.example.educall_ecommerce.services.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RequestMapping("cadastros/produtos")
@RestController
public class ProdutosController {

    @Autowired
    private ProdutoService service;

    @PostMapping("/save")
    public String saveProduct(@RequestBody Map<String, Object> payload) {
        Long categoriaId = Long.parseLong(payload.get("categoria_id").toString());
        Produtos produto = new Produtos();
        produto.setNome(payload.get("nome").toString());
        produto.setPreco(new BigDecimal(payload.get("preco").toString()));
        produto.setBase64(payload.get("base64").toString());

        Produtos newProdutos = service.salvarProduto(produto, categoriaId);
        return "Produto Criado com Sucesso! " + newProdutos.getId();
    }

    @GetMapping("/findAll")
    public List<Produtos> getProdutos() {
        return service.getAllProdutos();    
    }

    @GetMapping("/porcategoria/{categoriaId}")
    public List<Produtos> getProductCategory(@PathVariable Long categoriaId) {
        return service.findByCategoria(categoriaId);
    }
    
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id, @RequestParam Produtos produto){
        if(produto.getId() == null){
            return "Não encontrado para delete";
        }
        service.deletarProduto(id);

        return "deletado com sucesso!";

    }


}
