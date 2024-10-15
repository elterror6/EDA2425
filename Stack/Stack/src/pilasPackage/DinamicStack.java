package pilasPackage;

/**
 * <p>
 * Clase que implementa la interfaz Stack para una pila dinamica con una estructura de nodos.
 * </p>
 *
 * @author Daniel Diaz Garcia
 * @author Diego Repullo Higueruela
 * @param <E> El tipo de elemento
 */
public class DinamicStack<E> implements Stack<E> {
	
	/** El tamaño de la pila. */
	private int size;
	
	/** El elemento top. */
	private Node<E> top;
	/**
     * <p>
     * Metodo constructor que crea una nueva pila vacia.
     * </p>
     */
	public DinamicStack() {
	        top = null;
	        size = 0;
	}
    /**
     * <p>
     * Metodo que inserta un nuevo elemento en la pila.<br>Se crea un nuevo nodo con el elemento y lo añade al principio de la pila.
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
     * <p>
     * Metodo que elimina y devuelve el elemento que esta en la cima de la pila.<br>Se comprueba si la pila esta vacia, si lo esta, se lanza una excepcion de tipo EmptyStackException.
     * </p>
     *
     * @return Elemento que se ha eliminado de la pila
     * @throws EmptyStackException La excepcion de pila vacia
     */
    @Override
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
     * <p>
     * Metodo que devuelve el elemento que esta en la cima de la pila.<br>Se comprueba si la pila esta vacia, si lo esta, se lanza una excepcion de tipo EmptyStackException.
     * </p>
     *
     * @return Elemento que esta en la cima de la pila
     * @throws EmptyStackException La excepcion de pila vacia
     */
    @Override
    public E top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("La pila está vacía");
        } else {
            return top.getElement();
        }
    }
	/**
    * <p>
    * Metodo que devuelve el numero de elementos que existe en la pila.
    * </p>
    * @return tamaño de la pila
    */
   @Override
	public int size() {
        return size;
    }
    /**
    * <p>
    * Metodo que comprueba si la pila esta vacia.<br>Se comprueba si el top es null.
    * </p>
    * @return true si la pila esta vacia, false en caso contrario.
    */
   @Override
	public boolean isEmpty() {
		return top == null ;
	}
    
   /**
	 * <p>
	 * Metodo que muestra todos los elementos de la pila.<br>Se recorre la estructura de nodos y se colocan en una estructura auxiliar de nodos en orden inverso para luego ir añadiendo cada elemento en una cadena de texto que luego se devuelve.
	 * </p>
	 * @return Todos los elementos de la pila
	 */
    @Override
    public String toString() {
    	String p="[";
    	Node<E> aux2, n=top;
    	Node<E> aux1 = new Node<E>(n.getElement());
    	n=n.getNext();
    	while (n.getNext() != null) {
    		aux2 = new Node<E>(n.getElement());
    		aux2.setNext(aux1);
    		aux1=aux2;
    		n=n.getNext();
    	}
    	aux2 = new Node<E>(n.getElement());
		aux2.setNext(aux1);
		aux1=aux2;
    	while (aux1.getNext() != null) {
    		p += aux1.getElement()+", ";
    		aux1=aux1.getNext();
    	}
    	p += aux1.getElement()+"]";
    	return p;
    }
}

