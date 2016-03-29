import java.util.*;

public class MyStack<T>{
    MyLinkedList<T> stack;
    int size=0;

    MyStack(){
	stack = new MyLinkedList<T>();
    }
	
    /**
     * Adds the given item to the top of the stack.
     */
    void push(T item){
	stack.add(0,item);
	size++;
    }

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */

    T pop(){
	if(size==0){
	    throw new NoSuchElementException();
	}

	T ans = stack.get(0);
	stack.remove(0);
	size--;
	return ans;
    }

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T peek(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	    
	return stack.get(0);
    }

    /**
     * Returns the number of items currently in the stack.
     */
    int size(){
	return size;
    }

    /**
     * Returns whether the stack is empty or not.
     */
    boolean isEmpty(){
	return size==0;
    }
}
