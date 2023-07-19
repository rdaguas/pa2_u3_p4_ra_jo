package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository matriculaRepository;
	
	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public void agregarMatricula(String cedula, List<String> codMat) {
		Estudiante estudiante = this.estudianteRepository.seleccionarPorCedula(cedula);

		codMat.stream().forEach(a -> {
		Materia materia =  this.materiaRepository.seleccionarPorcodigo(a);
		Matricula matri = new Matricula();
		matri.setFecha(LocalDate.now());
		matri.setEstudiante(estudiante);
		matri.setMateria(materia);
		Random random = new Random();
		Integer rd = random.nextInt(101);

			matri.setNumero(rd.toString());
			this.matriculaRepository.insertar(matri);
		});

	}

	@Override
	public List<Matricula> buscarReporte() {
		// TODO Auto-generated method stub
		return this.matriculaRepository.seleccionarTodos();
	}

}
