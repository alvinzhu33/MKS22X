import java.util.*;

public class RunningMedian{
    private MyHeap<Double> more, less;
    private double median;


    //Create an empty running median set.
    public RunningMedian(){
        more = new MyHeap<Double>(false);
        less = new MyHeap<Double>();
        median = 0;
    }
    //When empty: throws new NoSuchElementException()
    //Returns the median value
    public double getMedian(){
        if(more.size() == 0 && less.size() == 0){
            throw new NoSuchElementException();
        }

        if(more.size() == less.size()){
            double m = more.peek();
            double l = less.peek();
            median = (m+l)/2;
            return median;
        }
        if(more.size() > less.size()){
            median = more.peek();
        }else{
            median = less.peek();
        }
        return median;
    }
    //add to the "SmallValue" heap if  x < median,
    //add to the "BigValue" heap otherwise.
    //balance the two heaps so that their size differ by no more than 1.
    public void add(double x){
        if(x<median){
            less.add(x);
        }else{
            more.add(x);
        }
        double add;
        //System.out.println(more.size());
        //System.out.println(less.size());
        if(more.size()-less.size()>1){
            add = more.delete();
            less.add(add);
        }
        if(less.size()-more.size()>1){
            add = less.delete();
            more.add(add);
        }

        if(more.size()==0 || less.size()==0){
            median = x;
        }else{
            getMedian();
        }
        //System.out.println(more);
        //System.out.println(less);
    }
    public static void main(String[]args){
        RunningMedian r = new RunningMedian();

        r.add(5);
        r.add(10);
        r.add(50);
        r.add(25);
        r.add(-1);
        r.add(-1);
        r.add(-1);
        r.add(-1);
        System.out.println(r.getMedian());
    }
}
