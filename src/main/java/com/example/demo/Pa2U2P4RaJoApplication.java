package com.example.demo;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITransferenciaService;




@SpringBootApplication
public class Pa2U2P4RaJoApplication implements CommandLineRunner {

	@Autowired
	private IPropietarioService propietarioService;
	
	@Autowired
	private ITransferenciaService transferenciaService;
	
	@Autowired
	private ICuentaBancariaService cuentaBancariaService;

	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4RaJoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
	
		
		
		//1.Cuenta Bancaria
	
		Propietario prop= new Propietario();
		prop.setNombre("Jimmy");
		prop.setApellido("Ortega");
		prop.setCedula("010");
		//this.propietarioService.ingresar(prop);
		
		
		Propietario prop2= new Propietario();
		prop2.setNombre("Fabricio");
		prop2.setApellido("Salinas");
		prop2.setCedula("020");
		//this.propietarioService.ingresar(prop2);
		
		//Propietario propD = this.propietarioService.buscarCedula("020");
		
		CuentaBancaria cuent = new CuentaBancaria();
		cuent.setNumero("111");
		cuent.setTipo("C");
		cuent.setSaldo(new BigDecimal(1000));
		//cuent.setPropietario(propD);
		
		//this.cuentaBancariaService.ingresar(cuent);
		
		CuentaBancaria cuent2 = new CuentaBancaria();
		cuent2.setNumero("222");
		//cuent2.setPropietario(propD);
		cuent2.setTipo("A");
		cuent2.setSaldo(new BigDecimal(2000));
		
	//this.cuentaBancariaService.ingresar(cuent2);
		
		this.transferenciaService.realizarTransferencia("111", "222", new BigDecimal(5008));
//		
//		this.transferenciaService.buscarTodos().stream().forEach(System.out::println);
//		
//		
//		
		
		
		
	
	
	
		
	
		
		
		
	
	
		
		
	}
	
	

}
