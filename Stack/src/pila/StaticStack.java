package pila;

public class StaticStack<E> implements Stack<E> {
	private int topIndex;
	 @Override
	    public boolean isEmpty() {
	        return topIndex == -1;
	    }
	 @Override
	    public int size() {
	        return topIndex + 1;
	    }
}