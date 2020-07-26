package model.dao;

import java.util.List;

import model.entitis.Departamento;

public interface DepartamentoDao {
	//--Metodos a Implementar--//
	void insert(Departamento dep);
	void update(Departamento dep);
	void deleteById(Integer id);
	Departamento findById(Integer id);
	List<Departamento> findAll();
}
