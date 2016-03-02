import java.util.*;

public class Merge{
    public static int[] merge(int[]aryA, int[]aryB){
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

    public static void main(String[]args){
	int[] a = new int[] {1,3,5,8,9,60};
	int[] b = new int[] {0,2,3,6,10,22,53};
	merge(a,b);
    }
}
