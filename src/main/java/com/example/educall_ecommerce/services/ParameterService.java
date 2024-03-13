package com.example.educall_ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.educall_ecommerce.models.Parameter;
import com.example.educall_ecommerce.repositories.ParametroRepository;

@Service
public class ParameterService {
    
    @Autowired
    ParametroRepository repository;

    public Parameter saveParameter(Parameter parameter){
        return repository.save(parameter);
    }

    public List<Parameter> findAllParameter(Parameter parameter){
        return repository.findAll();
    }

    public Parameter findByIdParameter(Long id){
        return repository.findById(id).orElse(null);
    }

    public Parameter upadateParameter(Long id, Parameter updatedParameter){
        Parameter parameter = repository.findById(id).orElse(null);

        if(parameter !=null){
            parameter.setColecoes(updatedParameter.getColecoes());
            parameter.setDescontos(updatedParameter.getDescontos());
            parameter.setFooter(updatedParameter.getFooter());
            parameter.setNovidades(updatedParameter.getNovidades());
            parameter.setSitetitle(updatedParameter.getSitetitle());
            parameter.setStatus(updatedParameter.getStatus());

            return repository.save(parameter);
        }
        return null;
    }

    public String delete(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Deletado com sucesso";
        }else{
            return "Não Encontrado para o delete";
        }
    }

}
