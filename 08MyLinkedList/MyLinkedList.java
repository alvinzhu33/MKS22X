public class MyLinkedList{
    public LNode start;
    public int size;

    /*public MyLinkedList(){
	size=0;
	start = new LNode();
	}*/

    //get the value of the element at the specified index (0 based)
    public int get(int index){
	return 1;
    }

    //change the value of the element at the specified index to the newValue, return the old value
    public int set(int index,int newValue){
	return 1;
    }

    //return the number of elements in the list
    public int size(){
	return 1;
    }

    //remove the element at the specified index, returns the value removed
    public int remove(int index){
	return 1;
    }

    //insert a new elmeent at the specified index, 0 at the front, size() at the end.
    public boolean add(int index, int value){
	return false;
    }

    public boolean add(int value){
	if(start==null){
	    start = new LNode(value);
	}else{
	    LNode next = start;
	    while(next.getNext()!=null){
		next = next.getNext();
	    }
	    next.setNext(new LNode(value));
	}
	size++;
	return true;
    }

    //returns the index of the 1st occurrence of the value in the linked list, -1 if not found.
    public int indexOf(int value){
	return 1;
    }

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
	public int data;
	public LNode next;

	public LNode(){
	    data=0;
	}

	public LNode(int car){
	    data=car;
	}

	public LNode(int car, LNode cdr){
	    data = car;
	    next = cdr;
	}

	public int get(){
	    return data;
	}

	public LNode getNext(){
	    return next;
	}

	public void set(int value){
	    data = value;
	}

	public void setNext(LNode cdr){
	    next = cdr;
	}
    }
}
