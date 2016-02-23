public class KnightBoard{
    private static boolean DEBUG=true;

    int[][] board;

    public KnightBoard(int s){
	if(s<1){
	    throw new IllegalArgumentException();
	}
	board = new int[s+4][s+4];
	boundary();
    }

    public KnightBoard(int row, int col){
	if(row<1 || col<1){
	    throw new IllegalArgumentException();
	}
	board = new int[row+4][col+4];
	boundary();
    }

    public void boundary(){
	//Makes the -1's
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board[r].length; c++){
		if(r<2 || c<2 || r>board.length-3 || c>board[r].length-3){
		    board[r][c]=-1;
		}else{
		    board[r][c]=0;
		}
	    }
	}
    }

    public boolean addKnight(int c, int row, int col){
	//Adds the knight to the specific area
	if(board[row][col]!=0){
	    return false;
	}
	else{
	    board[row][col]=c;
	    return true;
	}
    }
    
    /*public int[] findNext(int m, int row, int col){
	//Find the possible next areas
	int[] position = new int[2];
	if(m==0){
	    position[0]=row-2;
	    position[1]=col-1;
	}
	if(m==1){
	    position[0]=row-2;
	    position[1]=col+1;
	}
	if(m==2){
	    position[0]=row-1;
	    position[1]=col+2;
	}
	if(m==3){
	    position[0]=row+1;
	    position[1]=col+2;
	}
	if(m==4){
	    position[0]=row+2;
	    position[1]=col+1;
	}
	if(m==5){
	    position[0]=row+2;
	    position[1]=col-1;
	}
	if(m==6){
	    position[0]=row-1;
	    position[0]=col-2;
	}
	if(m==7){
	    position[0]=row+1;
	    position[0]=col-2;
	}
	return position;
	}*/

    public boolean solve(){
	for(int r=2; r<board.length-2;r++){
	    for(int c=2; c<board[r].length-2; c++){
		if(solveH(1,r,c)){
		    return true;
		}
		boundary();
	    }
	}
	return false;
    }

    public boolean solveH(int counter, int row, int col){
	//Checks if the counter is already at the max
	if(counter>=(board.length-4)*(board[0].length-4) &&
	   addKnight(counter,row,col)){
	    return true;
	}
	//Checks if the area is an empty space
	else{
	    if(addKnight(counter,row,col)){
		//NOT loop through all possible areas
		if(solveH(counter+1, row+2, col+1) ||
		   solveH(counter+1, row+2, col-1) ||
		   solveH(counter+1, row+1, col+2) ||
		   solveH(counter+1, row+1, col-2) ||
		   solveH(counter+1, row-1, col+2) ||
		   solveH(counter+1, row-1, col-2) ||
		   solveH(counter+1, row-2, col+1) ||
		   solveH(counter+1, row-2, col-1)){
		    return true;
		}
		else{
		    board[row][col]=0;
		}
	    }
	}
	return false;
    }

    public void printSolution(){
	boolean bigTen = (board.length-4)*(board[0].length-4)>=10;
	String solution="";
	for(int r=2; r<board.length-2; r++){
	    for(int c=2; c<board[r].length-2; c++){
		if(bigTen && board[r][c]<10){
		    solution+=" ";
		}			
		solution+=board[r][c]+" ";
	    }
	    solution+="\n";
	}
	System.out.println(solution);
    }

    private void debug(String s){
	if(DEBUG){
	    System.out.println(s);
	}
    }

    public String name(){
	return "Zhu,Alvin";
    }
}
