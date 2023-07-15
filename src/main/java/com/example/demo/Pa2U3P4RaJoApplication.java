package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.service.IHotelService;

@SpringBootApplication
public class Pa2U3P4RaJoApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4RaJoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		List<Hotel>listaHotel= this.hotelService.buscarInnerJoin();
		
		for(Hotel h : listaHotel) {
			System.out.println(h.getNombre());
			System.out.println("Tiene las siguientes habitaciones: ");
			for(Habitacion ha : h.getHabitaciones()) {
				System.out.println(ha.getNumero());
			}
		}
		
		List<Hotel>listaHotelF= this.hotelService.buscarFetchJoin();
		System.out.println("SQL JOIN FETCH");
		for(Hotel h : listaHotelF) {
			System.out.println(h.getNombre());
			System.out.println("FETCH Tiene las siguientes habitaciones: ");
			for(Habitacion ha : h.getHabitaciones()) {
				System.out.println(ha.getNumero());
			}
		}
		
		
		Hotel hotel = new Hotel();
		hotel.setNombre("Flanders");
		hotel.setDireccion("LLano Grande");
		
		Habitacion ha = new Habitacion();
		ha.setNumero("HA100");
		ha.setValor(new BigDecimal(100));
		ha.setHotel(hotel);
		ha.setValorIncluidoIva(new BigDecimal(20));
		
		
		List<Habitacion> listaHabitaciones = new ArrayList<>();			
		listaHabitaciones.add(ha);		
		hotel.setHabitaciones(listaHabitaciones);		
		this.hotelService.guardar(hotel); 
		
		
//		System.out.println("--------------------------------- INNER OUTER JOIN ---------------------------------"); 
//		this.hotelService.buscarInnerJoin().stream().forEach(System.out::println);
//		 
//		 System.out.println("--------------------------------- RIGHT OUTER JOIN ---------------------------------");
//		 this.hotelService.buscarOuterRightJoin().stream().forEach(System.out::println);
//		
//		 System.out.println("--------------------------------- LEFT OUTER JOIN ---------------------------------");
//		 this.hotelService.buscarOuterLeftJoin().stream().forEach(System.out::println);
//		 
//		 System.out.println("---------------------------------LEFT OUTER JOIN HABITACIONES ---------------------------------");
//		 this.hotelService.buscarHabitacionOuterLeftJoin().stream().forEach(System.out::println);
//		
//		 System.out.println("--------------------------------- FULL OUTER JOIN ---------------------------------");
//		 this.hotelService.buscarOuterFullJoin().stream().forEach(System.out::println);
//		
//		 System.out.println("--------------------------------- WHERE JOIN ---------------------------------");
//		 this.hotelService.buscarWhereJoin().stream().forEach(System.out::println);
//			
		
		
		
	}

}
