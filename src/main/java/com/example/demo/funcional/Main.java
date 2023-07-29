package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) {
		
		IPersona per = new PersonaImpl();
		per.caminar();
		
		//1. SUPPLIER
		
		//CLASES:
		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("SUPPLIER Clase: " + supplier1.getId());
		//LOG.error("SUPPLIER Clase: " + supplier1.getId());
		
		//Lambdas
		IPersonaSupplier<String> supplier2 = ()->  "1724340391";
		LOG.info("SUPPLIER LAMBDA: " + supplier2.getId());
		
		//Lambdas
				IPersonaSupplier<String> supplier3 = ()->  {
					String cedula = "1724340391";
					cedula = cedula+"zzzz";
					return cedula;
				};
				LOG.info("SUPPLIER LAMBDA 2: " + supplier3.getId());
		
	}

}
