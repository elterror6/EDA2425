package Queue;

public interface Queue<E> {
	String errmsg = "La cola esta vacía";
	
	public abstract void enqueue(E e);
	public abstract E dequeue();
	public abstract E front();
	public abstract boolean isEmpty();
	public abstract int size();
	public abstract String toString();
}
