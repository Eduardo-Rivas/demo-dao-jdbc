package aplicacion;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entitis.Vendedor;

public class Programa {

	public static void main(String[] args) {
		 
		//--Probamos la Inyección de Dependencia--//
		VendedorDao vendao = FabricaDao.crearVendedorDao();
		
		Vendedor vendedor = vendao.findById(3);
		
		System.out.println(vendedor);
	}

}
