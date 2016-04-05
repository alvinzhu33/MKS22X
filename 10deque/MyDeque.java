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

        int place=0;
        int index=start;
        while(place<data.length){
            if(index==data.length){
                index=0;
            }
            copy[place]=data[index];
            place++;
            index++;
        }
        start=0;
        end=place-1;

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
        if(data[start]==null){
            throw new NoSuchElementException();
        }
        T ans = data[start];
        data[start]=null;
        if(start==data.length-1){
            start=0;
        }else{
            start++;
        }
        size--;
        return ans;
    }
    public T removeLast(){
        if(data[end]==null){
            throw new NoSuchElementException();
        }
        T ans = data[end];
        data[end]=null;
        if(end==0){
            end = data.length-1;
        }else{
            end--;
        }
        size--;
        return data[end];
    }

    //NoSuchElementException is thrown when there are no elements.
    public T getFirst(){
        if(data[start]==null){
            throw new NoSuchElementException();
        }
        return data[start];
    }
    public T getLast(){
        if(data[end]==null){
            throw new NoSuchElementException();
        }
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

    public static void main(String[]args) {
	    MyDeque<Integer> d = new MyDeque<>();
    	d.addFirst(3);  //3
    	d.addFirst(4);  //4,3
    	System.out.println(d.getFirst());
    	d.addLast(1);   //4,3,1
    	System.out.println(d.getLast());
    	d.addLast(6);  //4,3,1,6
    	System.out.println(d.getLast());
    	d.addFirst(9);  //9,4,3,1,6
    	d.addLast(54);  //9,4,3,1,6,54
    	d.addLast(2);  //9,4,3,1,6,54,2
    	d.addLast(34);  //9,4,3,1,6,54,2,10,44,34
    	d.addFirst(90);  //90,9,4,3,1,6,54,2,10,44,34
        System.out.println(d);
    	d.removeLast();  //90,9,4,3,1,6,54,5,10,44
    	d.removeFirst();  //9,4,3,1,6,54,5,10,44

    	//d.addLast(58);  //9,4,3,1,6,54,5,10,44,34,58
    	System.out.println(d);
        //Thanks for the Driver Anthony (Pd 6)!
    }
}
