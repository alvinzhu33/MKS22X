public class QueenBoard{
    private int[][]board;
    
    public QueenBoard(int size){
	if(size<=0){
	    throw new IllegalArgumentException();
	}
	else{
	    board = new int[size][size];
	}
    }

    /**
     *precondition: board is filled with 0's only.
     *postcondition: 
     *-return false, and board is still filled
     *with 0's for a board that cannot be solved.
     *-return true, and board is filled with the 
     *final configuration of the board after adding 
     *all n queens.
     */
    public boolean solve(){
	return solveH(0);
    }

    /**
     *Helper method fr solve. 
     */
    private boolean solveH(int col){
	if(col==board[0].length){
	    return true;
	}
	for(int r=0; r<board.length; r++){
	    if(addQueen(r, col)){
		addQueen(r, col);
		if(solveH(col+1)){
		    return true;
		}
		removeQueen(r, col);
	    }
	}
	return false;
    }

    public void printSolution(){
	/**Print the board like toString, except
	   all negative numbers, and 0's are replaced with '_'
	   and all 1's are replaced with 'Q'
	 */
	String solution="";
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board[r].length; c++){
		if(board[r][c]==1){
		    solution+="Q ";
		}else{
		    solution+="- ";
		}
	    }
	    solution+="\n";
	}
	System.out.println(solution);
    }

    /********Do Not Edit Below This Line**********************************/

    private boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }

    private boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }

    public String  toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		ans+= board[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }

    public String name(){
	return "Zhu,Alvin";
    } 
}
