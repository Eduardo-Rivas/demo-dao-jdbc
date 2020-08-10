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

		//--Mostramos un Departamentos por Id--//
		System.out.println("\n=== Inicio de Test Nro. 2 Clase: DepartamentoDaoJDBC Método: findById() ===");
		Departamento dep1 = depDao.findById(3);
		System.out.println(dep1);
		System.out.println("=== Final de Test Nro. 2 Clase: DepartamentoDaoJDBC Método: findById() ===");

		//--Incluimos un Departamentos--//
		System.out.println("\n=== Inicio de Test Nro. 3 Clase: DepartamentoDaoJDBC Método: insert() ===");
		Departamento newdep = new Departamento(null, "Animales");
		depDao.insert(newdep);
		System.out.println("Nuevo Registro Incluido Con Id Nro. : "+newdep.getId());
		System.out.println(newdep);
		System.out.println("=== Final de Test Nro. 3 Clase: DepartamentoDaoJDBC Método: insert() ===");
		
		//--Llamamos al Método deleteById()--//
		System.out.println("\n=== Inicio de Test Nro. 4 Clase: DepartamentoDaoJDBC Método: deleteById() ===");
		System.out.print("Entre Nro. de Registro a Elminar :");
		int id = sc.nextInt();
		//--Llamamos al Método deleteById() pasandole el id--//
		depDao.deleteById(id);
		System.out.println("Registro Nro. :"+id+" Eliminado");
		System.out.println("=== Final de Test Nro. 4 Clase: DepartamentoDaoJDBC Método: deleteById() ===");

		//--Llamamos al Método update()--//
		System.out.println("\n=== Inicio de Test Nro. 5 Clase: DepartamentoDaoJDBC Método: update() ===");
		//--Busca los Datos del Vendedor Nro. 1--//
		dep1 = depDao.findById(1);
		dep1.setNombre("Computación");
		//--Lama al Método update()--//
		depDao.update(dep1);
		System.out.println("Registro Actualizado : "+dep1.getId());
		System.out.println("=== Final de Test Nro. 5 Clase: DepartamentoDaoJDBC Método: update() ===");

		
		sc.close();
	}

}
