package Classes;

public class PaqueteAcciones {
	private int acciones;
	private int precio;
	
	public PaqueteAcciones (int acciones, int precio) {
		this.acciones=acciones;
		this.precio=precio;
	}
	
	public int getAcciones() {
		return this.acciones;
	}
	public int getPrecio() {
		return this.precio;
	}
	
	public void setAcciones(int acciones) {
		this.acciones=acciones;
	}
}
