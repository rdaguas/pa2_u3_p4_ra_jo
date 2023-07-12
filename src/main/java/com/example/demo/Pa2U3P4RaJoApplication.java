package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		
		
		List<Hotel>listaHotel;
		
		System.out.println("--------------------------------- INNER OUTER JOIN ---------------------------------"); 
		this.hotelService.buscarInnerJoin().stream().forEach(System.out::println);
		 
		 System.out.println("--------------------------------- RIGHT OUTER JOIN ---------------------------------");
		 this.hotelService.buscarOuterRightJoin().stream().forEach(System.out::println);
		
		 System.out.println("--------------------------------- LEFT OUTER JOIN ---------------------------------");
		 this.hotelService.buscarOuterLeftJoin().stream().forEach(System.out::println);
		 
		 System.out.println("---------------------------------LEFT OUTER JOIN HABITACIONES ---------------------------------");
		 this.hotelService.buscarHabitacionOuterLeftJoin().stream().forEach(System.out::println);
		
		 System.out.println("--------------------------------- FULL OUTER JOIN ---------------------------------");
		 this.hotelService.buscarOuterFullJoin().stream().forEach(System.out::println);
		
		 System.out.println("--------------------------------- WHERE JOIN ---------------------------------");
		 this.hotelService.buscarWhereJoin().stream().forEach(System.out::println);
			
		
		
		
	}

}
