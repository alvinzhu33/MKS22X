public class Test{
    public static void main(String[]args){
	Recursion r1= new Recursion();

	int[] a1 = new int[50];
	for(int i=0; i<50; i++){
	    a1[i]=i;
	}

	System.out.println(r1.name());

	for(int i=0; i<a1.length; i++){
	    System.out.println(a1[i]+": "+r1.sqrt(a1[i]));
	}
	System.out.println(r1.sqrt(-1));
	System.out.println(r1.sqrt(-1));
	System.out.println(r1.sqrt(-1));
    }
}
