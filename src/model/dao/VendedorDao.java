package model.dao;

import java.util.List;
import model.entitis.Vendedor;

public interface VendedorDao {
	//--Metodos a Implementar--//
	void insert(Vendedor ven);
	void update(Vendedor ven);
	void deleteById(Integer id);
	Vendedor findById(Integer id);
	List<Vendedor> findAll();
}
