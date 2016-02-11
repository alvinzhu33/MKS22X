public class KnightBoard{
    private static boolean DEBUG=true;

    int[][] board;

    public KnightBoard(int s){
	board = new int[s+4][s+4];
    }

    public boolean solve(){
	return false;
    }

    public void printSolution(){
	String solution="";
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board.length; c++){
		solution+=board[r][c]+"\t";
	    }
	    solution+="\n";
	}
	System.out.println(solution);
    }

    private boolean solved(){
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board.length; c++){
		if(board[r][c]==0 || board[r][c]==1){
		    return false;
		}
	    }
	}
	return true;
    }

    private void debug(String s){
	if(DEBUG){
	    System.out.println(s);
	}
    }
}
