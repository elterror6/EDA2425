package Classes;

import graphsDSESIUCLM.Element;

public class Weight <E> implements Element {
	private int weight;
	private DecoratedElement<E> source, destination;
	private String ID;
	public Weight (DecoratedElement<E> source,DecoratedElement<E> destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.ID = this.toString();
	}
	
	public int getWeight () {
		return this.weight;
	}
	public String toString (String source, String destination) {
		return source.hashCode() + destination.hashCode()+"";
	}
	@Override
	public String toString () {
		return this.source.hashCode() + this.destination.hashCode()+"";
		
	}
	@Override
	public String getID() {
		return this.ID;
	}
}
