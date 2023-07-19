package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {

	@GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
	@Id
	@Column(name = "mate_id")
	private Integer id;

	@Column(name = "mate_nombre")
	private String nombre;
	
	@Column(name="mate_codigo")
	private String codigo;
	
	@Column(name="mate_precio")
	private BigDecimal precio;

	@OneToMany(mappedBy = "materia")
	private List<Matricula> matriculas;
	
	@ManyToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name="materia_id_semestre")
	private Semestre semestre;

	
	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", precio=" + precio + "]";
	}

	// set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}
	
	
	
	

}
