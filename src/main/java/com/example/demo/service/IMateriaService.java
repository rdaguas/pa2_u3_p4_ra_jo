package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaService {
	
	public void insertar(Materia materia);
	
	public List<Materia> buscarPorCodigo();

}
