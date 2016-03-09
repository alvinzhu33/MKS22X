import java.util.*;

public class Quick{
    
    //choose a random partition element at a location from left to right inclusive.
    //partition the array such that the randomly chosen element divides all values smaller and larger than it. 
    //smaller elements on the left side of the partition, larger on the right side
    //return the index of the partition element. 
    //this allows your quickselect method to decide where to go next.
    private static int partition(int[]data, int left, int right){
	int k = data[(int)(Math.random()*(right-left+1))+left];
	//System.out.println(k);
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
	//System.out.println(Arrays.toString(data));
	return start+left;
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
	return "6,Zhu,Alvin";
    }

    public static void main(String[]args){
	int[] a = new int[] {1,6,2,2,7,4,6};
	int[] b = new int[] {-1,-4,1,5,2,6,2,6,2,2,7,4,6,90,20,60};
	int[] c = {1,6,2,7,4,1,2,7,8,3,6,1,2,7,3,1,2,7,9,3,1};
	int[] d = {216,217,31,37,13,8,2,385,612,3283,424,8423,3};
	//System.out.println(partition(a,0,6));
	//System.out.println(partition(b,2,12));
	System.out.println(quickselect(a,4));
	System.out.println(Arrays.toString(a));
	System.out.println("-----------------");
	System.out.println(quickselect(b,9));
	System.out.println(Arrays.toString(b));
	System.out.println("-----------------");
	System.out.println(quickselect(c,15));
	System.out.println(Arrays.toString(c));
	System.out.println("-----------------");
	System.out.println(quickselect(d,0));
	System.out.println(Arrays.toString(d));
	System.out.println("-----------------");
    }
}
