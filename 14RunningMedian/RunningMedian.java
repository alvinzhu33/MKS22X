public class RunningMedian{
    private MyHeap more, less;
    private double median;
    
    
    //Create an empty running median set.
    public RunningMedian(){
	more = new MyHeap<Integer>(false);
	less = new MyHeap<Integer>();
	median = 0;
    }
    //When empty: throws new NoSuchElementException()
    //Returns the median value
    public double getMedian(){
	if(more.size() == 0 && less.size() == 0){
	    throw new NoSuchElementException();
	}

	if(more.size() == less.size()){
	    return (more.peak() + less.peak())/2;
	}
	if(more.size() > less.size()){
	    return less.peak();
	}else{
	    return more.peak();
	}
    }
    //add to the "SmallValue" heap if  x < median, 
    //add to the "BigValue" heap otherwise. 
    //balance the two heaps so that their size differ by no more than 1. 
    public void add(Integer x){
	if(x<getMedian()){
	    less.add(x);
	}else{
	    more.add(x);
	}
	if(more.size()-less.size()>1){
	    less.add(more.delete());
	}
	if(less.size()-more.size()>1){
	    more.add(less.delete());
	}
    }

    public static void main(String[]args){
	RunningMedian r = new RunningMedian();
    }
}
