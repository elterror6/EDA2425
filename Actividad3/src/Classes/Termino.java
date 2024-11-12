package Classes;

// TODO: Auto-generated Javadoc
/**
 * The Class Termino.
 */
public class Termino {
	
	/** The termino. */
	private String termino;
	
	/** The definicion. */
	private String definicion;

	/**
	 * Instantiates a new termino.
	 *
	 * @param termino the termino
	 * @param definicion the definicion
	 */
	public Termino(String termino,String definicion) {
		this.termino = termino;
		this.definicion = definicion;
	}
	
	/**
	 * Gets the termino.
	 *
	 * @return the termino
	 */
	public String getTermino() {
		return termino;
	}
	
	/**
	 * Gets the definicion.
	 *
	 * @return the definicion
	 */
	public String getDefinicion() {
		return definicion;
	}

}
