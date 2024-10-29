package Queue;

/**
 * The Class StaticQueue.
 *
 * @param <E> the element type
 */
public class StaticQueue<E> implements Queue<E> {
	
	/** The size. */
	private int size;
	
	/** The front. */
	private int f;
	
	/** The rear. */
	private int r;
	
	/** The queue. */
	private E[] queue;
	
	/**
	 * Instantiates a new empty static queue.
	 */
	public StaticQueue() {
		this.size = 0;
		this.f = 0;
		this.queue = (E[]) new Object[1];
		this.r = (this.f+this.size) % this.queue.length;
	}
	
	/**
	 * Add a new element at the rear of the queue.<br>If the queue is full, it will resize the queue array.
	 * @param e the e
	 */
	public void enqueue(E e) {
		int n = this.queue.length;
		if (this.size == n) {
			E[] nq = (E[]) new Object [n+2];
			for (int i = 0;i<n;i++) {
				nq[i] = this.queue[i];
			}
			this.queue = nq;
			this.r = (this.f+this.size) % n;
			this.queue[this.r] = e;
			++this.size;
		} else {
			this.r = (this.f+this.size) % n;
			this.queue[this.r] = e;
			++this.size;
		}
	}

	/**
	 * Removes the element in front position if the queue isn't empty and returns it.
	 * @return the element in the front of the queue.
	 * @throws EmptyQueueException the empty queue exception.
	 */
	public E dequeue() throws EmptyQueueException {
		E e;
		int n = this.queue.length;
		if (this.isEmpty()) {
			throw new EmptyQueueException(Queue.errmsg);
		} else {
			e = this.queue[this.f];
			this.f = (f+1) % n;
			--this.size;
			return e;
		}
	}

	/**
	 * Front.
	 * Returns the element in the front position of the queue if it isn't empty.
	 * @return the element in the front position of the queue.
	 * @throws EmptyQueueException the empty queue exception.
	 */
	public E front() throws EmptyQueueException {
		if (this.isEmpty()) {
			throw new EmptyQueueException("La cola está vacía.");
		} else {
			return this.queue[this.f];
		}
	}

	/**
	 * Checks if the queue is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the size of the queue.
	 * @return the int
	 */
	public int size() {
		return size;
	}

}
