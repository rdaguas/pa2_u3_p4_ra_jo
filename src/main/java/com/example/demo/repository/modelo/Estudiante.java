package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {

	@GeneratedValue(generator = "seq_estudiante", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante", allocationSize = 1)

	@Id
	@Column(name = "estu_id")
	private Integer id;

	@Column(name = "estu_nombre")
	private String nombre;
	
	@Column(name="estu_cedula")
	private String cedula;
	
	@Column(name="estu_apellido")
	private String apellido;

	@OneToMany(mappedBy = "estudiante")
	private List<Matricula> matriculas;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="estudiante_id_provincia")
	private Provincia provincia;
	
	

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", cedula=" + cedula + ", apellido=" + apellido + "]";
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	
	

}
