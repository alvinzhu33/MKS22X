public class Driver{
    public static void main(String[]args){
	BetterMaze b = new BetterMaze("data1.dat");
	b.setAnimate(true);
	if(args.size()>0){
	    b.solveDFS();
	}else{
	    b.solveBFS();
	}
	System.out.println(b);
    }
}
