import java.util.*;

public class Sorts{
    public static void printArray(int[]data){
	String show="[ "+data[0];
	for(int i=1; i<data.length; i++){
	    show+=", "+data[i];
	}
	show+="]";
	System.out.println(show);
	//print the array like:  [ 1, 2, 3, 4]
    }

    public static int getIndex(int[] data, int value){
	int i=1;
	if(value<data[0]){
	    return 0;
	}
	/*for(; i<data.length;){
	  while(value>data[i]){
	  i+=1;
	  }
	  }*/
	while(value>data[i] && i<data.length && data[i]!=0){
	    i+=1;
	}
	return i;
    }

    public static int[] add(int[] data, int value){
	int index= getIndex(data, value);
	int[] copy = new int[data.length];
	if(index==data.length){
	    for(int i=0; i<data.length; i++){
		copy[i]=data[i];
	    }
	    copy[copy.length-1]=value;
	}
	for(int i=0; i<data.length; i++){
	    if(i<index){
		copy[i]=data[i];
	    }
	    if(i==index){
		copy[i]=value;
	    }
	    if(i>index){
		copy[i]=data[i-1];
	    }
	}
	return copy;
    }
    
    //----------------------------------------------------------------
    //Insertion Sort
    public static void insertionSort(int[]data){
	for(int index=1; index<data.length; index++){
	    int value=data[index];
	    int swapIndex =index;
	    while(swapIndex>0 && data[swapIndex-1]>value){
		data[swapIndex]=data[swapIndex-1];
		swapIndex--;
	    }
	    data[swapIndex]=value;
	    //printArray(data);
	}
    }
    
    public static void fillRandom(int[] data){
	for(int x=0; x<data.length; x++){
	    int pm = (int)Math.pow(-1,(int)Math.random()*2);
	    data[x]= pm*(int)(Math.random()*Integer.MAX_VALUE);
	}
    }

    //------------------------------------------------------------------
    //Selection Sort
    public static void selectionSort(int[] data){
	for(int index=0; index<data.length; index++){
	    int next=data[index];
	    int storeValue=data[index];
	    int storeIndex=-1;
	    for(int searcher=index; searcher<data.length; searcher++){
		if(data[searcher]<=next){
		    next=data[searcher];
		    storeIndex=searcher;
		}
	    }
	    data[index]=next;
	    data[storeIndex]=storeValue;
	    //printArray(data);
	}
    }

    //---------------------------------------------------------------------
    //Bubble Sort
    public static void bubbleSort(int[]data){
	for(int place=1; place<data.length; place++){
	    int index=1;
	    while(index+place<=data.length){
		int storeValue=data[index-1];
		if(data[index-1]>data[index]){
		    data[index-1]=data[index];
		    data[index]=storeValue;
		}
		index++;
	    }
	    //printArray(data);
	}
    }

    //----------------------------------------------------------------
    //Merge Sort
    
    /*public static int[] easyMerge(int[]aryA, int[]aryB){
	int[] sort = new int[aryA.length+aryB.length];
	int aPlace=0;
	int bPlace=0;
	int sortPlace=0;
	while(aPlace<aryA.length && bPlace<aryB.length){
	    if(aryA[aPlace]<=aryB[bPlace]){
		sort[sortPlace]=aryA[aPlace];
		aPlace++;
		sortPlace++;
	    }else{
		sort[sortPlace]=aryB[bPlace];
		bPlace++;
		sortPlace++;
	    }
	}
	for(int a=aPlace; a<aryA.length; a++){
	    sort[sortPlace]=aryA[a];
	    sortPlace++;
	}
	for(int b=bPlace; b<aryB.length; b++){
	    sort[sortPlace]=aryB[b];
	    sortPlace++;
	}
	return sort;
	}*/

    public static void mergesort(int[]data){
	mergesortHelper(data, 0, data.length);
	printArray(data);
    }
    
    public static void mergesortHelper(int[] data ,int start,int end){
	for(int i=start; i<end; i+=2){
	    merge(data,i,i,i+1,i+1);
	}
	for(int i=start; i<end; i+=4){
	    merge(data,i,i+1,i+2,i+3);
	}
	for(int i=start; i<end; i+=8){
	    merge(data,i,i+3,i+4,i+7);
	}
	for(int i=start; i<end; i+=16){
	    merge(data,i,i+7,i+8,i+15);
	}
	for(int i=start; i<end; i+=32){
	    merge(data,i,i+15,i+16,i+31);
	}
	if(data.length>32){
	    for(int i=start; i<end; i+=64){
		merge(data,i,i+31,i+32,i+63);
	    }
	    for(int i=start; i<end; i+=128){
		merge(data,i,i+63,i+64,i+127);
	    }
	    for(int i=start; i<end; i+=256){
		merge(data,i,i+127,i+128,i+255);
	    }
	}
    } 
    
    public static void merge(int[]data, 
			     int startA, int endA, 
			     int startB, int endB){
	int[] copy = new int[(endA-startA)+1+(endB-startB)+1];

	int aPlace=startA;
	int bPlace=startB;
	int sortPlace=0;

	while(aPlace<=endA && bPlace<=endB && bPlace<data.length){
	    if(data[aPlace]<=data[bPlace]){
		copy[sortPlace]=data[aPlace];
		aPlace++;
		sortPlace++;
	    }else{
		copy[sortPlace]=data[bPlace];
		bPlace++;
		sortPlace++;
	    }
	}
	
	for(int a=aPlace; a<=endA && a<data.length; a++){
	    copy[sortPlace]=data[a];
	    sortPlace++;
	}
	for(int b=bPlace; b<=endB && b<data.length; b++){
	    copy[sortPlace]=data[b];
	    sortPlace++;
	}
	
	for(int i=0; i<copy.length && i+startA<data.length; i++){
	    data[i+startA]=copy[i];
	}

	//System.out.println(Arrays.toString(copy));
	//System.out.println(Arrays.toString(data));
	//System.out.println("---------");
    }

    public static String name(){
	return "6,Zhu,Alvin";
    }

    /*public static void main(String[]args){
	int[] a = new int[] {6,5,2,7,2,13,8,31,3,78,4,23,78,32};
	int[] b = new int[] {2,6,27,2,1,0,2};
	int[] c = new int[] {1,2,3,4,5,6,11,8};
	int[] d = new int[] {1,15,261,1,6,2,7,8,10,2,5};
	mergesort(a);
	mergesort(b);
	mergesort(c);
	mergesort(d);
	System.out.println(name());
	}*/
}
