import java.util.*;

public class MyDeque<T>{
    T[] data;
    int start,end;
    int size=0;

    @SuppressWarnings("unchecked")
    public MyDeque(){
        data = (T[]) new Object[10];
    }

    @SuppressWarnings("unchecked")
    //You need a private method to grow the array and copy over the values.
    private void grow(){
        T[] copy = (T[]) new Object[data.length*2];

        for(int i=0; i<data.length; i++){
            copy[i]=data[i];
        }

        data = copy;
    }

    //When the array is full, re-size, then add.
    //No exceptions are required since you will re-size.
    public void addFirst(T value){
        if(size==data.length){
            grow();
        }
        if(start==0){
            if(data[start]==null){
                start=0;
            }else{
                start=data.length-1;
            }
        }else{
            start--;
        }
        data[start]=value;
        size++;
    }
    public void addLast(T value){
        if(size==data.length){
            grow();
        }
        if(end==data.length-1 || data[end]==null){
            end=0;
        }else{
            end++;
        }
        data[end]=value;
        size++;
    }

    //NoSuchElementException is thrown when there are no elements.
    public T removeFirst(){
        return data[end];
    }
    public T removeLast(){
        return data[end];
    }

    //NoSuchElementException is thrown when there are no elements.
    public T getFirst(){
        return data[start];
    }
    public T getLast(){
        return data[end];
    }

    public String toString(){
        String ans="[ ";
        for(int i=0; i<data.length-1; i++){
            ans+=data[i]+", ";
        }
        ans+=data[data.length-1]+"]";
        return ans;
    }

    public static void main(String[]args){
        MyDeque<Integer> t = new MyDeque<Integer>();
        t.addFirst(0);
        t.addFirst(-1);
        t.addFirst(-2);
        t.addLast(1);
        t.addLast(2);
        System.out.println(t);
        System.out.println(t.getFirst());
        System.out.println(t.getLast());
    }
}
