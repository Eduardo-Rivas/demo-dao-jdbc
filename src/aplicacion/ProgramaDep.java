package aplicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DepartamentoDao;
import model.dao.FabricaDao;
import model.entitis.Departamento;

public class ProgramaDep {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//--Cramos Inceccion de Dependencia--//
		DepartamentoDao depDao = FabricaDao.crearDepartamentoDao(); 
		List<Departamento> lista = new ArrayList<>();
		
		//--Llamamamos al Método findAll()--//
		lista = depDao.findAll();
		
		//--Mostramos la Lista de Departamentos--//
		System.out.println("\n=== Inicio de Test Nro. 1 Clase: DepartamentoDaoJDBC Método: findAll() ===");
		for(Departamento xdep : lista){
			System.out.println(xdep);
		}
		System.out.println("=== Final de Test Nro. 1 Clase: DepartamentoDaoJDBC Método: findAll() ===");
		
		sc.close();
	}

}
