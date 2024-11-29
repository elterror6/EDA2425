package Classes;

import graphsDSESIUCLM.Element;

public class Weight implements Element {
	private int weight;
	private String source, destination, ID;
	public Weight (String source,String destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.ID = this.toString();
	}
	
	public int getWeight () {
		return this.weight;
	}

	public int toString (String source, String destination) {
		return source.hashCode() + destination.hashCode();
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
