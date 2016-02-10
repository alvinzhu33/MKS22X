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

    public void solve(){
	System.out.println(Arrays.toString(board));
    }

    public void print(){
	for(int x=0; x<board.length; x++){
	    System.out.println(Arrays.toString(board[x]));
	}
    }
}
