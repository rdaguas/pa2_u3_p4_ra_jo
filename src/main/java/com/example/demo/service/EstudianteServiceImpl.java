package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {
	
	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void agregar(Estudiante estudiante) {
		this.estudianteRepository.insertar(estudiante);
		
	}


	@Override
	public Estudiante buscarPorCedula(String cedula) {
		return this.estudianteRepository.seleccionarPorCedula(cedula);
	}

}
