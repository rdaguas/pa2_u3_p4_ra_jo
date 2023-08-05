package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.funcional.Main;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U2P4RaJoApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Pa2U2P4RaJoApplication.class);

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

		// indica el nombre del hilo que ejecuta el programa
		LOG.info("HILO: " + Thread.currentThread().getName());

		// 1.Cuenta Bancaria
		/*
		 * Hilos, sincrona: sencuncial //inicio long tiempoInicial =
		 * System.currentTimeMillis(); for(int i=1; i <= 30; i++) { CuentaBancaria cuent
		 * = new CuentaBancaria(); cuent.setNumero(String.valueOf(i));
		 * cuent.setSaldo(new BigDecimal(100)); cuent.setTipo("AB");
		 * this.cuentaBancariaService.ingresar(cuent); } //fin long tiempoFinal =
		 * System.currentTimeMillis(); long tiempoTranscurrido =
		 * (tiempoFinal-tiempoInicial)/1000; LOG.info("Tiempo transcurrido: " +
		 * (tiempoFinal-tiempoInicial)); LOG.info("Tiempo transcurrido: " +
		 * tiempoTranscurrido);
		 * 
		 */

		/*
		// MULTIHILOS

		// inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CuentaBancaria> lista = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			CuentaBancaria cuent = new CuentaBancaria();
			cuent.setNumero(String.valueOf(i));
			cuent.setSaldo(new BigDecimal(100));
			cuent.setTipo("AB");
			lista.add(cuent);
		}

		// lista.stream().forEach(cta -> this.cuentaBancariaService.ingresar(cta));
		// para hacer programacion multihilo uso paralleStream()
		lista.parallelStream().forEach(cta -> this.cuentaBancariaService.ingresar(cta));

		// fin
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiempo transcurrido: " + tiempoTranscurrido);
*/
		
		
		
		// inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CuentaBancaria> lista = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			CuentaBancaria cuent = new CuentaBancaria();
			cuent.setNumero(String.valueOf(i));
			cuent.setSaldo(new BigDecimal(100));
			cuent.setTipo("AB");
			lista.add(cuent);
		}

		// lista.stream().forEach(cta -> this.cuentaBancariaService.ingresar(cta));
		// para hacer programacion multihilo uso paralleStream()
		//.parallelStream().map(cta -> this.cuentaBancariaService.ingresar2(cta));
		Stream<String> listaFinal = lista.parallelStream().map(cuenta -> this.cuentaBancariaService.ingresar2(cuenta));
		LOG.info("Se guardaron las siguientes cuentas: ");
		listaFinal.forEach(cadena -> LOG.info(cadena));
		// fin
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiempo transcurrido: " + tiempoTranscurrido);

	}

}
