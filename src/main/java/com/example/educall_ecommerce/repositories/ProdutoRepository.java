package com.example.educall_ecommerce.repositories;

import java.util.List;

import com.example.educall_ecommerce.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {

        //@Query("SELECT p FROM db_produtos p WHERE p.categoria.idCategoria = :categoriaId")
        //List<Produto> findByCategoriaId(@Param("categoriaId") Long categoriaId);


        List<Produto> findAllByCategoria_IdCategoria(@Param("categoria_id") Long categoria_id);

}