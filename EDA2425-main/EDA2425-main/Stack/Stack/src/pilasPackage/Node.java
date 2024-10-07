package pilasPackage;

// TODO: Auto-generated Javadoc
/**
 * <h1>Node</h1>
 * <p>
 * Esta clase representa una estructura de nodos, de tal manera que se guarde un elemento y el siguiente elemento de la estructura.
 * </p>
 *
 * @author Daniel Díaz García
 * @author Diego Repullo Higueruela
 * @param <E> El tipo de elemento
 */
public class Node<E> {
    
    /** El elemento. */
    private E element;
    
    /** El siguiente elemento. */
    private Node<E> next;
    /**
     * <h2>Constructor</h2>
     * <p>
     * Método constructor que crea un nuevo nodo con un elemento y sin siguiente.
     * </p>
     * @param element Elemento del nodo
     */
    public Node(E element) {
        this.element = element;
        this.next = null;
    }
    /**
     * <h2>getElement()</h2>
     * <p>
     * Método que devuelve el elemento del nodo.
     * </p>
     * @return Elemento del nodo
     */
    public E getElement() {
        return element;
    }
    /**
     * <h2>getNext()</h2>
     * <p>
     * Método que devuelve el siguiente nodo de la estructura.
     * </p>
     * @return Nodo siguiente de la estructura
     */
    public Node<E> getNext() {
        return next;
    }
    /**
     * <h2>setNext()</h2>
     * <p>
     * Método que establece el siguiente nodo de la estructura.
     * </p>
     * @param next Nodo siguiente de la estructura
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
    /**
     * <h2>setElement()</h2>
     * <p>
     * Método que establece el elemento del nodo.
     * </p>
     * @param element Elemento del nodo
     */
    public void setElement(E element) {
        this.element = element;
    }
}