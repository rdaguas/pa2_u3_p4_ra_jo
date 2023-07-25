package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class PropietarioRepositoryImpl implements IPropietarioRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Propietario propietario) {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		this.entityManager.persist(propietario);
		
	}

	@Override
	public Propietario seleccionarCedula(String cedula) {
		TypedQuery<Propietario>query=this.entityManager.createQuery("SELECT p from Propietario p WHERE p.cedula = :datoCedula",Propietario.class);
		query.setParameter("datoCedula", cedula);
		return query.getSingleResult();
	}

}
