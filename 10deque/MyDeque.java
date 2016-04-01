import java.util.*;

public class MyDeque<T>{
    Object[] data;
    int start,end;
    int size=0;

    public MyDeque(){
	data = new Object[10];
    }

    //You need a private method to grow the array and copy over the values.
    private void grow(){
	Object[] copy = new Object[data.length*2];
	
	for(int i=0; i<data.length; i++){
	    copy[i]=data[i];
	}

	data = copy;
    }

    //When the array is full, re-size, then add. 
    //No exceptions are required since you will re-size.
    public void addFirst(T value){
	size++;
    };
    public void addLast(T value){
	size++;
    };
    
    //NoSuchElementException is thrown when there are no elements. 
    public T removeFirst(){
	return end;
    };  
    public T removeLast(){
	return start;
    };  
    
    //NoSuchElementException is thrown when there are no elements. 
    public T getFirst(){
	return start;
    };
    public T getLast(){
	return end;
    };

    public String toString(){
	return "hello";
    };
}
