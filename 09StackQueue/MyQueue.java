public class MyQueue<T>{
    public MyLinkedList<T> queue = new MyLinkedList<T>();
    public int size=0;
	
    /**
     * Adds the given item to the rear of the queue.
     */
    void enqueue(T item){
	queue.add(item);
	size++;
    }
    /**
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T dequeue(){
	if(queue==null){
	    throw new NoSuchElementException();
	}
	T ans = queue.get(0);
	queue.remove(0);
	size--;
	return ans;
    }
    /**
     * Returns the front item from the queue without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T peek(){
	if(queue==null){
	    throw new NoSuchElementException();
	}

	return queue.get(0);
    }
    /**
     * Returns the number of items currently in the queue.
     */
    int size(){
	return size;
    }
    /**
     * Returns whether the queue is empty or not.
     */
    boolean isEmpty(){
	if(size==0){
	    return true;
	}
	return false;
    }
}
