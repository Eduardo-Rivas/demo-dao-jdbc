package model.dao;

import model.dao.impl.VendedorDaoJDBC;

public class FabricaDao {
	
	//--Método Statico Para Instancia el Vendedor--//
	public static VendedorDao  crearVendedorDao() {
		//--Instanciamos la Implementacion VendedorDaoJDBC()--//
		//--la  cual  implementa  la  Interface VendedorDao --//
		return new VendedorDaoJDBC();
	}
}
