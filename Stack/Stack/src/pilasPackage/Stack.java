package pilasPackage;

/**
 * <p>
 * Esta interfaz especifica las operaciones que va a tener una pila. 
 * </p>
 *
 * @author Daniel Diaz Garcia
 * @author Diego Repullo Higueruela
 * @param <E> El tipo de elemento
 */
public interface Stack<E> {
	/**
	 * <p>
	 * Metodo que añade un nuevo elemento a la pila.
	 * </p>
	 * @param element Elemento a insertar en la pila.
	 */
	public abstract void push(E element);
	/**
	 * <p>
	 * Metodo que extrae y elimina el ultimo elemento de la pila.
	 * </p>
	 * @return ultimo elemento añadido a la pila
	 */
	public abstract E pop();
	/**
	 * <p>
	 * Metodo que extrae el ultimo elemento de la pila.
	 * </p>
	 * @return ultimo elemento añadido en la pila
	 */
	public abstract E top();
	/**
	 * <p>
	 * Metodo que comprueba si la pila esta vacia.
	 * </p>
	 * @return True si la pila esta vacia y False si la pila no esta vacia
	 */
	public abstract boolean isEmpty();
	/**
	 * <p>
	 * Metodo que devuelve el numero de elementos que contiene la pila.
	 * </p>
	 * @return Numero de elementos que conforman la pila
	 */
	public abstract int size();
	
	/**
	 * <p>
	 * Metodo que devuelve informacion sobre la pila.
	 * </p>
	 * @return Una cadena de texto con informacion sobre la pila
	 */
	@Override
	public abstract String toString();
}