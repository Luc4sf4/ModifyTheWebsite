package com.example.educall_ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.educall_ecommerce.models.Categoria;
import com.example.educall_ecommerce.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Categoria saveCategory(Categoria category) {
        return repository.save(category);
    }

    public List<Categoria> findAllCategories(Categoria category ){

        return repository.findAll();

    }
    
    public Categoria findByIdCategoria(Long id){
        return repository.findById(id).orElse(null);
    }

    public Categoria updateCategoria (Long id, Categoria updatedCategoria){

        Categoria category = repository.findById(id).orElse(null);

        if(category != null){

            category.setDescription(updatedCategoria.getDescription());
            return repository.save(category);

        }

        return null;

    }


    public String deleteC(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Deletado com sucesso";
        }else{
            return "Não encontrado para o delete";
        }


    }


}
