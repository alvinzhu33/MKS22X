public class myLinkedList{
    public LNode start;
    public int size;

    //get the value of the element at the specified index (0 based)
    int get(int index){
	
    }
    
    //change the value of the element at the specified index to the newValue, return the old value
    int set(int index,int newValue){
	
    }

    //return the number of elements in the list
    int size(){
	
    }

    //remove the element at the specified index, returns the value removed
    int remove(int index){
	
    }

    //insert a new elmeent at the specified index, 0 at the front, size() at the end.
    boolean add(int index, int value){
	
    }

    //adds to end
    boolean add(int value){
	
    }

    //returns the index of the 1st occurrence of the value in the linked list, -1 if not found.
    int indexOf(int value){
	
    }

    //returns a list formatted like: [ v1, v2, v3, ... vn-1, vn ]
    void toString(){
	
    }

    public class LNode{
	public int data;
	public LNode next;

	public LNode(int car, LNode cdr){
	    data = car;
	    next = cdr;
	}

	public int get(){
	    return data;
	}

	public LNode getNext(){
	    return cdr;
	}

	public boolean set(int value){
	    data = value;
	}

	public boolean setNext(LNode cdr){
	    next = cdr;
	}
    }
}
