import java.util.*;

public class Merge{
    public static int[] easymerge(int[]aryA, int[]aryB){
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

    public static void merge(int[]data, int startA, int endA, int startB, int endB){
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
	System.out.println(Arrays.toString(copy));
    }

    public static void main(String[]args){
	int[] a = new int[] {1,3,5,8,9,60};
	int[] b = new int[] {0,2,3,6,10,22,53};
	int[] c = new int[] {1,3,5,10,2612,2,7,9,10};
	easymerge(a,b);

	merge(c,0,4,5,8);
    }
}
