import java.util.*;

public class FrontierQueue<T> implements Frontier<T>{
    private Queue<T> q;

    public FrontierQueue(){
        q = new LinkedList<T>();
    }
    public void add(T element){
        q.add(element);
    }
    public boolean hasNext(){
        return q.size()>0;
    }
    public T next(){
	if(! hasNext()){
	    throw new NoSuchElementException();
	}
        return q.remove();
    }
}
