package Classes;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * La clase que representa una cartera de acciones.
 */
public class CarteraAcciones {
	
	/** Los paquetes de acciones. */
	private Queue<PaqueteAcciones> acciones;
	
	/** Las ganancias. */
	private int ganancias;

	
	/**
	 * Instancia una nueva cartera de acciones.
	 */
	public CarteraAcciones() {
		this.acciones = new LinkedBlockingQueue<PaqueteAcciones> ();
		this.ganancias = 0;
	}
	
	/**
	 * Comprar. Compra un numero de acciones por un precio por accion.
	 *
	 * @param numAcciones El numero de acciones que se desea comprar
	 * @param precio El precio por accion
	 */
	public void Comprar(int numAcciones, int precio) {
		PaqueteAcciones paquete = new PaqueteAcciones(numAcciones, precio);
		this.acciones.add(paquete);
		System.out.println("Compra exitosa: " + numAcciones + " acciones a " + precio + " €/accion.");
	}
	
	/**
	 * Vender. Vende un numero de acciones por un precio determinado.
	 *
	 * @param numAcciones El numero de acciones que se desea vender
	 * @param precio El precio por accion
	 */
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
	
	/**
	 * Consulta las ganancias.
	 *
	 * @return the ganancias
	 */
	public int getGanancias() {
		return this.ganancias;
	}
}
