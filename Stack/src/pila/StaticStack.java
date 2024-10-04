package pila;
/**
 * <h1>StaticStack</h1>
 * <p>
 * Clase que implementa la interfaz Stack para una pila estática.
 * </p>
 * @author Daniel Díaz García
 */
public class StaticStack<E> implements Stack<E> {
	private E[] stack;
	private int t;
	/**
	 * <h2>Constructor</h2>
	 * <p>
	 * Método constructor que crea una nueva pila vacía.
	 * </p>
	 */
	public StaticStack() {
		this.stack = (E[]) new Object[1];
		this.t = -1;
	}
	/**
	 * <h2>push()</h2>
	 * <p>
	 * Método que inserta un nuevo elemento en la pila. Se comprueba si la pila está llena, si lo está, se ajusta el tamaño del array y se inserta el nuevo elemento.
	 * </p>
	 * @param element Elemento a insertar en la pila
	 */
	@Override
	public void push(E element) {
		if (this.t == this.stack.length - 1) {
			E[] ns = (E[]) new Object[this.stack.length*2];
			for (int i = 0; i<this.stack.length; i++) {
				ns[i]=this.stack[i];
			}
			this.stack=ns;
			++this.t;
			this.stack[t]=element;
		} else {
			this.stack[this.stack.length] = element;
		}
	}
	/**
	 * <h2>pop()</h2>
	 * <p>
	 * Método que elimina y devuelve el elemento que está en la cima de la pila. Se comprueba si la pila está vacía lanza una excepción de tipo EmptyStackException.
	 * </p>
	 * @return elemento que se ha eliminado de la pila
	 */
	@Override
	public E pop() throws EmptyStackException {
		E element;
		if (isEmpty()) {
			throw new EmptyStackException("La pila está vacía.");
		} else {
			element = this.stack[this.t];
			--this.t;
			return element;
		}
	}
	/**
	 * <h2>top()</h2>
	 * <p>
	 * Método que devuelve el elemento que está en la cima de la pila. Se comprueba si la pila está vacía lanza una excepción de tipo EmptyStackException.
	 * </p>
	 * @return elemento que esta en la cima de la pila
	 */
	@Override
	public E top() throws EmptyStackException{
		E element;
		if (isEmpty()) {
			throw new EmptyStackException("La pila está vacía.");
        } else {
			element = this.stack[this.t];
			return element;
		}
	}
	/**
	 * <h2>isEmpty()</h2>
	 * <p>
	 * Método que comprueba si la pila está vacía.
	 * </p>
	 * @return true si la pila está vacía, false en caso contrario.
	 */
	@Override
	public boolean isEmpty() {
        return this.t < 0;
	}
	/**
	 * <h2>size()</h2>
	 * <p>
	 * Método que devuelve el número de elementos que existen en la pila.
	 * </p>
	 * @return tamaño de la pila
	 */
	@Override
	public int size() {
	    return this.t + 1;
	}
}