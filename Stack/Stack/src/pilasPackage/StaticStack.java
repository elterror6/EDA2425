package pilasPackage;

/**
 * <p>
 * Clase que implementa la interfaz Stack para una pila estatica.
 * </p>
 *
 * @author Daniel Diaz Garcia
 * @author Diego Repullo Higueruela
 * @param <E> El tipo de elemento
 */
public class StaticStack<E> implements Stack<E> {
	
	/** La pila. */
	private E[] stack;
	
	/** El indice top de la pila. */
	private int t;
	/**
	 * <p>
	 * Metodo constructor que crea una nueva pila vacia.
	 * </p>
	 */
	public StaticStack() {
		this.stack = (E[]) new Object[1];
		this.t = -1;
	}
	/**
	 * <p>
	 * Metodo que inserta un nuevo elemento en la pila.<br>Se comprueba si la pila esta llena, si lo esta, se ajusta el tamaño del array y se inserta el nuevo elemento.
	 * </p>
	 * @param element Elemento a insertar en la pila
	 */
	@Override
	public void push(E element) {
		int n=this.stack.length;
		if (this.t == n - 1) {
			E[] ns = (E[]) new Object[n*2];
			for (int i = 0; i<n; i++) {
				ns[i]=this.stack[i];
			}
			this.stack=ns;
			++this.t;
			this.stack[t]=element;
		} else {
			++this.t;
			this.stack[this.t] = element;
		}
	}
	
	/**
	 * <p>
	 * Metodo que elimina y devuelve el elemento que esta en la cima de la pila.<br>Se comprueba si la pila esta vacia lanza una excepcion de tipo EmptyStackException.
	 * </p>
	 *
	 * @return elemento que se ha eliminado de la pila
	 * @throws EmptyStackException La excepcion de pila vacia
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
	 * <p>
	 * Metodo que devuelve el elemento que esta en la cima de la pila.<br>Se comprueba si la pila esta vacia lanza una excepcion de tipo EmptyStackException.
	 * </p>
	 *
	 * @return elemento que esta en la cima de la pila
	 * @throws EmptyStackException La excepcion de pila vacia
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
	 * <p>
	 * Metodo que comprueba si la pila esta vacia.
	 * </p>
	 * @return true si la pila está vacia, false en caso contrario.
	 */
	@Override
	public boolean isEmpty() {
        return this.t < 0;
	}
	/**
	 * <p>
	 * Metodo que devuelve el numero de elementos que existen en la pila.
	 * </p>
	 * @return tamaño de la pila
	 */
	@Override
	public int size() {
	    return this.t + 1;
	}
	
	/**
	 * <p>
	 * Metodo que muestra todos los elementos de la pila.<br>Se recorre la matriz unidimensional que representa la pila y se añaden a una cadena de texto la cual se devuelve.
	 * </p>
	 * @return Todos los elementos de la pila
	 */
	@Override
	public String toString() {
	    String result = "[";  
	    for (int i = 0; i <= t; i++){
	        result = result + stack[i];
	        if (i < t){
	            result = result + ", ";
	        }
	    }
	    result = result + "]"; 
	    return result;
	}
}
