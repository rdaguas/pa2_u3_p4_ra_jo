package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {

	
	private static final Logger LOG = LoggerFactory.getLogger(MetodosHighOrder.class);

	//es una implementacion
	public void metodo(IPersonaSupplier<String> funcion) {
		//funcion.getId();
		LOG.info("High Order Supplier " + funcion.getId());
		
	}
	public static  void metodoConsumer(IPersonaConsumer<String> funcion2, String cadena) {
		funcion2.accept(cadena);
		
	}
}
