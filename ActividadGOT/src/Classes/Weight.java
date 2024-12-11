package Classes;

import graphsDSESIUCLM.Element;

/**
 * La Clase Weight. Representa una arista con un peso entero.
 *
 * @param <E> El tipo de elemento de los v�rtices que une la arista. Es requerido para generar el ID.
 */
public class Weight <E> implements Element {
	
	/** El peso. */
	private int weight;
	
	/** Los v�rtices que une la arista. */
	private DecoratedElement<E> source, destination;
	
	/** El id de la arista. */
	private String ID;
	
	/**
	 * Instancia un nuevo peso.
	 *
	 * @param source El primer v�rtice de uni�n de la arista
	 * @param destination El segundo v�rtice de uni�n de la arista
	 * @param weight El peso
	 */
	public Weight (DecoratedElement<E> source,DecoratedElement<E> destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.ID = this.toString();
	}
	
	/**
	 * Consulta el peso de la arista.
	 *
	 * @return el peso de la arista.
	 */
	public int getWeight () {
		return this.weight;
	}
	
	/**
	 * A string. Este m�todo se utiliza para generar el ID de esta clase.
	 * @return ID de la clase
	 */
	@Override
	public String toString () {
		return this.source.hashCode() + this.destination.hashCode()+"";
		
	}
	
	/**
	 * Consulta el id de la arista.
	 *
	 * @return el id de la arista
	 */
	@Override
	public String getID() {
		return this.ID;
	}
}
