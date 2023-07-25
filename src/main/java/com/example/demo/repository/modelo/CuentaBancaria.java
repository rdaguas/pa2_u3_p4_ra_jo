package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

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
@Table(name = "cuentabancaria")

public class CuentaBancaria {

	@Id

	@SequenceGenerator(name = "seq_cuenta_bancaria", sequenceName = "seq_cuenta_bancaria", allocationSize = 1)
	@GeneratedValue(generator = "seq_cuenta_bancaria", strategy = GenerationType.SEQUENCE)

	@Column(name = "cuba_id")

	private Integer id;

	@Column(name = "cuba_numero")
	private String numero;

	@Column(name = "cuba_saldo")
	private BigDecimal saldo;

	@Column(name = "cuba_tipo")
	private String tipo;

	
	@ManyToOne
	@JoinColumn(name = "cuba_id_propietario")
	private Propietario propietario;
	
	
	@OneToMany(mappedBy = "cuentaBancariaO")
	private List<Transferencia>transferencias1;
	
	@OneToMany(mappedBy = "cuentaBancariaD")
	private List<Transferencia>transferencias2;
	
	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", tipo=" + tipo + "]";
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

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}



	public List<Transferencia> getTransferencias1() {
		return transferencias1;
	}

	public void setTransferencias1(List<Transferencia> transferencias1) {
		this.transferencias1 = transferencias1;
	}

	public List<Transferencia> getTransferencias2() {
		return transferencias2;
	}

	public void setTransferencias2(List<Transferencia> transferencias2) {
		this.transferencias2 = transferencias2;
	}

	
	
	
	
}
