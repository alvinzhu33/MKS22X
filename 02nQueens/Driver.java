public class Driver{
    public static void main(String[]args){
	QueenBoard[] boards = new QueenBoard[10];
	QueenBoard[] boards2 = new QueenBoard[10];

	for(int x=1; x<11; x++){
	    boards[x-1] = new QueenBoard(x);
	}
	for(int x=1; x<11; x++){
	    boards2[x-1] = new QueenBoard(x);
	}

	for(int x=0; x<10; x++){
	    System.out.println(x+1+" Queens");
	    boards[x].printSolution();
	    boards2[x].solve();
	    System.out.println(boards2[x]);
	    System.out.println();
	}
    }
}
