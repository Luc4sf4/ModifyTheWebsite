package com.example.educall_ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.educall_ecommerce.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
