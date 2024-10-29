package Queue;

/**
 * <p>
 * Esta clase representa una estructura de nodos, de tal manera que se guarde un elemento y el siguiente elemento de la estructura.
 * </p>
 *
 * @author Daniel Diaz Garcia
 * @author Diego Repullo Higueruela
 * @param <E> El tipo de elemento
 */
public class Node<E> {
    
    /** El elemento. */
    private E element;
    
    /** El siguiente elemento. */
    private Node<E> next;
    /**
     * <p>
     * Metodo constructor que crea un nuevo nodo con un elemento y sin siguiente elemento.
     * </p>
     * @param element Elemento del nodo
     */
    public Node(E element) {
        this.element = element;
        this.next = null;
    }
    /**
     * <p>
     * Metodo que devuelve el elemento del nodo.
     * </p>
     * @return Elemento del nodo
     */
    public E getElement() {
        return element;
    }
    /**
     * <p>
     * Metodo que devuelve el siguiente nodo de la estructura.
     * </p>
     * @return Nodo siguiente de la estructura
     */
    public Node<E> getNext() {
        return next;
    }
    /**
     * <p>
     * Metodo que establece el siguiente nodo de la estructura.
     * </p>
     * @param next Nodo siguiente de la estructura
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
    /**
     * <p>
     * Metodo que establece el elemento del nodo.
     * </p>
     * @param element Elemento del nodo
     */
    public void setElement(E element) {
        this.element = element;
    }
}