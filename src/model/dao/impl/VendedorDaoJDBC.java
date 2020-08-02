package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public List<Vendedor> findByDepartamento(Departamento departamento) {
		PreparedStatement st = null;
		ResultSet         rs = null;
		
		try {
			st = conn.prepareStatement(
				"SELECT vendedor.*, departamento.Nombre AS Nomdep " 
			   +"FROM vendedor INNER JOIN departamento " 
			   +"ON vendedor.departamentoId = departamento.Id "
			   +"WHERE departamentoId = ? "
			   +"ORDER BY vendedor.Nombre");
			st.setInt(1, departamento.getId());
			rs = st.executeQuery();
			
			//--Instanciamos una Lista para Vendedores--//
			List<Vendedor> lista = new ArrayList<>();
			//--Instanciamos un Map para Instac. una sola Vez el Dep--//
			Map<Integer, Departamento> map = new HashMap<>();
			while(rs.next()){
				//--Asignamos el Id del Dpto. que está en el map--//
				Departamento dep1 = map.get(rs.getInt("departamentoId"));
				//--Id NO Está en el map Llamamos al Método--// 
				if(dep1 == null) {
					//--Método para Instanciar de Departamentos--//
					dep1 = instandep(rs);
					//--Guardamos en el Map--//
					map.put(rs.getInt("departamentoId"), dep1);
				}
				//--Método para Instanciar Vendedores--//
			    Vendedor ven = instanven(rs, dep1);
			    //--Guardamos en la Lista los Vendedores--//
			    lista.add(ven);
			}
			return lista;
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
