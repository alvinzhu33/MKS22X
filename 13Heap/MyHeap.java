import java.util.*;
@SuppressWarnings("unchecked")

public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;
    private boolean isMax=true;

    public MyHeap(){
	data = (T[]) new Object[9];
	size = 0;
    }
    public MyHeap(T[] array){
	size = array.length+1;
	data = (T[]) new Object[size+1];
	for(int i=1; i<size-1; i++){
	    data = array[i];
	}
	heapify();
    }
    private void pushDown(int k){

    }
    private void pushUp(int k){
	
    }
    private void heapify(){
	
    }
    public T delete(){
	return data[0];
    }
    public void add(T x){
	if(size==0){
	    data[1]=x;
	}
	size++;
    }
    private void doubleSize(){
	
    }
    public String toString(){
	return "";
    }

    public MyHeap(boolean isMax){
	
    }
    public MyHeap(T[] array, boolean isMax){
	
    }
}
