package Classes;
import java.util.*;

public class Company {
	private Queue<PaqueteAcciones> acciones;
	private int ganancias;
	private static int gananciastotales;
	
	public Company() {}
	
	public void Comprar(int acciones, int precio) {
		PaqueteAcciones paquete = new PaqueteAcciones(acciones, precio);
		acciones.add(paquete);
		System.out.println("Compra exitosa: " + acciones + " acciones a " + precio + " €/acción.");
	}
	
	public void Vender(int acciones, int precio) {
		
	}
}
