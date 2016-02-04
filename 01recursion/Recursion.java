public class Recursion implements hw01{
    public String name(){
	return "Zhu,Alvin";
    }

    public double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
        else{
	    return sqrtHelp(n, (n/3 + 3)/2);
	}
    }

    public double sqrtHelper(double n, double guess){
	if((guess-n)/n <= 0.0000001){
	    return guess;
	}
	else{
	    return sqrtHelper(n, (n/guess + guess)/2);
	}
    }
}
