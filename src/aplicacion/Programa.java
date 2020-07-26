package aplicacion;

import java.util.Date;

import model.entitis.Departamento;
import model.entitis.Vendedor;

public class Programa {

	public static void main(String[] args) {
		Departamento obj = new Departamento(1, "Libros");
		Vendedor vendedor = new Vendedor(17,"Eduardo","eduardo@gmail.com", new Date(), 3000.0, obj);
		
		System.out.println(vendedor);
	}

}
