package Classes;
import java.util.*;

public class Company {
	private Queue<PaqueteAcciones> acciones;
	private int ganancias;

	
	public Company() {
		this.acciones = new PriorityQueue<PaqueteAcciones> ();
		this.ganancias = 0;
	}
	
	public void Comprar(int numAcciones, int precio) {
		PaqueteAcciones paquete = new PaqueteAcciones(numAcciones, precio);
		this.acciones.add(paquete);
		System.out.println("Compra exitosa: " + numAcciones + " acciones a " + precio + " €/accion.");
	}
	
	public void Vender(int numAcciones, int precio) {
		PaqueteAcciones paquete;
		int gananciasventa=0;
		int acc = numAcciones;
		 while (numAcciones != 0 && !this.acciones.isEmpty()) {
			 if (this.acciones.peek().getAcciones()<numAcciones) {
				 paquete = this.acciones.poll();
				 this.ganancias += (precio - paquete.getPrecio()) * paquete.getAcciones();
				 gananciasventa += (precio - paquete.getPrecio()) * paquete.getAcciones();
				 numAcciones = numAcciones-paquete.getAcciones();
			 } else {
				 paquete=this.acciones.peek();
				 this.ganancias += (precio-paquete.getPrecio()) * numAcciones;
				 gananciasventa += (precio - paquete.getPrecio()) * paquete.getAcciones();
				 paquete.setAcciones(paquete.getAcciones()-numAcciones);
				 numAcciones = numAcciones - numAcciones;
			 }
		 }
		 System.out.println("Venta exitosa: "+acc+" acciones vendidas, ganancias de la venta "+gananciasventa+"€.");
	}
}
