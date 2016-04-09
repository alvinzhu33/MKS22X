import java.util.*;

public class FrontierQueue<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/
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
