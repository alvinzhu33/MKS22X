import java.util.*;

public class FrontierQueue<T> implements Frontier<T>{
    private Queue<T> q;

    public FrontierQueue(){
        q = new LinkedList<T>();
    }
    public void add(T element){
        q.add(element);
    }
    public T next(){
        return q.remove();
    }
    public boolean hasNext(){
        return q.size()>1;
    }
}
