package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Transferencia;

public interface ITransferenciaRepository {
	
	public void insertar(Transferencia transferencia);
	
	public List<Transferencia> seleccionarTodos();

}
