package aplicacion;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entitis.Vendedor;

public class Programa {

	public static void main(String[] args) {
		 
		//--Hacemos la Inyección de Dependencia--//
		VendedorDao vendao = FabricaDao.crearVendedorDao();
		 
		//--Llamamos al Método findById() pasando parámetro Id=3--//
		Vendedor vendedor = vendao.findById(3);
		System.out.println("=== Inicio de Test Nro. 1 Clase: VendedorDaoJDBC Método: findById() ===");
		System.out.println(vendedor);
		System.out.println("=== Final de Test Nro. 1 Clase: VendedorDaoJDBC Método: findById() ===");

	}

}
