import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;
    private boolean isMax=true;

    public MyHeap(){
        data = (T[]) new Comparable[9];
        size = 0;
    }
    public MyHeap(T[] array){
        size = array.length;
        data = (T[]) new Comparable[size+1];
        for(int i=1; i<size+1; i++){
            data[i] = array[i-1];
        }
        heapify();
    }
    public MyHeap(boolean isMax){
        data = (T[]) new Comparable[9];
        size = 0;
        this.isMax = isMax;
    }
    public MyHeap(T[] array, boolean isMax){
        size = array.length;
        data = (T[]) new Comparable[size+1];
        for(int i=1; i<size+1; i++){
            data[i]=array[i-1];
        }
        this.isMax = isMax;
        heapify();
    }

    private void pushDown(int k){
        T store = data[k];
        if(isMax){
            if(k*2+1<=size && data[k*2+1].compareTo(data[k*2])>0){
                data[k]=data[2*k+1];
                data[2*k+1]=store;
            }else{
                data[k]=data[2*k];
                data[2*k]=store;
            }
        }else{
            if(k*2+1<=size && data[k*2+1].compareTo(data[k*2])>0){
                data[k]=data[2*k];
                data[2*k]=store;
            }else{
                data[k]=data[2*k+1];
                data[2*k+1]=store;
            }
        }
    }
    private void pushUp(int k){
        T store = data[k];
        data[k] = data[k/2];
        data[k/2] = store;
        //System.out.println(this);
    }
    private void heapify(){
        for(int i=size; i>1; i--){
            int changer = i;
            while(isMax && changer>1 && data[changer/2].compareTo(data[changer])<0){
                pushUp(changer);
                changer = changer/2;
            }
            if(!isMax && data[i/2].compareTo(data[i])>0){
                pushDown(i/2);
            }
        }
    }
    public T delete(){
        T ans = data[0];
        int counter = 1;
        int k=1;
        while(2*k+1<=size){
            pushDown(k);
            if(data[k*2+1].compareTo(data[k*2])>0){
                k = k*2+1;
            }else{
                k = k*2;
            }
        }
        data[k]=null;
        return ans;
    }
    public void add(T x){
        if(size==0){
            data[1]=x;
            size++;
        }else{
            if(size+1>=data.length){
                doubleSize();
            }
            data[size+1]=x;
            size++;

            int index = size;
            while(index>1 && data[index].compareTo(data[index/2])>0){
                pushUp(index);
                index= index/2;
            }
        }
    }
    private void doubleSize(){
        T[] doubled = (T[]) new Comparable[(data.length-1)*2+1];
        for(int i=1; i<size; i++){
            doubled[i] = data[i];
        }
        data = doubled;
    }
    public String toString(){
        String ans = "";
        int row=0;
        int i=1;
        while(i<=size){
            while(i-Math.pow(2,row)<Math.pow(2,row) && i<=size){
                ans+=data[i]+" ";
                i++;
            }
            ans+="\n";
            row++;
        }
        return ans;
    }

    public static void main(String[]args){
        MyHeap<Integer> a = new MyHeap<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        System.out.println(a);
        a.delete();
        System.out.println(a);
        System.out.println();

        Integer[] intA = {1,2,5,7,4,8,0};
        MyHeap<Integer> b = new MyHeap<>(intA);
        System.out.println(b);
        System.out.println(b);
    }
}
