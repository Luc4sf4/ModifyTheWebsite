package com.example.educall_ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.educall_ecommerce.models.Parameter;

@Repository
public interface ParametroRepository extends JpaRepository<Parameter, Long> {

}
