
package Classes;

/**
 * La Clase que representa un paquete de acciones.
 */
public class PaqueteAcciones {
	
	/** El numero de acciones. */
	private int acciones;
	
	/** El precio de la accion. */
	private int precio;
	
	/**
	 * Instancia un nuevo paquete de acciones.
	 *
	 * @param acciones El numero de acciones
	 * @param precio El precio de la accion
	 */
	public PaqueteAcciones (int acciones, int precio) {
		this.acciones=acciones;
		this.precio=precio;
	}
	
	/**
	 * Consulta el numero de acciones.
	 *
	 * @return El numero de acciones
	 */
	public int getAcciones() {
		return this.acciones;
	}
	
	/**
	 * Consulta el precio de la accion.
	 *
	 * @return El precio de la accion
	 */
	public int getPrecio() {
		return this.precio;
	}
	
	/**
	 * Modifica el numero de acciones.
	 *
	 * @param acciones El nuevo numero de acciones
	 */
	public void setAcciones(int acciones) {
		this.acciones=acciones;
	}
}
