package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Transferencia;

import jakarta.transaction.Transactional;

public interface ITransferenciaService {
	
	public void realizarTransferencia(String numeroO, String numeroD, BigDecimal monto);
	
	public List<Transferencia> buscarTodos();
	

}
