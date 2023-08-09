package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {

	public void ingresar(CuentaBancaria cuentaBancaria);

	public String ingresar2(CuentaBancaria cuentaBancaria);

	public void actualizar(CuentaBancaria cuentaBancaria);

	public CuentaBancaria buscarPorNumero(String numero);

	public void agregarAsincrono(CuentaBancaria bancaria);
	
	public CompletableFuture<String>  agregarAsincrono2(CuentaBancaria bancaria);

}
