package Classes;

/**
 * La clase que representa un Termino de un Diccionario.
 */
public class Termino {
	
	/** El termino. */
	private String termino;
	
	/** La definicion. */
	private String definicion;

	/**
	 * Instancia un nuevo termino.
	 *
	 * @param termino El termino que se quiere definir.
	 * @param definicion La definicion del termino.
	 */
	public Termino(String termino,String definicion) {
		this.termino = termino;
		this.definicion = definicion;
	}
	
	/**
	 * Consulta el termino.
	 *
	 * @return the termino
	 */
	public String getTermino() {
		return termino;
	}
	
	/**
	 * Consultar la definicion.
	 *
	 * @return the definicion
	 */
	public String getDefinicion() {
		return definicion;
	}

}
