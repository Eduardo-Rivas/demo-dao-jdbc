package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.Conexion;
import db.Dbexception;
import model.dao.VendedorDao;
import model.entitis.Departamento;
import model.entitis.Vendedor;

public class VendedorDaoJDBC implements VendedorDao{
	private Connection conn;
	  
	//--Constructor--//
	public VendedorDaoJDBC(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public void insert(Vendedor ven) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vendedor ven) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor findById(Integer id) {
		PreparedStatement st = null;
		ResultSet         rs = null;
		
		try {
			st = conn.prepareStatement(
				"SELECT vendedor.*, departamento.Nombre AS Nomdep " 
			   +"FROM vendedor INNER JOIN departamento " 
			   +"ON vendedor.departamentoId = departamento.Id "
			   +"WHERE vendedor.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()){
				//--Instanciamos un Departamento y lo Asignamos--//
				Departamento dep = instandep(rs);
				  
				//--Instanciamos Vendedor y Asignamos--//
			    Vendedor ven = instanven(rs, dep);
			    return ven;
			}
			else {
				return null;
			}
				
		} catch (SQLException e) {
			throw new Dbexception(e.getMessage());
		}
		finally {
			Conexion.cerrarRs(rs);
			Conexion.cerrarSt(st);
		}
	}  

	//--Método Interno para Instanciar Vendedor--//
	private Vendedor instanven(ResultSet rs, Departamento dep) throws SQLException {
		Vendedor obj = new Vendedor();
		obj.setId(rs.getInt("Id"));
		obj.setNombre(rs.getString("Nombre"));
		obj.setEmail(rs.getString("Email"));
		obj.setFecha(rs.getDate("Fecha"));
		obj.setSalarioBase(rs.getDouble("salarioBase"));
		obj.setDepartamento(dep);
		return obj;
	}

	//--Método Interno para Instanciar Departamento--//
	private Departamento instandep(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(rs.getInt("DepartamentoId"));
		dep.setNombre(rs.getString("Nomdep"));
		return dep;
	}

	@Override
	public List<Vendedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
