package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Conexion;
import db.Dbexception;
import model.dao.DepartamentoDao;
import model.entitis.Departamento;

public class DepartamentoDaoJDBC implements DepartamentoDao {
	private Connection conn;
	
	public DepartamentoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(Departamento dep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Departamento dep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Departamento findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Departamento> findAll() {
		PreparedStatement st = null;
		ResultSet         rs = null;
		
		try {
			st = conn.prepareStatement(
				"SELECT Id, Nombre FROM departamento "
			   +"ORDER BY Id");
			rs = st.executeQuery();
			List<Departamento> lista = new ArrayList<>();
			while(rs.next()){
				Departamento dep1 = instanDep(rs);
				lista.add(dep1);
			}
			return lista; 
		} 
		catch (SQLException e) {
			throw new Dbexception(e.getMessage());
		}
		finally {
			Conexion.cerrarRs(rs);
			Conexion.cerrarSt(st);
		}
	}//--Fin del Método findAll()--//
	
	//--Metodo Privado para Instanciar Departamento--//
	private Departamento instanDep(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(rs.getInt("Id"));
		dep.setNombre(rs.getString("Nombre"));		
		return dep;
	}

}
