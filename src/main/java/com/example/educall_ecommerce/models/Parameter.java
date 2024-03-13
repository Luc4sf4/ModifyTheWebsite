package com.example.educall_ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "db_parameter")
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String sitetitle;//
	
	private String status;
	
	private String footer;//

    private String descontos;//
	
	private String novidades;//

    private String subTitle;
	
	private String tituloHome;//
	
	private String colecoes;//
}
