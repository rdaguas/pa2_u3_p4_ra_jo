package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.IPropietarioRepository;
import com.example.demo.repository.modelo.Propietario;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PropietarioServiceImpl implements IPropietarioService {
	
	@Autowired
	private IPropietarioRepository propietarioRepository;
	
	@Autowired
	private IPruebaService pruebaService;

	@Transactional(value = TxType.NEVER)
	public void prueba() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metódo de prueba");
	}
	
	@Override
	@Transactional
	public void ingresar(Propietario propietario) {
		System.out.println("Service:"+TransactionSynchronizationManager.isActualTransactionActive());
		this.propietarioRepository.insertar(propietario);
		//this.prueba();
		//this.pruebaService.prueba();
		//this.pruebaService.prueba3();
		//this.pruebaService.pruebaSupports();
		//this.pruebaService.pruebaNotSupports();
		//this.pruebaService.pruebaRequired();
		//this.pruebaService.pruebaRequiresNew();
	}

	@Override
	public Propietario buscarCedula(String cedula) {
		return this.propietarioRepository.seleccionarCedula(cedula);
	}

}
