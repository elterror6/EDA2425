package Queue;

public class DinamicQueue<E> implements Queue<E>{
	private Node<E> queue;
	private Node<E> front;
	private Node<E> rear;
	private int size;
	
	public DinamicQueue() {
		this.queue=null;
		this.front=null;
		this.rear=null;
		this.size=0;
	}
	
	@Override
	public void enqueue(E e) {
		Node<E> aux = new Node (e);
		if (this.isEmpty()) {
			this.front=aux;
		} else {
			this.rear.setNext(aux);
		}
		this.rear=aux;
		++this.size;
	}

	@Override
	public E dequeue() throws EmptyQueueException{
		E e;
		if (this.isEmpty()) {
			throw new EmptyQueueException(Queue.errmsg);
		} else {
			e=this.front.getElement();
			this.front=this.front.getNext();
			--this.size;
			if (this.size==0) {
				this.rear=null;
			}
			return e;
		}
	}

	@Override
	public E front() throws EmptyQueueException{
		if (this.isEmpty()) {
			throw new EmptyQueueException(Queue.errmsg);
		} else {
			return this.front.getElement();
		}
	}

	@Override
	public boolean isEmpty() {
		return this.size==0; 
	}

	@Override
	public int size() {
		return this.size;
	}

}
