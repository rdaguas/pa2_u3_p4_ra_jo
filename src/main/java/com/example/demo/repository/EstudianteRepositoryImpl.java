package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class EstudianteRepositoryImpl implements IEstudianteRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("Select e from Estudiante e WHERE e.cedula =:datoCedula",Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

}
