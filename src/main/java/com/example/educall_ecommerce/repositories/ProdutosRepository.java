package com.example.educall_ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.educall_ecommerce.models.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

        @Query("SELECT p FROM db_produtos p WHERE p.categoria.id = :categoriaId")
        List<Produtos> findByCategoriaId(@Param("categoriaId") Long categoriaId);


        

}
