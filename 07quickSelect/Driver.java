import java.util.*;

public class Driver{
    public static void main(String[]args){
	/*int[] d = new int [4000000];
	int[] c = new int [d.length];

	for(int i = 0; i < d.length; i++){
	    d[i]= (int)(Math.random()*Integer.MAX_VALUE);
	    c[i]= d[i];
	}
	System.out.println("now sorting");
	Quick.quickSort(d); //or even your old quicksort!!!
	Arrays.sort(c);
	System.out.println("Done: Sorted="+Arrays.equals(d,c));*/
	
	/*int[]a = new int [4000000];//fill with random values from 0 to 3
	  for(int i=0; i<a.length; i++){
	  a[i]=(int)(Math.random()*3);
	  }
	  double startTime=System.currentTimeMillis();
	  Quick.quickSort(a);
	  System.out.println((System.currentTimeMillis()-startTime)/1000.);*/
    
	int[]b = new int [4000000];//fill with random values from 0 to 3
	for(int i=0; i<b.length; i++){
	    b[i]=(int)(Math.random()*Integer.MIN_VALUE);
	    b[i]+=(int)(Math.random()*Integer.MAX_VALUE);
	}
	double startTime=System.currentTimeMillis();
	Quick.quickSort(b);
	System.out.println((System.currentTimeMillis()-startTime)/1000.);
    }
}
