package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

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
@Table(name = "transferencia")
public class Transferencia {

	@Id

	@SequenceGenerator(name = "seq_transferencia", sequenceName = "seq_transferencia", allocationSize = 1)
	@GeneratedValue(generator = "seq_transferencia", strategy = GenerationType.SEQUENCE)

	@Column(name = "tran_id")

	private Integer id;
	
	@Column(name = "tran_fecha")
	private LocalDate fecha;
	
	@Column(name = "tran_monto")
	private BigDecimal monto;

	
	@ManyToOne
	@JoinColumn(name = "tran_id_cuentabancaria_origen")
	private CuentaBancaria cuentaBancariaO;
	
	@ManyToOne
	@JoinColumn(name = "tran_id_cuentabancaria_destino")
	private CuentaBancaria cuentaBancariaD;
	
	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", fecha=" + fecha + ", monto=" + monto + "]";
	}

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

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public CuentaBancaria getCuentaBancariaO() {
		return cuentaBancariaO;
	}

	public void setCuentaBancariaO(CuentaBancaria cuentaBancariaO) {
		this.cuentaBancariaO = cuentaBancariaO;
	}

	public CuentaBancaria getCuentaBancariaD() {
		return cuentaBancariaD;
	}

	public void setCuentaBancariaD(CuentaBancaria cuentaBancariaD) {
		this.cuentaBancariaD = cuentaBancariaD;
	}

	


	
	
	
	
	
	
}
