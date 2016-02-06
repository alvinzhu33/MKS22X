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
	try{
	    System.out.println(r1.sqrt(-1));
	}catch(IllegalArgumentException e){
	    System.out.println("-1 can't be squarerooted");
	}
	try{
	    System.out.println(r1.sqrt(-2));
	}catch(IllegalArgumentException e){
	    System.out.println("-2 can't be squarerooted");
	}
	try{
	    System.out.println(r1.sqrt(-100));
	}catch(IllegalArgumentException e){
	    System.out.println("-100 can't be squarerooted");
	}
    }
}
