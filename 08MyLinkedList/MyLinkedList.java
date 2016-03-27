import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{
    public LNode start;
    public LNode end;
    public int size;

    //-----------------------------------------------------------------------
    //Iterator
    public Iterator<T> iterator(){
	return new Boop();
    }
    public class Boop implements Iterator<T>{
	public LNode next;

	public Boop(){
	    next = start;
	}
	public boolean hasNext(){
	    return next!=null;
	}
	public T next(){
	    if(! hasNext()){
		throw new NoSuchElementException();
	    }
	    T temp = next.get();
	    next = next.getNext();
	    return temp;
	}
	public void remove(){
	    remove();
	}
    }

    //-------------------------------------------------------------------
    //Methods
    
    //get the value of the element at the specified index (0 based)
    public T get(int index){
	if(index<0 || index>size-1){
	    throw new IndexOutOfBoundsException();
	}

	LNode copy = start;
	for(int i=0; i<index; i++){
	    copy = copy.getNext();
	}
	return copy.get();
    }

    //change the value of the element at the specified index to the newValue, return the old value
    public T set(int index,T newValue){
	if(index<0 || index>size-1){
	    throw new IndexOutOfBoundsException();
	}

	LNode copy = start;
	for(int i=0; i<index; i++){
	    copy = copy.getNext();
	}

	T ans = copy.get();
	copy.set(newValue);
	return ans;
    }

    //return the number of elements in the list
    public int size(){
	return size;
    }

    //remove the element at the specified index, returns the value removed
    public T remove(int index){
	if(index<0 || index>size-1){
	    throw new IndexOutOfBoundsException();
	}

	T ans = start.get();
	if(index==0){
	    ans = start.get();
	    start = start.getNext();
	    if(index == size-1){
		end = start;
	    }
	}else{
	    LNode copy = start;
	    for(int i=0; i<index-1; i++){
		copy = copy.getNext();
	    }
	    LNode after = copy.getNext();
	    ans = after.get();
	    after = after.getNext();
	    copy.setNext(after);
	    if(index == size-1){
		end = copy;
	    }
	}
	size--;

	return ans;
    }


    public boolean add(T value){
	if(start==null){
	    start = new LNode(value);
	    end = start;
	}else{
	    end.setNext(new LNode(value));
	    end = end.getNext();
	}
	size++;

	return true;
    }

    public boolean add(int index, T value){	
	if(index<0 || index>size){
	    throw new IndexOutOfBoundsException();
	}

	if(index==size){
	    add(value);
	}
	else{ 
	    if(index==0){
		LNode adding = new LNode(value);
		adding.setNext(start);
		start = adding;
		if(start==null){
		    end = adding;
		}
	    }else{
		LNode copy = start;
		for(int i=0; i<index-1; i++){
		    copy = copy.getNext();
		}
		LNode adding = new LNode(value);
		LNode shift = copy.getNext();
		adding.setNext(shift);
		copy.setNext(adding);
		if(index == size){
		    end = copy.getNext();
		}
	    }
	    size++;
	}

	return true;
    }

    //returns the index of the 1st occurrence of the value in the linked list, -1 if not found.
    public int indexOf(T value){
	LNode copy = start;
	for(int i=0; i<size; i++){
	    if((copy.get()).equals(value)){
		return i;
	    }else{
		copy = copy.getNext();
	    }
	}
	return -1;
    }

    //returns a list formatted like: [ v1, v2, v3, ... vn-1, vn ]
    public String toString(){
	String copy="[";
	if(size!=0){
	    copy+=start.get();
	}

	LNode current = start;
	for(int i=0; i<size-1; i++){
	    current = current.getNext();
	    copy += ", "+current.get();
	}
	copy += "]";

	return copy;
    }


    //-------------------------------------------------------------------------
    //LNode
    private class LNode{
	public T data;
	public LNode next;

	/*public LNode(){
	  data=0;
	  }*/

	public LNode(T car){
	    data=car;
	}

	/*public LNode(int car, LNode cdr){
	  data = car;
	  next = cdr;
	  }*/

	public T get(){
	    return data;
	}

	public LNode getNext(){
	    return next;
	}

	public void set(T value){
	    data = value;
	}

	public void setNext(LNode cdr){
	    next = cdr;
	}
    }

    public String toString(boolean b){
	String info="";
	if(b){
	    String copy="[";
	    if(size!=0){
		copy+=start.get();
	    }

	    LNode current = start;
	    for(int i=0; i<size-1; i++){
		current = current.getNext();
		copy += ", "+current.get();
	    }
	    copy += "]";
	    
	    info+= "   Head: ";
	    info+= (String)start.get() + "   End: ";
	    info+= (String)end.get();

	    info = copy+info;
	}
	return info;
    }

    //-------------------------------------------------------------------------
    public static void main(String[]args){
        MyLinkedList<Integer> i = new MyLinkedList<Integer>();
	/*i.add(new Integer(5));
	System.out.println(i);
	i.set(0, new Integer(3));
	System.out.println(i);
	i.remove(0);
	System.out.println(i);*/
	for(int p=0; p<100; p++){
	    i.add(new Integer(p));
	}
	//System.out.println(i);
	System.out.println(i.indexOf(0));
	System.out.println(i.indexOf(100));
	System.out.println(i.indexOf(99));

	MyLinkedList<String> s = new MyLinkedList<String>();
	/*s.add("bye");
	System.out.println(s);
	s.set(0,"Hello");
	System.out.println(s);
	s.remove(0);
	System.out.println(s);*/
	s.add("hi");
	s.add("5");
	s.add("bye");
	s.add("66");
	s.add("22");
	s.add(".");
	System.out.println(s);
	System.out.println(s.indexOf("hi"));
	System.out.println(s.indexOf("."));
	System.out.println(s.indexOf(""));
    }
}
