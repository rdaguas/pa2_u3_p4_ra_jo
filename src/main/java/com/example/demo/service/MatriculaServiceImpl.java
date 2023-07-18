package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements IMatriculaService {
	
	@Autowired
	private IMatriculaRepository matriculaRepository;

	@Override
	public void agregarMatricula(Matricula matricula) {
		this.matriculaRepository.insertar(matricula);
		
	}

}
