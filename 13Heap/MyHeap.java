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
            while(k*2+1<=size){
                if(data[k*2+1].compareTo(data[k*2])>0){
                    data[k]=data[2*k+1];
                    data[2*k+1]=store;
                    k = 2*k+1;
                }else{
                    data[k]=data[2*k];
                    data[2*k]=store;
                    k = 2*k;
                }
            }
        }else{
            while(k*2+1<=size){
                if(data[k*2+1].compareTo(data[k*2])>0){
                    data[k]=data[2*k];
                    data[2*k]=store;
                    k = 2*k;
                }else{
                    data[k]=data[2*k+1];
                    data[2*k+1]=store;
                    k = 2*k+1;
                }
            }
        }
    }
    private void pushUp(int k){
        T store;

        if(isMax){
            while(k>1 && data[k/2].compareTo(data[k])<0){
                store = data[k];
                data[k] = data[k/2];
                data[k/2] = store;
                k = k/2;
            }
        }else{
            while(k>1 && data[k/2].compareTo(data[k])>0){
                store = data[k];
                data[k] = data[k/2];
                data[k/2] = store;
                k = k/2;
            }
        }
    }
    private void heapify(){
        for(int i=size/2; i>0; i--){
            pushDown(i);
        }
    }
    public T delete(){
        T ans = data[0];
        int counter = 1;
        int k=1;
        data[1]=null;
        pushDown(1);
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

            pushUp(size);
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
        /*a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        System.out.println(a);
        a.delete();
        System.out.println(a);
        System.out.println();*/

        Integer[] intA = {1,2,5,7,4,8,0};
        MyHeap<Integer> b = new MyHeap<>(intA);
        /*System.out.println(b);
        b.delete();
        System.out.println(b);*/
    }
}
