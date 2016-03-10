import java.util.*;

public class Quick{
    
    //choose a random partition element at a location from left to right inclusive.
    //partition the array such that the randomly chosen element divides all values smaller and larger than it. 
    //smaller elements on the left side of the partition, larger on the right side
    //return the index of the partition element. 
    //this allows your quickselect method to decide where to go next.
    private static int partition(int[]data, int left, int right){
	int random = (int)(Math.random()*(right-left+1))+left;
	swap(data,random,right);
	//System.out.println(data[right]);

	int from = left;
	int to = right-1;
	while(from<to){
	    if(data[from]<data[right]){
		from++;
	    }else{
		swap(data,from,to);
		to--;
	    }
	}

	if(data[from]<data[right]){
	    swap(data,from+1,right);
	    //System.out.println(Arrays.toString(data));
	    return from+1;
	}else{
	    swap(data,from,right);
	    //System.out.println(Arrays.toString(data));
	    return from;
	}
    }

    public static void swap(int[]data, int a, int b){
	int store = data[a];
	data[a]=data[b];
	data[b]=store;
    }
    
    //return the kth smallest value.
    // when k = 0 return the smallest.
    // 0 <= k < data.length
    public static int quickselect(int[]data, int k){
	if(partition(data, 0, data.length-1)==k){
	    return data[k];
	}else{
	    return quickselect(data, k, 0, data.length-1);
	}
    }
    
    //return the kth smallest value in the given left/right range 
    // left <= k <= right
    //start by calling the helper as follows:
    // quickselect(data,k,0,data.length-1)
    private static int quickselect(int[]data, int k, int left, int right){
	int place = partition(data,left,right);
	if(place==k){
	    return data[k];
	}else{
	    if(place>k){
		return quickselect(data, k, left, place);
	    }else{
		return quickselect(data, k, place, right);
	    }
	}
    }

    public static String name(){
	return "6,Zhu,Alvin"; //e.g. "7,Kim,Bob"
    }
    
    public static void quickSort(int[]data){
	quickSort(data,0,data.length-1);
    }
    
    private static void quickSort(int[]data,int left,int right){
	if(right-left+1>1){
	    int wall=partition(data,left,right);
	    quickSort(data,left,wall);
	    quickSort(data,wall+1,right);
	}
    }
	
    public static void main(String[]args){
	/*int[] a = new int[] {1,6,2,2,7,4,6};
	int[] b = new int[] {-1,-4,1,5,2,6,2,6,2,2,7,4,6,90,20,60};
	int[] c = {1,6,2,7,4,1,2,7,8,3,6,1,2,7,3,1,2,7,9,3,1};
	int[] d = {216,217,31,37,13,8,2,385,612,3283,424,8423,3};
	int[] e = {1,9,4,3,1,4,3,1,9,4,1,1,3};*/

	/*System.out.println(partition(a,0,6));
	  System.out.println(partition(b,0,b.length-1));*/
	/*System.out.println(quickselect(a,4));
	System.out.println(Arrays.toString(a));
	System.out.println("-----------------");
	System.out.println(quickselect(b,9));
	System.out.println(Arrays.toString(b));
	System.out.println("-----------------");
	System.out.println(quickselect(c,20));
	System.out.println(Arrays.toString(c));
	System.out.println("-----------------");
	System.out.println(quickselect(d,0));
	System.out.println(Arrays.toString(d));
	System.out.println("-----------------");*/

	/*quickSort(a);
	System.out.println(Arrays.toString(a));
	quickSort(b);
	System.out.println(Arrays.toString(b));
	quickSort(c);
	System.out.println(Arrays.toString(c));
	quickSort(d);
	System.out.println(Arrays.toString(d));
	quickSort(e);
	System.out.println(Arrays.toString(e));*/

	int[] testA = new int[4000000];
	for(int i=0; i<4000000; i++){
	    testA[i]=(int)(Math.random()*3)+1;
	}
	quickSort(testA);
    }
}
