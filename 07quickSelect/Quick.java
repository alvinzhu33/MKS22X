import java.util.*;

public class Quick{
    
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

    public static int quickselect(int[]data, int k){
	if(partition(data, 0, data.length-1)==k){
	    return data[k];
	}else{
	    return quickselect(data, k, 0, data.length-1);
	}
    }
    
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
	System.out.println("Hi!");
    }
}
