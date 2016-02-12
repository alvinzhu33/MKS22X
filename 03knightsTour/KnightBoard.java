public class KnightBoard{
    private static boolean DEBUG=true;

    int[][] board;

    public KnightBoard(int s){
	board = new int[s+4][s+4];
	boundary();
    }

    public KnightBoard(int row, int col){
	board = new int[row+4][col+4];
	boundary();
    }

    public void boundary(){
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board[r].length; c++){
		if(r<2 || c<2 || r>board.length-3 || c>board[r].length-3){
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
	for(int r=2; r<board.length-3;r++){
	    for(int c=2; c<board[r].length-3; c++){
		return solveH(0,r,c);
	    }
	}
	return false;
    }

    public boolean solveH(int counter, int row, int col){
	printSolution();
	if(counter>board.length*board.length){
	    return true;
	}
	else{
	    for(int x=0; x<8; x++){
		int r = findNext(x, row, col)[0];
		int c = findNext(x, row, col)[1];
		if(addKnight(counter,r,c)){
		    return solveH(counter+1,r,c);
		}
	    }
	    return false;
	}
    }

    public void printSolution(){
	String solution="";
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board[r].length; c++){
		solution+=board[r][c]+"\t";
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
