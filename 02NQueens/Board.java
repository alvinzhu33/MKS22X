import java.util.*;

public class Board{
    int[][] board;
    
    public Board(int n){
	board = new int[n][n];
	for(int x=0; x<n; x++){
	    for(int y=0; y<n; y++){
		board[x][y]=0;
	    }
	}
    }

    public boolean addQ(int row, int col){
	if(board[row][col]==0){
	    board[row][col]=1;
	    Qterritory(row, col, 1);
	    return true;
	}else{
	    return false;
	}
    }

    public boolean minusQ(int row, int col){
	if(board[row][col]==1){
	    board[row][col]=0;
	    Qterritory(row, col, -1);
	    return true;
	}
	return false;
    }

    public void Qterritory(int row, int col, int change){
	int c=col+1;
	for(int r=row-1; r>0; row--){
	    board[r][c]+=change;
	    c++;
	}
	int c=col+1;
	for(int r=row+1; r<board.length; r++){
	    board[r][c]+=change;
	    c++;
	}
	for(int c=col+1; c<board[0].length; c++){
	    board[r][c]+=change;
	}
    }

    public void solve(){
	System.out.println(Arrays.toString(board));
    }

    public void print(){
	for(int x=0; x<board.length; x++){
	    System.out.println(Arrays.toString(board[x]));
	}
    }
}
