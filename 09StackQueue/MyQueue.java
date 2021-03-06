import java.util.*;

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
	if(size==0){
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
	if(size==0){
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

    public static void main(String[]args){
	MyQueue<Integer> mine = new MyQueue<Integer>();
	//Queue<Integer> its = new Queue<Integer>();

	for(int i=0; i<1000000; i++){
	    mine.enqueue(i);
	    //its.enqueue(i);
	}

	boolean match=true;
	for(int i=0; i<1000000; i++){
	    if(mine.dequeue()!=i){
		match = false;
	    }
	}
	
	/*boolean match=true;
	while(!mine.isEmpty()){
	    if(! mine.peek().equals( its.peek() ) ){
		match = false;
	    }
	    if(! mine.pop().equals( its.pop() ) ){
		match = false;
	    }
	    }*/
	System.out.println(match);
    }
}
