package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.demo.repository.modelo.CuentaBancaria;

import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITransferenciaService;

@SpringBootApplication
@EnableAsync
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

		/*
		 * //ASINCRONO SIN RESPUESTA // indica el nombre del hilo que ejecuta el
		 * programa LOG.info("HILO: " + Thread.currentThread().getName());
		 * 
		 * // inicio long tiempoInicial = System.currentTimeMillis();
		 * List<CuentaBancaria> lista = new ArrayList<>(); for (int i = 1; i <= 10; i++)
		 * { CuentaBancaria cuent = new CuentaBancaria();
		 * cuent.setNumero(String.valueOf(i)); cuent.setSaldo(new BigDecimal(100));
		 * cuent.setTipo("AB"); lista.add(cuent);
		 * this.cuentaBancariaService.agregarAsincrono(cuent); }
		 * 
		 * 
		 * // fin long tiempoFinal = System.currentTimeMillis(); long tiempoTranscurrido
		 * = (tiempoFinal - tiempoInicial) / 1000; LOG.info("Tiempo transcurrido: " +
		 * (tiempoFinal - tiempoInicial)); LOG.info("Tiempo transcurrido: " +
		 * tiempoTranscurrido);
		 * 
		 * LOG.info("Se termino todo el proceso!");
		 * 
		 */

		// ASINCRONO FUTURO CON RESPUESTA
		LOG.info("HILO: " + Thread.currentThread().getName());

		// inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CompletableFuture<String>> listaRespuesta = new ArrayList<>();
		List<CuentaBancaria> lista = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			CuentaBancaria cuent = new CuentaBancaria();
			cuent.setNumero(String.valueOf(i));
			cuent.setSaldo(new BigDecimal(100));
			cuent.setTipo("AB");
			lista.add(cuent);
		CompletableFuture<String> respuesta = this.cuentaBancariaService.agregarAsincrono2(cuent);
		listaRespuesta.add(respuesta);
		}
		
		//sentencia que espera que termine de procesarce los hilos para pbtener la respuesta
		CompletableFuture.allOf(listaRespuesta.get(0),listaRespuesta.get(1), listaRespuesta.get(2),listaRespuesta.get(3),
				listaRespuesta.get(4),listaRespuesta.get(5),listaRespuesta.get(6),listaRespuesta.get(7),listaRespuesta.get(8),
				listaRespuesta.get(9));
		LOG.info("Respuesta del 0: " + listaRespuesta.get(0).get());
		// fin
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiempo transcurrido: " + tiempoTranscurrido);
		LOG.info("Se termino todo el proceso!");

	}

}
