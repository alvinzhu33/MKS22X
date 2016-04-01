import java.util.*;

public class MyDeque<T>{
    //You need a private method to grow the array and copy over the values.
    
    //When the array is full, re-size, then add. 
    //No exceptions are required since you will re-size.
    public void addFirst(T value);
    public void addLast(T value);
    
    //NoSuchElementException is thrown when there are no elements. 
    public T removeFirst();  
    public T removeLast();  
    
    //NoSuchElementException is thrown when there are no elements. 
    public T getFirst();
    public T getLast();
}
