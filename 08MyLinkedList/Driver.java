import java.util.*;
public class Driver{
    public static void main(String[]args){
	MyLinkedList m = new MyLinkedList();
	ArrayList<Integer> n = new ArrayList<Integer>();

	long start,end;

	start = System.currentTimeMillis();
        //code to test here on ArrayList n
	for(int i=0; i<100000; i++){
	    n.add(i);
	    //n.add(i,i);
	}
	end = System.currentTimeMillis();
	System.out.println("Time: " + (end-start)/1000.0 + " seconds for ArrayList");

	start = System.currentTimeMillis();
        //same code to test here on linked list m
	for(int i=0; i<100000; i++){
	    m.add(i);
	    //m.add(i,i);
	}
	end = System.currentTimeMillis();
	System.out.println("Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");

	//System.out.println(m);
	//System.out.println(n);
    }
}
