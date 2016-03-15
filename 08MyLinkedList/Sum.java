public class Sum{
    public static void main(String[]args){
	double sum = 0;
	for(int i=0; i<1000000; i++){
	    double x = Math.random();
	    double y = Math.random();
	    if(x*x + y*y <= 1){
		sum+=1.0;
	    }
	}
	System.out.println(sum/1000000.0);
    }
}
