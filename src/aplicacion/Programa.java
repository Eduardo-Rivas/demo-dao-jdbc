package aplicacion;

import java.util.List;
import java.util.Scanner;
import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entitis.Departamento;
import model.entitis.Vendedor;
  
public class Programa {

	public static void main(String[] args) {
		//--Instanciamos a Scanner para leer--// 
		Scanner sc = new Scanner(System.in);
		
		//--Hacemos la Inyección de Dependencia--//
		VendedorDao vendao = FabricaDao.crearVendedorDao();
		 
		//--Llamamos al Método findById() pasando parámetro Id=3--//
		Vendedor vendedor = vendao.findById(3);
		System.out.println("=== Inicio de Test Nro. 1 Clase: VendedorDaoJDBC Método: findById() ===");
		System.out.println(vendedor);
		System.out.println("=== Final de Test Nro. 1 Clase: VendedorDaoJDBC Método: findById() ===");

		//--Llamamos al Método findByDepartamento() pasando parámetro departamentoId=2--//
		Departamento dep = new Departamento(2, null);
		System.out.println("\n=== Inicio de Test Nro. 2 Clase: VendedorDaoJDBC Método: findByDepartamento() ===");
		//--Voy a vendao.findByDepartamento(dep) return lista--//
		List<Vendedor> lista = vendao.findByDepartamento(dep);
		//--Mostramos la Lista de Vendedores--//
		for(Vendedor xven : lista) {
			System.out.println(xven);
		}
		System.out.println("=== Final de Test Nro. 2 Clase: VendedorDaoJDBC Método: findByDepartamento ===");

		//--Llamamos al Método findAll()--//
		System.out.println("\n=== Inicio de Test Nro. 3 Clase: VendedorDaoJDBC Método: findAll() ===");
		//--Voy a vendao.findAll() return una lista--//
		lista = vendao.findAll();
		//--Mostramos la Lista de Vendedores--//
		for(Vendedor xven : lista) {
			System.out.println(xven);
		}
		System.out.println("=== Final de Test Nro. 3 Clase: VendedorDaoJDBC Método: findAll ===");

		/*--Comentariamos para no Insertar de Nuevo--//
		//--Llamamos al Método insert()--//
		System.out.println("\n=== Inicio de Test Nro. 4 Clase: VendedorDaoJDBC Método: insert() ===");
		Vendedor newVendedor = new Vendedor(null,"Larry","larry@gmail.com", new Date(), 4000.00, dep);
		vendao.insert(newVendedor);
		System.out.println("Nuevo Registro Incluido : "+newVendedor.getId());
		System.out.println("=== Final de Test Nro. 4 Clase: VendedorDaoJDBC Método: insert ===");
		*/
		
		/*--Comentariado para no Actualizar Nuevamente--//
		//--Llamamos al Método update()--//
		System.out.println("\n=== Inicio de Test Nro. 5 Clase: VendedorDaoJDBC Método: update() ===");
		//--Busca los Datos del Vendedor Nro. 1--//
		vendedor = vendao.findById(1);
		vendedor.setNombre("Anna Verde");
		vendedor.setEmail("anna@gmail.com");
		//--Lama al Método update()--//
		vendao.update(vendedor);
		System.out.println("Registro Actualizado : "+vendedor.getId());
		System.out.println("=== Final de Test Nro. 5 Clase: VendedorDaoJDBC Método: update() ===");
		*/
		
		//--Llamamos al Método delete()--//
		System.out.println("\n=== Inicio de Test Nro. 6 Clase: VendedorDaoJDBC Método: delete() ===");
		System.out.print("Entre Nro. de Registro a Elminar :");
		int id = sc.nextInt();
		//--Llamamos al Método deleteById() pasandole el id--//
		vendao.deleteById(id);
		System.out.println("Registro Nro. :"+id+" Eliminado");
		System.out.println("=== Final de Test Nro. 6 Clase: VendedorDaoJDBC Método: delete() ===");

		sc.close();
	}//--Fin del Método main()--//
}
