public class Driver{
    public static void main(String[]args){
	QueenBoard[] boards = new QueenBoard[10];

	for(int x=1; x<11; x++){
	    boards[x-1] = new QueenBoard(x);
	}

	for(int x=0; x<10; x++){
	    System.out.println(x+1+" Queens");
	    boards[x].solve();
	    boards[x].printSolution();
	    System.out.println();
	}
    }
}
