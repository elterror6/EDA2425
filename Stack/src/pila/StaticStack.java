package pila;

public class StaticStack<E> implements Stack<E> {
	private E[] stack;

	public StaticStack() {
		this.stack = (E[]) new Object[1];
	}
	@Override
	public void push(E element) {

	}
	@Override
	public E pop() {
		E e;
		return e;
	}
	@Override
	public E top() {
		E e;
		return e;
	}
	@Override
	public boolean isEmpty() {
        return topIndex == -1;
	}
	@Override
	public int size() {
	    return topIndex + 1;
	}
}