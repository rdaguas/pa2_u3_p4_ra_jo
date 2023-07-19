package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepository {
	
	public void insertar(Materia materia);
	
	public List<Materia> seleccionarPorCodigo();
	public Materia seleccionarPorcodigo(String codigo);

}
