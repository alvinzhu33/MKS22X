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
    if(size==data.length){
      grow();
    }
    if(start==0 && data[start]!=null){
      start=data.length-1;
    }else{
      start--;
    }
    data[start]=value;
    size++;
  };
  public void addLast(T value){
    if(size==data.length){
      grow();
    }
    if(end==data.length-1){
      end=0;
    }else{
      end++;
    }
    data[end]=value;
    size++;
  }

  //NoSuchElementException is thrown when there are no elements.
  public T removeFirst(){
    return (T)data[start];
  }
  public T removeLast(){
    return (T)data[end];
  }

  //NoSuchElementException is thrown when there are no elements.
  public T getFirst(){
    return (T)data[start];
  }
  public T getLast(){
    return (T)data[end];
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
  }
}
