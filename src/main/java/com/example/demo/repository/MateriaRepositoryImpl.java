package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MateriaRepositoryImpl implements IMateriaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Materia materia) {
		this.entityManager.persist(materia);
		
	}

	@Override
	public List<Materia> seleccionarPorCodigo() {
		TypedQuery<Materia> myQuery= this.entityManager.createQuery("Select m from Materia m ",Materia.class);
	
		return myQuery.getResultList();
	}

}
