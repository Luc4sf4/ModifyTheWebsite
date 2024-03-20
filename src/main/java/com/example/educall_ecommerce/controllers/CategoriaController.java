package com.example.educall_ecommerce.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.educall_ecommerce.models.Categoria;
import com.example.educall_ecommerce.services.CategoriaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

        Categoria newCategoria = service.saveCategory(categoria);
        
        return "Criado com sucesso" + newCategoria.getIdCategoria();
    }
    

    @GetMapping("/findAll")
    public List<Categoria> getCategorias () {
        return service.findAllCategories();
    }
    

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable long id) {
        return service.findByIdCategoria(id);
    }
    
    @PutMapping("/{id}")
    public String updateCategory(@PathVariable Long id, @RequestBody Categoria updatedCategoria) {
        Categoria category = service.findByIdCategoria(id);

        if(category != null){

            category.setDescription(updatedCategoria.getDescription());
            service.saveCategory(category);
            return "Atualizado com Sucesso";
        }
        return "Não encontrado para a atulização";
    }

    @DeleteMapping("/{id}")
    public String deleCategoryString(@PathVariable long id, @RequestParam Categoria categoria) {
        if(categoria != null){
            return "Não encontrado";
        }else{
            service.delete(id);
            return"Deletado com sucesso";
        }


    }


}
