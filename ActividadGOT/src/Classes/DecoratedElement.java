package Classes;

import graphsDSESIUCLM.Element;

/**
 * La Clase DecoratedElement. Representa un elemento decorado.
 * @author Daniel Díaz García
 * @author Diego Repullo Higueruela
 *
 * @param <E> El tipo de elemento que se quiere decorar.
 */
public class DecoratedElement<E> implements Element {
	
	/** El id. */
	private String ID;
	
	/** El elemento. */
	private E element;
	
	/** Elemento visitado. */
	private boolean visited;
	
	/** El elemento padre. */
	private DecoratedElement<E> parent;
	
	/** La distancia. */
	private int distance;
	
	/**
	 * Instancia a nuevo elemento decorado.
	 *
	 * @param ID El ID del elemento
	 * @param element El elemento que se quiere decorar
	 */
	public DecoratedElement (String ID, E element) {
		this.element=element;
		this.ID = ID;
		this.visited = false;
		this.parent = null;
		this.distance = 0;
	}
	
	/**
	 * Consulta el elemento que se ha decorado.
	 *
	 * @return el elemento que se ha decorado.
	 */
	public E getElement() {
	    return element;
	}
	
	/**
	 * Consulta si el elemento de ha visitado.
	 *
	 * @return true si el elemento se ha visitado
	 */
	public boolean getVisited() {
	  return visited;
	}
	
	/**
	 * Cambia a visitado el elemento.
	 *
	 * @param t se visita el elemento
	 */
	public void setVisited(boolean t) {
	  visited = t;
	}
	
	/**
	 * Consulta el padre del elemento decorado.
	 *
	 * @return el padre del elemento decorado
	 */
	public DecoratedElement<E> getParent() {
	  return parent;
	}
	
	/**
	 * Cambia el padre del elemento decorado.
	 *
	 * @param u El nuevo padre del elemento decorado
	 */
	public void setParent(DecoratedElement<E> u) {
	  parent = u;
	}
	
	/**
	 * Consulta la distancia.
	 *
	 * @return la distancia
	 */
	public int getDistance() {
	  return distance;
	}
	
	/**
	 * Cambiar la distancia.
	 *
	 * @param d la nueva distancia
	 */
	public void setDistance(int d) {
	  distance = d;
	}
	
	/**
	 * Método que comprueba si un elemento dado es igual a este mismo elemento.
	 *
	 * @param n El elemento que se quiere comprobar
	 * @return true, si son iguales
	 */
	public boolean equals (Object n) {
		return (ID.equals(((DecoratedElement) n).getID()) && element.equals(((DecoratedElement<E>) n).getElement()));
	}
	
	/**
	 * Hash code.
	 *
	 * @return El entero del elemento
	 */
	public int hashCode () {
		return this.element.hashCode();
	}
	
	/**
	 * A string.
	 *
	 * @return La string del elemento
	 */
	@Override
	public String toString() {
		return element.toString();   
	}
	
	/**
	 * Consulta el id del elemento decorado.
	 *
	 * @return el id del elemento decorado
	 */
	@Override
	public String getID() {
		return this.ID;
	}

}
