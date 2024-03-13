package com.example.educall_ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.educall_ecommerce.models.Usuario;
import com.example.educall_ecommerce.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    
        public Usuario findByIdUser(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Usuario> findAllUser() {
        return repository.findAll();
    }

    public Usuario saveUsers(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario updateUser(Long id, Usuario usuarioUpdated) {
        Usuario usuarioExistente = repository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNome(usuarioUpdated.getNome());
            usuarioExistente.setEmail(usuarioUpdated.getEmail());
            usuarioExistente.setStatus(usuarioUpdated.getStatus());
            usuarioExistente.setPassword(usuarioUpdated.getPassword());

            return repository.save(usuarioExistente);
        }
        return null; 
    }
    
    public String deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Usuário deletado com sucesso!";
        } else {
            return "Usuário não encontrado.";
        }
    }


}