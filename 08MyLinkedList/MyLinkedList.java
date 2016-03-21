public class MyLinkedList<T>{
    public LNode start;
    public LNode end;
    public int size;

    //get the value of the element at the specified index (0 based)
    public T get(int index){
	if(index<0 || index>size-1){
	    throw new IllegalArgumentException();
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
	    throw new IllegalArgumentException();
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
	    throw new IllegalArgumentException();
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
	    //throw new IllegalArgumentException();
	    return false;
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
    /*public int indexOf(int value){
      LNode copy = start;
      for(int i=0; i<size; i++){
      if(copy.get()==value){
      return i;
      }else{
      copy = copy.getNext();
      }
      }
      return -1;
      }*/

    //returns a list formatted like: [ v1, v2, v3, ... vn-1, vn ]
    public String toString(){
	String copy="[ ";
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

    /*public static void main(String[]args){
      MyLinkedList<Integer> m = new MyLinkedList<Integer>();

      int i = 0;
      while(i < 100){
      m.add(i);
      i++;
      }
	m.remove(97);
	m.remove(20);
	m.remove(0);
	System.out.println(m);
	m.add(0,0);
	m.add(20,20);
	m.add(97,97);
	System.out.println(m);
	m.add(100);
	m.add(101);
	m.add(102);
	System.out.println(m);
	//System.out.println(m.indexOf(0));
	//System.out.println(m.indexOf(50));
	//System.out.println(m.indexOf(73));
	}*/

    public static void main(String[]args){
        MyLinkedList<Integer> i = new MyLinkedList<Integer>(); //calling a constructor USES diamond notation
	i.add(new Integer(5));
	System.out.println(i);
	i.set(0, new Integer(3));
	System.out.println(i);
	i.remove(0);
	System.out.println(i);

	MyLinkedList<String> s = new MyLinkedList<String>();
	s.add("bye");
	System.out.println(s);
	s.set(0,"Hello");
	System.out.println(s);
	s.remove(0);
	System.out.println(s);
    }
}
