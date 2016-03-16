public class MyLinkedList{
    public LNode start;
    public int size;

    //get the value of the element at the specified index (0 based)
    public int get(int index){
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
    public int set(int index,int newValue){
	if(index<0 || index>size-1){
	    throw new IllegalArgumentException();
	}
	
	LNode copy = start;
	for(int i=0; i<index; i++){
	    copy = copy.getNext();
	}

	int ans = copy.get();
	copy.set(newValue);
	return ans;
    }

    //return the number of elements in the list
    public int size(){
	return size;
    }

    //remove the element at the specified index, returns the value removed
    public int remove(int index){
	if(index<0 || index>size-1){
	    throw new IllegalArgumentException();
	}

	int ans = 0;
	if(index==0){
	    ans = start.get();
	    start = start.getNext();
	}else{
	    LNode copy = start;
	    for(int i=0; i<index-1; i++){
		copy = copy.getNext();
	    }
	    LNode after = copy.getNext();
	    ans = after.get();
	    after = after.getNext();
	    copy.setNext(after);
	}
	size--;
	
	return ans;
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

    public boolean add(int index, int value){
	/*if(index<0 || index>size){
	//throw new IllegalArgumentException();
	return false;
	}

	if(index==0){
	LNode adding = new LNode(value);
	adding.setNext(start);
	start = adding;
	}else{
	if(index==size+1){
	add(value);
	}else{
	LNode copy = start;
	for(int i=0; i<index-1; i++){
	copy = copy.getNext();
	}
	LNode adding = new LNode(value);
	LNode shift = copy.getNext();
	adding.setNext(shift);
	copy.setNext(adding);
	}
	}
	return true;*/
	
	if(index<0 || index>size){
	    //throw new IllegalArgumentException();
	    return false;
	}

	if(index==0){
	    LNode adding = new LNode(value);
	    adding.setNext(start);
	    start = adding;
	}else{
	    LNode copy = start;
	    for(int i=0; i<index-1; i++){
		copy = copy.getNext();
	    }
	    LNode adding = new LNode(value);
	    LNode shift = copy.getNext();
	    adding.setNext(shift);
	    copy.setNext(adding);
	}
	size++;
	return true;
    }

    //returns the index of the 1st occurrence of the value in the linked list, -1 if not found.
    public int indexOf(int value){
	LNode copy = start;
	for(int i=0; i<size; i++){
	    if(copy.get()==value){
		return i;
	    }else{
		copy = copy.getNext();
	    }
	}
	return -1;
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

    public static void main(String[]args){
	MyLinkedList m = new MyLinkedList();
	/*MyLinkedList l1 = new MyLinkedList();
	l1.add(54);
	l1.add(54);
	l1.add(54);
	System.out.println(l1);
	System.out.println(l1.size());
	System.out.println(l1.get(0));
	System.out.println(l1.get(1));
	System.out.println(l1.get(2));
	System.out.println(l1.get(3));*/

	int i = 0;
	while(i < 100){
	    m.add(i);
	    i++;
	}
	/*m.add(54);
	m.add(-10);
	m.add(47);*/
	//m.set(20,120);
	//m.set(0,100);
	m.remove(97);
	m.remove(20);
	m.remove(0);
	System.out.println(m);
	m.add(0,0);
	m.add(20,20);
	m.add(97,97);
	System.out.println(m);
	System.out.println(m.indexOf(0));
	System.out.println(m.indexOf(50));
	System.out.println(m.indexOf(73));
	//System.out.println(m.get(5));
	//System.out.println(m.get(20));
	//System.out.println(m.get(79));
    }
}
