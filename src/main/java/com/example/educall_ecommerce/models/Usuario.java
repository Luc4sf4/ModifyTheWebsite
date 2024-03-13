package com.example.educall_ecommerce.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "db_user")
public class Usuario implements Serializable {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;

	private String email;

	private String password;

	private Long  admin;

	private String status;

}
