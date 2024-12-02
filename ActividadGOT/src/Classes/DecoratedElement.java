package Classes;

import graphsDSESIUCLM.Element;

public class DecoratedElement<E> implements Element {
	private String ID;
	private E element;
	private boolean visited;
	private DecoratedElement<E> parent;
	private int distance;
	
	public DecoratedElement (String ID, E element) {
		this.element=element;
		this.ID = ID;
		this.visited = false;
		this.parent = null;
		this.distance = 0;
	}
	
	public E getElement() {
	    return element;
	}
	public boolean getVisited() {
	  return visited;
	}
	public void setVisited(boolean t) {
	  visited = t;
	}
	public DecoratedElement<E> getParent() {
	  return parent;
	}
	public void setParent(DecoratedElement<E> u) {
	  parent = u;
	}
	public int getDistance() {
	  return distance;
	}
	public void setDistance(int d) {
	  distance = d;
	}
	public boolean equals (Object n) {
		return (ID.equals(((DecoratedElement) n).getID()) && element.equals(((DecoratedElement<E>) n).getElement()));
	}
	public int hashCode () {
		return this.element.hashCode();
	}
	@Override
	public String toString() {
		return element.toString();   
	}
	@Override
	public String getID() {
		return this.ID;
	}

}
