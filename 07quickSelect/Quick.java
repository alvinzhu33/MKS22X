import java.util.*;

public class Quick{
    
    //choose a random partition element at a location from left to right inclusive.
    //partition the array such that the randomly chosen element divides all values smaller and larger than it. 
    //smaller elements on the left side of the partition, larger on the right side
    //return the index of the partition element. 
    //this allows your quickselect method to decide where to go next.
    private static int partition(int[]data, int left, int right){
	int k = data[(int)(Math.random()*(right-left+1))+left];
	System.out.println(k);
	int[] copy = new int[right-left+1];

	int start=0;
	int end=copy.length-1;
	int place=left;
	boolean skip = true;
	while(start<end){
	    if(data[place]==k && skip){
		place++;
		skip=false;
	    }
	    if(data[place]>=k){
		copy[end]=data[place];
		end--;
	    }else{
		copy[start]=data[place];
		start++;
	    }
	    place++;
	}
	copy[start]=k;

	for(int i=left; i-left<copy.length; i++){
	    data[i]=copy[i-left];
	}
	
	//System.out.println(Arrays.toString(copy));
	System.out.println(Arrays.toString(data));
	return start+left;
    }
    
    //return the kth smallest value.
    // when k = 0 return the smallest.
    // 0 <= k < data.length
    public static int quickselect(int[]data, int k){
	return 1;
    }
    
    //return the kth smallest value in the given left/right range 
    // left <= k <= right
    //start by calling the helper as follows:
    // quickselect(data,k,0,data.length-1)
    private static int quickselect(int[]data, int k, int left, int right){
	return 1;
    }

    public static void main(String[]args){
	int[] a = new int[] {1,6,2,2,7,4,6};
	int[] b = new int[] {-1,-4,1,5,2,6,2,6,2,2,7,4,6,90,20,60};
	//partition(a,0,6);
	System.out.println(partition(b,2,12));
    }
}
