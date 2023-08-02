package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		IPersona per = new PersonaImpl();
		per.caminar();

		// 1. SUPPLIER

		// CLASES:
		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("SUPPLIER Clase: " + supplier1.getId());
		// LOG.error("SUPPLIER Clase: " + supplier1.getId());

		// Lambdas
		IPersonaSupplier<String> supplier2 = () -> "1724340391";
		LOG.info("SUPPLIER LAMBDA: " + supplier2.getId());

		// Lambdas
		IPersonaSupplier<String> supplier3 = () -> {
			String cedula = "1724340391";
			cedula = cedula + "zzzz";
			return cedula;
		};
		LOG.info("SUPPLIER LAMBDA 2: " + supplier3.getId());

		// METODOS REFERENCIADOS

		MetodosReferenciados metodos = new MetodosReferenciados();
		IPersonaSupplier<Integer> supplier4 = metodos::getId;
		LOG.info("**********************METODOS REFERENCIADOS*************************");

		LOG.info("SUPPLIER METODO REFERENCIADO: " + supplier4.getId());

		// 2. CONSUMMER

		// CLASES:
		IPersonaConsumer<String> consumer1 = new PersonaConsumerImpl();
		LOG.info("Consumer Clase: ");
		consumer1.accept("Jimmy Ortega");

		IPersonaConsumer<String> consumer2 = cadena -> {
			LOG.info("Consumer lambda");
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		};
		consumer2.accept("Jimmy Ortega 2");

		// METODO REFERENCIADO

		IPersonaConsumer<String> consumer3 = metodos::aceptar;
		LOG.info("Consumer Metodos Referenciados");
		consumer3.accept("A");

		// 3. PREDICATE
		// LAMBDAS
		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(8) == 0;
		LOG.info("Predicate Lambda: " + predicate1.evaluar(8));

		IPersonaPredicate<Integer> predicate2 = valor -> {
			Integer valor2 = 10;
			valor = valor + valor2;
			if (valor.compareTo(100) > 0) {
				return true;

			} else {
				return false;
			}

		};
		LOG.info("Predicate Lambda 2: " + predicate2.evaluar(55));

		IPersonaPredicate<String> predicate3 = letra -> "Jimmy".contains(letra);
		LOG.info("Predicate Lambda 3: " + predicate3.evaluar("i"));

		IPersonaBIPredicate<String, String> predicate4 = (letra, cadena) -> cadena.contains(letra);
		LOG.info("Predicate Lambda 4: " + predicate4.evaluar("F", "Felix"));

		// METODO REFERENCIADO

		IPersonaPredicate<Integer> predicate5 = metodos::evaluar;
		LOG.info("Predicate Metodo Referenciado5: " + predicate5.evaluar(8));

		// 4. FUNCTION
		// funciones de casteo
		// elprimer argunmento de mi interfaz es de retorno
		IPersonaFunction<String, Integer> function = numero -> numero.toString();
		LOG.info("Function lambda: " + function.aplicar(8));

		IPersonaFunction<String, Integer> function1 = numero -> {
			String valorFinal = numero.toString().concat("valor");
			return valorFinal;
		};
		LOG.info("Function lambda1: " + function1.aplicar(10));

		// 5. UNARY OPERATOR

		IPersonaUnaryOperator<Integer> unary = numero -> numero + (numero * 2);
		LOG.info("Unary lambda: " + unary.aplicar(3));

		IPersonaUnaryOperatorFunction<Integer> unary2 = numero -> numero + (numero * 2);
		LOG.info("Unary lambda2" + ": " + unary2.aplicar(3));

		// **************** METODOS HIGH ORDER *******************

		MetodosHighOrder highOrder = new MetodosHighOrder();
		// 1. Clase
		IPersonaSupplier<String> supplierHO = new PersonaSupplierImpl();
		highOrder.metodo(supplierHO);

		// 2. Lambdas
		highOrder.metodo(() -> "1724340391HO");

		// 3. Metodos Referenciados
		highOrder.metodo(metodos::getIdHO);

		// Consumer
		// Clase
		MetodosHighOrder.metodoConsumer(new PersonaConsumerImpl(), "Clase Consumer");

		// Lambdas
		MetodosHighOrder.metodoConsumer(cadena -> LOG.info(cadena), "lambdas Consumer");

		MetodosHighOrder.metodoConsumer(metodos::aceptar, "Metodos Referenciados Consumer");

		// Interfaces Funcionales JAVA
		// 1. SUPPLER

		// Supplier
		Stream<String> lista = Stream.generate(() -> "1724340391HO").limit(20);
		lista.forEach(cadena -> LOG.info(cadena));

		// 2. CONSUMER

		List<Integer> listaNumeros = Arrays.asList(1, 2, 2, 3, 4, 5, 6, 7, 8,9,10,11,12,13,14,15);
		listaNumeros.forEach(cadena -> {

			LOG.info("" + cadena);
		});
		
		//3. PREDICATE
		Stream<Integer> listaFinal	=listaNumeros.stream().filter(numero -> numero >= 5);
		listaFinal.forEach(numero -> LOG.info("Valor: " + numero));
		
		//4. FUNCTION
		Stream<String> listaCambiada =listaNumeros.stream().map(numero -> {
			Integer num = 10;
			num = numero * num;
			return "N:"  + num;
					});
		listaCambiada.forEach(cadena -> LOG.info(cadena));
		
		//5. UNARYOPERATOR
		
		Stream<Integer> listaCambiada2 =listaNumeros.stream().map(numero -> {
			Integer num = 10;
			num = numero  + num;
			return num;
					});
		listaCambiada2.forEach(cadena -> LOG.info(cadena.toString()));
		
		
		
		
	}

}
