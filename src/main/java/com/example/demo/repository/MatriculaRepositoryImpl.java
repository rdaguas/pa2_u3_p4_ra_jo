package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Matricula matricula) {

		this.entityManager.persist(matricula);

	}

	@Override
	public List<Matricula> seleccionarTodos() {
		TypedQuery<Matricula> query = this.entityManager.createQuery("SELECT m FROM Matricula m", Matricula.class);
		return query.getResultList();
	}

}
