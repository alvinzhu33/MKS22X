import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;
    private boolean isMax=true;

    public MyHeap(){
	data = (T[]) new Comparable[9];
	size = 0;
    }
    public MyHeap(T[] array){
	size = array.length+1;
	data = (T[]) new Comparable[size+1];
	for(int i=1; i<size-1; i++){
	    data[i] = array[i];
	}
	heapify();
    }
    public MyHeap(boolean isMax){
	data = (T[]) new Comparable[9];
	size = 0;
	this.isMax = isMax;
    }
    public MyHeap(T[] array, boolean isMax){
	
    }

    private void pushDown(int k){
	T store = data[k];
	System.out.println(k);
	System.out.println(store);
    }
    private void pushUp(int k){
	T store = data[k];
	System.out.println(k);
	System.out.println(store);
    }
    private void heapify(){
	int child = size;
	for(int i=size/2; i>0; i--){
	    if(isMax && data[i].compareTo(data[child])<0){
		pushDown(i);
	    }
	    if(!isMax && data[i].compareTo(data[child])>0){
		pushUp(i);
	    }
	    child--;
	}
    }
    public T delete(){
	return data[0];
    }
    public void add(T x){
	if(size==0){
	    data[1]=x;
	}else{
	    if(size+1>=data.length){
		doubleSize();
	    }
	    data[size+1]=x;
	}
	size++;
	heapify();
    }
    private void doubleSize(){
	T[] doubled = (T[]) new Object[(data.length-1)*2+1];
    }
    public String toString(){
	String ans="";
	for(int i=1; i<=size; i++){
	    ans+=data[i]+" ";
	}
	return ans;
    }

    public static void main(String[]args){
	MyHeap<Integer> a = new MyHeap<>(false);
	a.add(5);
	a.add(4);
	a.add(3);
	System.out.println(a);
    }
}
