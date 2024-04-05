package com.example.educall_ecommerce.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.educall_ecommerce.models.Usuario;
import com.example.educall_ecommerce.services.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("cadastros/users")
@RestController
public class UsuarioController {

    @Autowired  
    UsuarioService usuarioService;      
    
    @PostMapping("/save")
    public String saveUserrs(@RequestBody Usuario usuario) {
        
        Usuario newUser = usuarioService.saveUsers(usuario); 
        
        return "Usuario Criado!!" + newUser.getId();
    }
    
    @GetMapping("/findAll")
    public List <Usuario> getUsers() {
        return usuarioService.findAllUser();
    }
    
    @GetMapping("/{id}")
    public Usuario findByID(@PathVariable Long id) {
        return usuarioService.findByIdUser(id);
    }

    @PutMapping("/{id}")
    public String atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.findByIdUser(id);
        if (usuarioExistente != null) {
            usuarioExistente.setNome(usuario.getNome());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setStatus(usuario.getStatus());
            usuarioExistente.setPassword(usuario.getPassword());

            usuarioService.saveUsers(usuarioExistente);
            return "Usuário atualizado com sucesso!";
        } else {
            return "Usuário não encontrado.";
        }
    }
    @DeleteMapping("/{id}")
    public String deletarUsuario(@PathVariable Long id, @RequestParam Usuario user) {
        if ( user.getId() == null) {
            return "Usuário não encontrado.";
            
        } else {
            usuarioService.deletar(id);
            return "Usuário deletado com sucesso!";
            
        }
    }


}
