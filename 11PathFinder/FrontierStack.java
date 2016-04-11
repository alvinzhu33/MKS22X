import java.util.*;

public class FrontierStack<T> implements Frontier<T>{
    Stack<T> s;
    Node head;

    public FrontierStack(){
	s = new Stack<T>();
    }
    public void add(Node element){
        s.push(element);
	if(s.size()==1){
	    head = element;
	}
    }
    public T next(){
        s.pop();
        return s.peek();
    }
    public boolean hasNext(){
        /*T copy = s.pop();
        if(s.empty()){
            s.push(copy);
            return false;
        }else{
            s.push(copy);
            return true;
	    }*/
	return s.size()>1;
    }
}
