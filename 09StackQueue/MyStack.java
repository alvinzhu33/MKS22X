public class MyStack<T>{
    MyLinkedList<T> stack = new MyLinkedList<T>();
    int size=0;
	
    /**
     * Adds the given item to the top of the stack.
     */
    void push(T item){
	stack.add(item);
	size++;
    }
    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T pop(){
	if(stack==null){
	    throw new NoSuchElementException();
	}

	T ans = stack.get(size-1);
	stack.remove(size-1);
	return ans;
    }
    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T peek(){
	if(stack==null){
	    throw new NoSuchElementException();
	}
	    
	return stack.get(size-1);
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
