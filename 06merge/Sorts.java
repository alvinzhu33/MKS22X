public class Sorts{
    public static void printArray(int[]data){
      String show="[ "+data[0];
      for(int i=1; i<data.length; i++){
         show+=", "+data[i];
      }
      show+="]";
      System.out.println(show);
   }

   public static int getIndex(int[] data, int value){
      int i=1;
      if(value<data[0]){
         return 0;
      }
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

    //My Code
    
    /*public static void insertionSort(int[]data){
      int[] copy= new int[data.length];
      copy[0]=data[0];
      if(data[1]<=copy[0]){
         copy[1]=copy[0];
         copy[0]=data[1];
      }
      else{
         copy[1]=data[1];
      }
      for(int i=2; i<data.length; i++){
         copy=add(copy, data[i]);
      }
      for(int i=0; i<copy.length; i++){
         data[i]=copy[i];
      }
      //your code here to make data re-order its elements
      //from least to greatest just like we did in class
      //same algorithm as the way you created your OrderedSuperArray
      }*/

    /*public static void fillRandom(int[] data){
	for(int i=0; i<data.length; i++){
	    int sign=(int)Math.pow(-1, (int)(Math.random()*2));
	    data[i]= sign*(int)(Math.random()*Integer.MAX_VALUE);
	    //Integer is a class
	    //MAX_VALUE is a public, static, and final variable
	}
	}*/

    //------------------------------------------------------------
    //InsertionSort
    public static void insertionSort(int[] data){
	for(int i=1; i<data.length; i++){
	    int current=data[i];
	    int j =i;
	    while(j>0 && data[j-1]>current){
		data[j]=data[j-1];
		j--;
	    }
	    data[j]=current;
	}
    }


    //---------------------------------------------------------------
    //SelectionSort
    public static void selectionSort(int[] data){
	int[] newSorted = new int[data.length];
	for
    }

    //----------------------------------------------------------------
    //MergeSort
}
