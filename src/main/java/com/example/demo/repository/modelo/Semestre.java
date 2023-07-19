package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="semestre")
public class Semestre {
	
	@GeneratedValue(generator = "seq_semestre", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_semestre", sequenceName = "seq_semestre", allocationSize = 1)
	@Id
	@Column(name = "smtr_id")
	private Integer id;
	
	@Column(name="smtr_numero")
	private String numero;
	
	@Column(name="smtr_paralelo")
	private String paralelo;
	
	@Column(name="smtr_horario")
	private String horario;
	
	@OneToMany(mappedBy = "semestre")
	private List<Materia>materias;
	
	


	@Override
	public String toString() {
		return "Semestre [id=" + id + ", numero=" + numero + ", paralelo=" + paralelo + ", horario=" + horario + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getParalelo() {
		return paralelo;
	}

	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	
	

}
