package pila;

public class DinamicStack<E> implements Stack<E> {
	private int size;
	private Node<E> top;
	
	 private static class Node<E> {
	        E data;
	        Node<E> next;

	        public Node(E data) {
	            this.data = data;
	        }
	    }
	  public DinamicStack() {
	        top = null;
	        size = 0;
	    }
	  
	public int size() {
		/**
		 * cada vez que se hace un push aumenta el size
		 *  y cada vez que se usa un pop disminuye el size
		 */
        return size;
        }
	public boolean isEmpty() {
		/**
		 * Se inicializa la pila estando vacia y hacer un pop actualizamos con top.next para ver el siguiente elemento
		 * Al hacer un push (Node<E> newNode = new Node<>(element);
         * newNode.next = top;
         * top = newNode;
         * size++;)
		 */
		return top == null ;
	}
}