public class Recursion implements hw01{
    public String name(){
	return "Zhu,Alvin";
    }

    public double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	if(n==1 || n==0){
	    return n;
	}
        else{
	    return sqrtHelper(n, (n/1 + 1)/2);
	}
    }

    public double sqrtHelper(double n, double guess){
	if((guess*guess-n)/n <= 0.000000000000001){
	    return guess;
	}
	else{
	    return sqrtHelper(n, (n/guess + guess)/2);
	}
    }
}
