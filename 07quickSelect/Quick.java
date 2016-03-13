import java.util.*;

public class Quick{

    //Old----------------------------------------------------------
    private static int partitionOld(int[]data, int left, int right){
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

    public static int quickselectOld(int[]data, int k){
	if(partitionOld(data, 0, data.length-1)==k){
	    return data[k];
	}else{
	    return quickselectOld(data, k, 0, data.length-1);
	}
    }
    
    private static int quickselectOld(int[]data, int k, int left, int right){
	int place = partitionOld(data,left,right);
	if(place==k){
	    return data[k];
	}else{
	    if(place>k){
		return quickselectOld(data, k, left, place);
	    }else{
		return quickselectOld(data, k, place, right);
	    }
	}
    }

    public static void quickSortOld(int[]data){
	quickSortOld(data,0,data.length-1);
    }
    
    private static void quickSortOld(int[]data,int left,int right){
	if(right-left+1>1){
	    int wall=partitionOld(data,left,right);
	    quickSortOld(data,left,wall);
	    quickSortOld(data,wall+1,right);
	}
    }
    //End of Old--------------------------------------------------

    public static void swap(int[]data, int a, int b){
	int store = data[a];
	data[a]=data[b];
	data[b]=store;
    }

    private static int[] partition(int[]data, int left, int right){
      int random = (int)(Math.random()*(right-left+1))+left;
      swap(data,random,right);
      //System.out.println(data[right]);

      int pivotCount = 1;
      for(int i=0; i<=right-pivotCount; i++){
         if(data[i]==data[right]){
            if(data[i]!=data[right-pivotCount]){
               swap(data,i,right-pivotCount);
               pivotCount++;
            }else{
               i--;
               pivotCount++;
            }
         }
      }

      int from = left;
      int to = right-pivotCount;
      while(from<to){
         if(data[from]<data[right]){
            from++;
         }else{
            swap(data,from,to);
            to--;
         }
      }

      int[] returning = new int[2];
      if(data[from]<data[right]){
         from++;
         swap(data,from,right);
         //System.out.println(Arrays.toString(data));
      }else{
         swap(data,from,right);
         //System.out.println(Arrays.toString(data));
      }
      returning[0]= from;

      int place=from;
      for(int i=0; i<pivotCount-1; i++){
         place++;
         swap(data,right-i-1,place);
      }
      returning[1]=from+pivotCount-1;

      //System.out.println(Arrays.toString(data));
      return returning;

	/*int[] copy = new int[data.length];
	int compare = data[(int)(Math.random()*(right-left+1))+left];
	//System.out.println(compare);

	int from = left;
	int to = right;
	int pivotCounter = 0;
	for(int i=from; i<copy.length && to>0; i++){
	    if(data[i]<compare){
		copy[from]=data[i];
		from++;
	    }
	    if(data[i]==compare){
		pivotCounter++;
	    }
	    if(data[i]>compare){
		copy[to]=data[i];
		to--;
	    }
	}

	int[] answer = new int[2];
	answer[0]=from;
	for(int i=0; i<pivotCounter; i++){
	    copy[from+i]=compare;
	    answer[1]=from+i;
	}

	for(int i=left; i<=right; i++){
	    data[i]=copy[i];
	}
	System.out.println(Arrays.toString(data));
	return answer;*/
   }

    public static void quickSort(int[]data){
	quickSort(data,0,data.length-1);
    }
    
    private static void quickSort(int[]data,int left,int right){
	if(right-left+1>1){
	    int[] answers=partition(data,left,right);
	    int to=answers[0];
	    int from=answers[1];
	    
	    quickSort(data,left,to);
	    quickSort(data,from,right);
	}
    }
    
    public static String name(){
	return "6,Zhu,Alvin"; //e.g. "7,Kim,Bob"
    }
    
    public static void main(String[]args){
	int[] a = new int[] {1,6,2,2,7,4,6};
	int[] b = new int[] {-1,-4,1,5,2,6,2,6,2,2,7,4,6,90,20,60};
	int[] c = {1,6,2,7,4,1,2,7,8,3,6,1,2,7,3,1,2,7,9,3,1};
	int[] d = {216,217,31,37,13,8,2,385,612,3283,424,8423,3};
	int[] e = {1,9,4,3,1,4,3,1,9,4,1,1,3};

	/*System.out.println(Arrays.toString(partition(a,0,a.length-1)));
	System.out.println(Arrays.toString(partition(b,0,b.length-1)));
	System.out.println(Arrays.toString(partition(c,0,c.length-1)));
	System.out.println(Arrays.toString(partition(d,0,d.length-1)));
	System.out.println(Arrays.toString(partition(e,0,e.length-1)));*/
	quickSort(a);
	System.out.println(Arrays.toString(a));
	System.out.println("-----------------");/*
	quickSort(b);
	System.out.println(Arrays.toString(b));
	System.out.println("-----------------");
	quickSort(c);
	System.out.println(Arrays.toString(c));
	System.out.println("-----------------");
	quickSort(d);
	System.out.println(Arrays.toString(d));
	System.out.println("-----------------");
	quickSort(e);
	System.out.println(Arrays.toString(e));
	System.out.println("-----------------");*/
    }
}
