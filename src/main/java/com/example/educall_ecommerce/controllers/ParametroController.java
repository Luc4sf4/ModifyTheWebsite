package com.example.educall_ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.educall_ecommerce.models.Parameter;
import com.example.educall_ecommerce.services.ParameterService;

@RequestMapping("cadastros/parameter")
@RestController
public class ParametroController {

    @Autowired
    ParameterService service;

    
    @PostMapping("/save")
    public String saveParameter(@RequestBody Parameter parameter) {
        
        Parameter newParameter = service.saveParameter(parameter);
        
        return "Usuario Criado!!" + newParameter.getId();
    }

    @GetMapping("/findAll")
    public List<Parameter> getParameters() {
        return service.findAllParameter(null);
    }
    
    @GetMapping("/{id}")
    public Parameter findByID(@PathVariable Long id) {
        return service.findByIdParameter(id);
    }
    @PutMapping("/{id}")
    public String updateParamneter(@PathVariable Long id, @RequestBody Parameter updatedParameter) {
        Parameter parameter = service.findByIdParameter(id);
        if (parameter != null) {
            parameter.setColecoes(updatedParameter.getColecoes());
            parameter.setDescontos(updatedParameter.getDescontos());
            parameter.setFooter(updatedParameter.getFooter());
            parameter.setNovidades(updatedParameter.getNovidades());
            parameter.setSitetitle(updatedParameter.getSitetitle());
            parameter.setStatus(updatedParameter.getStatus());
        

            service.saveParameter(parameter);
            return "Parametro atualizado com sucesso!";
        } else {
            return "Parametro não encontrado.";
        }
    }

    @DeleteMapping("/{id}")
    public String deleParameter(@PathVariable Long id, @RequestParam Parameter param){
        if(param.getId() == null){
            return "Paramaetro não encontrado para deletar.";
        }else{
            service.delete(id);
            return "Parametro deletado com sucesso";
        }
    }

}
