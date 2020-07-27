package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.Dbexception;
import model.dao.VendedorDao;
import model.entitis.Departamento;
import model.entitis.Vendedor;

public class VendedorDaoJDBC implements VendedorDao{
	
	//-Creamos una dependencia para la Conexion--//
	private Connection conn;
	
	//--Costructor--//
	public VendedorDaoJDBC(Connection conn) {
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
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
				 "SELECT vendedor.*, departamento.Nombre AS Nomdep " 
				+"FROM vendedor INNER JOIN departamento " 
				+"ON vendedor.departamentoId = departamento.Id " 
				+"WHERE vendedor.Id = ?");
			
			st.setInt(1,id);
			rs = st.executeQuery();
			if(rs.next()) {
				//--Creamos  un  Obj.  Departamento--//
				//--Para  asignarle  los  Valores q--//
				//--vienen del Resultado del Select--//
				Departamento dep = new Departamento();
				dep.setId(rs.getInt("departamentoId"));
				dep.setNombre(rs.getString("Nomdep"));
				
				//--Instanciamos el Obj. Vendedor--//
				Vendedor ven = new Vendedor();
				ven.setId(rs.getInt("Id"));
				ven.setNombre(rs.getString("Nombre"));
				ven.setEmail(rs.getString("Email"));
				ven.setFecha(rs.getDate("Fecha"));
				ven.setSalarioBase(rs.getDouble("SalarioBase"));
				//--Asignamis la Asociacion de Entidad--//
				ven.setDepartamento(dep);
				return ven;
			}
		} 
		catch (SQLException e) {
			throw new Dbexception(e.getMessage());
		}
		finally {
			//--Cerramos los Recursos--//
			db.Conexion.cerrarSt(st);
			db.Conexion.cerrarRs(rs);
		}
		return null;
	} 

	@Override
	public List<Vendedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
