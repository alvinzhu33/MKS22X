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
    public static int[] easyMerge(int[]aryA, int[]aryB){
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
    }

    public static void merge(int[]data, 
			     int startA, int endA, 
			     int startB, int endB){
	int[] copy = new int[(endA-startA)+1+(endB-startB)+1];

	int aPlace=startA;
	int bPlace=startB;
	int sortPlace=0;

	while(aPlace<=endA && bPlace<=endB){
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
	
	for(int a=aPlace; a<=endA; a++){
	    copy[sortPlace]=data[a];
	    sortPlace++;
	}
	for(int b=bPlace; b<=endB; b++){
	    copy[sortPlace]=data[b];
	    sortPlace++;
	}

	for(int i=startA; i<copy.length; i++){
	    data[i]=copy[i-startA];
	}
	System.out.println(Arrays.toString(data));
    }

    public static void main(String[]args){
	int[] a = new int[] {1,3,5,8,9,60};
	int[] b = new int[] {0,2,3,6,10,22,53};
	int[] c = new int[] {1,3,5,10,2612,2,7,9,10};
	int[] d = new int[] {1,15,261,1,6,2,7,8,10,2,5};
	System.out.println(Arrays.toString(easymerge(a,b)));

	merge(c,0,4,5,8);
	merge(d,3,4,5,8);
    }
}
