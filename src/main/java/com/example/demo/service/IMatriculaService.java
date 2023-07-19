package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaService {
	
	public void agregarMatricula(String cedula, List<String> codMat);
	
	public List<Matricula> buscarReporte();
	
	
	

}
