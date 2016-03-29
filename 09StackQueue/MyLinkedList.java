import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{
    private class LNode{
	private T value;
	private LNode next;
	public LNode(T v){
	    value = v;
	}
	public T getValue(){
	    return value;
	}
	public LNode getNext(){
	    return next;
	}
	public T setValue(T v){
	    T old = value;
	    value = v;
	    return old;
	}
	public void setNext(LNode n){
	    next = n;
	}
	public String toString(){
	    return value.toString();
	}
    }

    LNode head;
    LNode tail;
    int size;
    
    public Iterator<T> iterator(){
	//This uses an anonymous class! You don't need to know this.
	return new Iterator<T>()
	{
	    private LNode current = head;

	    public boolean hasNext(){
		return current != null;
	    }
	    public T next(){
		if(!hasNext()){
		    throw new NoSuchElementException();
		}
		T value = current.getValue();
		current = current.getNext();
		return value;
	    }
	    public void remove(){
		throw new UnsupportedOperationException();
	    }
	};
    }
    
    public String toString(){
	String ans = "[";
	LNode p = head;
	while(p!=null){
	    ans += p.getValue();
	    if(p.getNext()!=null){
		ans += ", ";
	    }
	    p = p.getNext();
	}
	return ans+"]";
    }
    public String toString(boolean b){
	return toString()+" head: "+head +", tail: "+tail;
    }
    
    private LNode getNth(int index){
	//check bounds before calling this method!
	LNode temp = head;
	while(index > 0){
	    temp = temp.getNext();
	    index --;
	}
	return temp;
    }
    
    public boolean add(T value){
	if(head == null){
	    head = new LNode(value);
	    tail = head;
	}else{
	    tail.setNext(new LNode(value));
	    tail = tail.getNext();
	}
	size++;
	return true;
    }
    
    public boolean add(int index, T value){
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	LNode temp = new LNode(value); 
	if(index == 0){
	    temp.setNext(head);
	    head = temp;
	    if(size==0){
		tail = head;
	    }
	}else{ 
	    LNode p = getNth(index-1);
	    temp.setNext(p.getNext());
	    p.setNext(temp);
	    if(tail.getNext() != null){
		tail=tail.getNext();
	    }
	}
	size++;
	return true;
    }
    
    public T remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size());
	}
	LNode temp;
	if(index == 0){
	    temp = head;
	    head = head.getNext();
	    size--;
	    if(head == null){
		tail = null;
	    }
	    return temp.getValue();
	}else{
	    LNode p = getNth(index-1);
	    temp = p.getNext();
	    if(tail == temp){
		tail = p;
	    }
	    p.setNext(p.getNext().getNext());
	    size --;
	    return temp.getValue();
	}
    }
    
    public int size(){
	return size;
    }
    public T get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	return getNth(index).getValue();
    }
    public T set(int index, T newValue){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	return getNth(index).setValue(newValue);
    }

    public int indexOf(T target){
	LNode temp = head;
	int index = 0;
	while(temp != null){
	    if(temp.getValue().equals(target)){
		return index;
	    }
	    index++;
	    temp = temp.getNext();
	}
	return -1;
    }

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
}
