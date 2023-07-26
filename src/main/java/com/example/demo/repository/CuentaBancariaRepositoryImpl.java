package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value =  TxType.REQUIRED)
	public void insertar(CuentaBancaria cuentaBancaria) {
		this.entityManager.persist(cuentaBancaria);
		//throw new RuntimeException();
		
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.entityManager.merge(cuentaBancaria);
		
	}

	@Override
	public CuentaBancaria seleccionarPorNumero(String numero) {
		TypedQuery<CuentaBancaria>query=this.entityManager.createQuery("SELECT c from CuentaBancaria c WHERE c.numero = :datoNumero",CuentaBancaria.class);
		query.setParameter("datoNumero", numero);
		return query.getSingleResult();
	}

}
