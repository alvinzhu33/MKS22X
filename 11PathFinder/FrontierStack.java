import java.util.*;

public class FrontierStack<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/
    Stack<T> s = new Stack<T>();

    public void add(T element){
        s.push(element);
    }
    public T next(){
        s.pop();
        return s.peek();
    }
    public boolean hasNext(){
        T copy = s.pop();
        if(s.empty()){
            s.push(copy);
            return false;
        }else{
            s.push(copy);
            return true;
        }
    }
}
