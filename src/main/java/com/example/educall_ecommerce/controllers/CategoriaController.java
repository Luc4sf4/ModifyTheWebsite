package com.example.educall_ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.educall_ecommerce.models.Categoria;
import com.example.educall_ecommerce.services.CategoriaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("cadastros/categoria")
@RestController
public class CategoriaController {

    @Autowired
    CategoriaService service;

    @PostMapping("/save")
    public String saveCategoria(@RequestBody Categoria categoria) {

        Categoria newCategory = service.saveCategory(categoria);

        return "Categoria criado com sucesso" + newCategory.getIdCategoria();
    }

    @GetMapping("/findall")
    public List<Categoria> getAllCategoria() {
        return service.findAllCategories(null);
    }

    @GetMapping("/{id}")
    public Categoria getCategoriaId(@PathVariable Long id) {
        return service.findByIdCategoria(id);
    }

    @PutMapping("/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Categoria updatedCategoria) {
        Categoria category = service.findByIdCategoria(id);

        if (category != null) {

            category.setDescription(updatedCategoria.getDescription());
            saveCategoria(updatedCategoria);
            return "Atualizado com sucesso!";
        }
        return "Não encontrado para o update";
    }

    @DeleteMapping("/{id}")
    public String deleteCategoria(@PathVariable Long id, @RequestParam Categoria categoria) {

        if (categoria != null) {
            service.deleteC(id);
            return "Deletado com sucesso";
        } else {
            return "Erro ao deletar";
        }
    }

}
