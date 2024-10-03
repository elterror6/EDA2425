package pila;
/**
 * <h1>DinamicStack</h1>
 * <p>
 * Clase que implementa la interfaz Stack para una pila dinámica con una estructura de nodos.
 * </p>
 * @author Daniel Díaz García
 */
public class DinamicStack<E> implements Stack<E> {
	private int size;
	private Node<E> top;
	/**
     * <h2>DinamicStack()</h2>
     * <p>
     * Método constructor que crea una nueva pila vacía.
     * </p>
     */
	public DinamicStack() {
	        top = null;
	        size = 0;
	}
    /**
     * <h2>push()</h2>
     * <p>
     * Método que inserta un nuevo elemento en la pila. Se crea un nuevo nodo con el elemento y lo añade al principio de la pila.
     * </p>
     * @param element Elemento a insertar en la pila
     */
    @Override
    public void push(E element) {
        Node<E> aux = new Node<E>(element);
        aux.setNext(top);
        top = aux;
        ++size;
    }
    /**
     * <h2>pop()</h2>
     * <p>
     * Método que elimina y devuelve el elemento que está en la cima de la pila. Se comprueba si la pila está vacía, si lo está, se lanza una excepción de tipo EmptyStackException.
     * </p>
     * @return Elemento que se ha eliminado de la pila
     */
    public E pop() throws EmptyStackException {
        E element;
        if (isEmpty()) {
            throw new EmptyStackException("La pila está vacía");
        } else {
            element = top.getElement();
            top = top.getNext();
            --size;
        }
        return element;
    }
    /**
     * <h2>top()</h2>
     * <p>
     * Método que devuelve el elemento que está en la cima de la pila. Se comprueba si la pila está vacía, si lo está, se lanza una excepción de tipo EmptyStackException.
     * </p>
     * @return Elemento que esta en la cima de la pila
     */
    public E top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("La pila está vacía");
        } else {
            return top.getElement();
        }
    }
	/**
    * <h2>size()</h2>
    * <p>
    * Método que devuelve el número de elementos que existe en la pila.
    * </p>
    * @return tamaño de la pila
    */
   @Override
	public int size() {
        return size;
    }
    /**
	* <h2>isEmpty()</h2>
    * <p>
    * Método que comprueba si la pila está vacía. Se comprueba si el top es null.
    * </p>
    * @return true si la pila está vacía, false en caso contrario.
    */
   @Override
	public boolean isEmpty() {
		return top == null ;
	}
}