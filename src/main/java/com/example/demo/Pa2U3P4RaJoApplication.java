package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.Provincia;
import com.example.demo.repository.modelo.Semestre;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.IMatriculaService;



@SpringBootApplication
public class Pa2U3P4RaJoApplication implements CommandLineRunner {

	
	@Autowired
	private IMateriaService materiaService;
	
	@Autowired
	private IMatriculaService matriculaService;
	
	@Autowired
	private IEstudianteService estudianteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4RaJoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Provincia prov = new Provincia();
		prov.setCanton("Quito");
		prov.setNombre("Pichincha");
		
		
		Estudiante estu = new Estudiante();
		estu.setNombre("Jimmy");
		estu.setApellido("Aguas");
		estu.setCedula("010");
		estu.setProvincia(prov);
		
		//this.estudianteService.agregar(estu);
		
		Semestre smtr = new Semestre();
		smtr.setHorario("Matutino");
		smtr.setNumero("Semestre 1");
		smtr.setParalelo("B");
		
		Semestre smtr2 = new Semestre();
		smtr2.setHorario("Matutino");
		smtr2.setNumero("Semestre 2");
		smtr2.setParalelo("C");
		
		
		List<Materia>materias= new ArrayList<>();
		Materia mate = new Materia();
		mate.setCodigo("123ab");
		mate.setNombre("PA2");
		mate.setPrecio(new BigDecimal(30));
		mate.setSemestre(smtr);
		//this.materiaService.insertar(mate);
		Materia mate2 = new Materia();
		mate2.setCodigo("456xyz");
		mate2.setNombre("IA");
		mate2.setPrecio(new BigDecimal(20));
		mate2.setSemestre(smtr2);
		
		materias.add(mate);
		materias.add(mate2);
//		
//		this.materiaService.insertar(mate);
//		this.materiaService.insertar(mate2);
		
		Matricula mtra = new Matricula();
		mtra.setFecha(LocalDate.now());
		mtra.setNumero("11");
		//mtra.setEstudiante(estu);
		//mtra.setMateria(mate);
		//mtra.setMateria(mate2);
		
		
		//this.matriculaService.agregarMatricula(mtra);
		
		List<String>codMatriculas= new ArrayList<>();
		String codM1="123ab";
		String codM2="456xyz";
		codMatriculas.add(codM1);
		codMatriculas.add(codM2);
		
		
		System.out.println(this.estudianteService.buscarPorCedula("010"));
		
		this.matriculaService.agregarMatricula("010", codMatriculas);
		
		this.materiaService.buscarPorCodigo().stream().forEach(System.out::println);
		
		
		
		
		
		
		
		
		
	

}
}
