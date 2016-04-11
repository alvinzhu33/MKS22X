import java.util.*;

public class FrontierQueue<T> implements Frontier<T>{
    MyQueue<T> q = new MyQueue<T>();

    public void add(T element){
        q.enqueue(element);
    }
    public T next(){
        q.dequeue();
        return q.peek();
    }
    public boolean hasNext(){
        T copy = q.dequeue();
        if(q.isEmpty()){
            q.enqueue(copy);
            return false;
        }else{
            q.enqueue(copy);
            return true;
        }
    }
}
