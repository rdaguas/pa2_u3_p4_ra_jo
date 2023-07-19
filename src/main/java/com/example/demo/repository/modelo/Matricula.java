package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {

	@GeneratedValue(generator = "seq_matricula", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)

	@Id
	@Column(name = "mtla_id")
	private Integer id;

	@Column(name = "mtla_fecha")
	private LocalDate fecha;

	@Column(name = "mtla_numero")
	private String numero;
	
	@Column(name="mtla_precio")
	private BigDecimal precio;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mtla_id_estudiante")
	private Estudiante estudiante;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mtla_id_materia")
	private Materia materia;
	
	// set y get

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}


	
	

	

}
