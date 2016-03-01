import java.util.*;
import java.io.*;

public class Silver{
    int[][]board;
    int[][]copy;
    int steps;
    int startr,startc,endr,endc;

    public Silver(){
	File read = new File("ctravel2.in");
	try{
	    Scanner scan = new Scanner(read);
	    int row = scan.nextInt();
	    int col = scan.nextInt();
	    steps = scan.nextInt();
	    
	    board = new int[row][col];
	    copy = new int[row][col];
	    for(int r=0; r<row; r++){
		String line = scan.next();
		for(int c=0; c<col; c++){
		    if(line.charAt(c)=='.'){
			board[r][c]=0;
		    }else{
			board[r][c]=-1;
		    }
		}
	    }
	    
	    startr=scan.nextInt()-1;
	    startc=scan.nextInt()-1;
	    endr=scan.nextInt()-1;
	    endc=scan.nextInt()-1;
	    
	    scan.close();
	    makeCopy();
	}catch(FileNotFoundException e){
	    System.out.println("No such file");
	}
    }

    public void makeCopy(){
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board[r].length; c++){
		copy[r][c]=board[r][c];
	    }
	}
    }

    public boolean solve(){
	start();
	for(int step=1; step<steps+1; step++){
	    for(int r=0; r<board.length; r++){
		for(int c=0; c<board[r].length; c++){
		    change(r,c);
		}
	    }
	    makeCopy();
	}
	System.out.println(board[endr][endc]+",6,Zhu,Alvin");
	return true;
    }

    public void start(){
	if(startr-1>=0 && board[startr-1][startc]!=-1){
	    board[startr-1][startc]=1;
	}
	if(startr+1<board.length && board[startr+1][startc]!=-1){
	    board[startr+1][startc]=1;
	}
	if(startc-1>=0 && board[startr][startc-1]!=-1){
	    board[startr][startc-1]=1;
	}
	if(startc+1<board[0].length && board[startr][startc+1]!=-1){
	    board[startr][startc+1]=1;
	}
    }

    public void change(int row, int col){
	if(board[row][col]>0 && copy[row][col]>0){
	    if(row-1>=0 && board[row-1][col]!=-1){
		board[row-1][col]+=board[row][col];
	    }
	    if(row+1<board.length && board[row+1][col]!=-1){
		board[row+1][col]+=board[row][col];
	    }
	    if(col-1>=0 && board[row][col-1]!=-1){
		board[row][col-1]+=board[row][col];
		}
	    if(col+1<board[0].length && board[row][col+1]!=-1){
		board[row][col+1]+=board[row][col];
	    }
	    board[row][col]=0;
	}
    }
    
    public void print(){
	String print="";
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board[r].length; c++){
		if(board[r][c]<10 && board[r][c]>=0){
		    print+=" ";
		}
		print+=board[r][c]+"\t";
	    }
	    print+="\n";
	}
	System.out.println(print);
    }

    public static void main(String[]args){
	Silver s1 = new Silver();
	s1.solve();
    }
}
