package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PruebaServiceImpl implements IPruebaService {

	@Override
	@Transactional(value = TxType.NEVER)
	public void prueba() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Método de prueba 2");
		
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void prueba3() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Método de Mandatory");
		
	}

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void pruebaSupports() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Método de Supports");
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public void pruebaNotSupports() {
		System.out.println("Prueba Not_Support: "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Método de Not_Supports");
		
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void pruebaRequired() {
		System.out.println("Prueba Requeredt: "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Método de Requered");
		
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void pruebaRequiresNew() {
		System.out.println("Prueba Requeres_new: "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Método de Requeres_new");
		
	}

}
