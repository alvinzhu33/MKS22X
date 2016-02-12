public class KnightBoard{
    private static boolean DEBUG=true;

    int[][] board;

    public KnightBoard(int s){
	board = new int[s+4][s+4];
	boundary();
    }

    public void boundary(){
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board.length; c++){
		if(r<2 || c<2 || r>board.length-3 || c>board.length-3){
		    board[r][c]=-1;
		}
	    }
	}
    }

    public boolean addKnight(int c, int row, int col){
	if(board[row][col]!=0){
	    return false;
	}
	else{
	    board[row][col]=c;
	    return true;
	}
    }
    
    public int[] findNext(int m, int row, int col){
	/*if(m%2==0){
	    if(m/2==0){
		if(board[row-2][col+1]==0){
		    board[row-2][col+1]=board[row][col]+1;
		    return true;
		}
	    }
	    if(m/2==1){
		if(board[row+1][col+2]==0){
		    board[row+1][col+2]=board[row][col]+1;
		    return true;
		}
	    }
	    if(m/2==2){
		if(board[row+2][col-1]==0){
		    board[row+2][col-1]=board[row][col]+1;
		    return true;
		}
	    }
	    if(m/2==3){
		if(board[row-1][col-2]==0){
		    board[row-1][col-2]=board[row][col]+1;
		    return true;
		}
	    }
	    }*/
	int[] position = new int[2];
	if(m%2==0){
	    if(m/2==0){
		position[0]=row-2;
		position[1]=col+1;
	    }
	    if(m/2==1){
		position[0]=row+1;
		position[1]=col+2;
	    }
	    if(m/2==2){
		position[0]=row+2;
		position[1]=col-1;
	    }
	    if(m/2==3){
		position[0]=row-1;
		position[0]=col-2;
	    }
	}
	if(m/2==0){
	    position[0]=row-2;
	    position[1]=col-1;
	}
	if(m/2==1){
	    position[0]=row-1;
	    position[1]=col+2;
	    }
	if(m/2==2){
	    position[0]=row+2;
	    position[1]=col+1;
	    }
	if(m/2==3){
	    position[0]=row+1;
	    position[0]=col-2;
	}
	return position;
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
