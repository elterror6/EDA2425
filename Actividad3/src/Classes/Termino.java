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
	 * Instancia un nuevo termino. Este constructor se va a utilizar para ver si un termino es igual a otro.
	 *
	 * @param termino El termino
	 */
	public Termino(String termino) {
		this.termino=termino;
	}
	/**
	 * Consulta el termino.
	 *
	 * @return El termino
	 */
	public String getTermino() {
		return termino;
	}
	
	/**
	 * Consultar la definicion.
	 *
	 * @return La definicion
	 */
	public String getDefinicion() {
		return definicion;
	}
	
	/**
	 * Devuelve si el objeto dado es igual o no. Para ello se compara el termino.
	 *
	 * @param o El objeto dado
	 * @return true, Si son iguales
	 */
	@Override
	public boolean equals (Object o) {
		boolean r = false;
		
		if (this == o) {
			r = true;
		} else if (!(o instanceof Termino)) {
			r = false;
		} else {
			Termino t = (Termino) o;
			r = this.termino.equals(t.getTermino());
		}
		return r;
	}
}
