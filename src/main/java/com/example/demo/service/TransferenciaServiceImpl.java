package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.ITransferenciaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;

import jakarta.transaction.Transactional;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {
	
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Autowired
	private ITransferenciaRepository transferenciaRepository;
	
	@Override
	public void realizarTransferencia(String numeroO, String numeroD, BigDecimal monto) {
		
		CuentaBancaria cuentaO = this.bancariaRepository.seleccionarPorNumero(numeroO);
		CuentaBancaria cuentaD = this.bancariaRepository.seleccionarPorNumero(numeroD);
	
		Transferencia transfer = new Transferencia();
		transfer.setCuentaBancariaO(cuentaO);
		transfer.setCuentaBancariaD(cuentaD);
		transfer.setFecha(LocalDate.now());
		transfer.setMonto(monto);
		
		if(cuentaO.getSaldo().compareTo(monto)>=0) {
			
			cuentaO.setSaldo(cuentaO.getSaldo().subtract(monto));
			this.bancariaRepository.actualizar(cuentaO);
			
			cuentaO.setSaldo(cuentaD.getSaldo().subtract(monto));
			this.bancariaRepository.actualizar(cuentaD);
			
			this.transferenciaRepository.insertar(transfer);
			
		}else {
			System.out.println("SALDO INSUFICIENTE");
		}
		
		
		
	}

	@Override
	public List<Transferencia> buscarTodos() {
		
		System.out.println("-REPORTE-");
		
		return this.transferenciaRepository.seleccionarTodos();
	}

}
