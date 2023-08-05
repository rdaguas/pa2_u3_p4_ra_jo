package com.example.demo.service;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CuentaBancariaRepositoryImpl;
import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	private static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaServiceImpl.class);

	
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Override
	public void ingresar(CuentaBancaria cuentaBancaria) {
		LOG.info("HILO Service: " + Thread.currentThread().getName());
		//sumar.restar, multiplicar: logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepository.insertar(cuentaBancaria);
		
	}
	
	@Override
	public String ingresar2(CuentaBancaria cuentaBancaria) {
		LOG.info("HILO Service: " + Thread.currentThread().getName());
		//sumar.restar, multiplicar: logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepository.insertar(cuentaBancaria);
		return cuentaBancaria.getNumero();
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.bancariaRepository.actualizar(cuentaBancaria);
		
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numero) {
		return this.bancariaRepository.seleccionarPorNumero(numero);
	}

	

}
