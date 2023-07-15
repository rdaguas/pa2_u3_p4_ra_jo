package com.example.demo.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "propietario")
public class Propietario {
	
	@Id
	@Column(name = "prop_id")
	private Integer id;
	
	@Column(name = "prop_nombre")
	private String nombre;
	
	
	@Column(name = "prop_apellido")
	private String apellido;
	
	@Column(name = "prop_cedula")
	private String cedula;
	

}
