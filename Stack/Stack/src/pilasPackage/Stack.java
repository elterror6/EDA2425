package pilasPackage;

// TODO: Auto-generated Javadoc
/**
 * <h1>Interfaz Stack</h1>
 * <p>
 * Esta interfaz especifica las operaciones que va a tener una pila. 
 * </p>
 *
 * @author Daniel Díaz García
 * @author Diego Repullo Higueruela
 * @param <E> El tipo de elemento
 */
public interface Stack<E> {
	/**
	 * <h2>Push</h2>
	 * <p>
	 * Método que añade un nuevo elemento a la pila.
	 * </p>
	 * @param element Elemento a insertar en la pila.
	 */
	public abstract void push(E element);
	/**
	 * <h2>Pop</h2>
	 * <p>
	 * Método que extrae y elimina el último elemento de la pila.
	 * </p>
	 * @return último elemento añadido a la pila
	 */
	public abstract E pop();
	/**
	 * <h2>Top</h2>
	 * <p>
	 * Método que extrae el último elemento de la pila.
	 * </p>
	 * @return último elemento añadido en la pila
	 */
	public abstract E top();
	/**
	 * <h2>isEmpty</h2>
	 * <p>
	 * Método que comprueba si la pila esta vacía.
	 * </p>
	 * @return True si la pila esta vacía y False si la pila no esta vacía
	 */
	public abstract boolean isEmpty();
	/**
	 * <h2>Size</h2>
	 * <p>
	 * Método que devuelve el número de elementos que contiene la pila.
	 * </p>
	 * @return Número de elementos que conforman la pila
	 */
	public abstract int size();
	
	/**
	 * <h2>ToString</h2>
	 * <p>
	 * Método que devuelve información sobre la pila.
	 * </p>
	 * @return Una cadena de texto con información sobre la pila
	 */
	@Override
	public abstract String toString();
}