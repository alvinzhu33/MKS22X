import java.util.Scanner;
import java.io.*;

public class Silver{
    int[][]board;
    int steps;
    int startr,startc,endr,endc;

    public Silver(){
	File read = new File("ctravel1.in");
	try{
	    Scanner scan = new Scanner(read);
	    int row = scan.nextInt();
	    int col = scan.nextInt();
	    steps = scan.nextInt();
	    
	    board = new int[row][col];
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
	}catch(FileNotFoundException e){
	    System.out.println("No such file");
	}
    }

    public boolean solve(){
	start();
	for(int step=1; step<steps; step++){
	    for(int r=0; r<board.length; r++){
		if(board[r][0]==0){
		    for(int c=0; c<board[r].length; c+=2){
			change(r,c);
		    }
		    for(int c=1; c<board[r].length; c+=2){
			change(r,c);
		    }
		}else{
		    for(int c=1; c<board[r].length; c+=2){
			change(r,c);
		    }
		    for(int c=0; c<board[r].length; c+=2){
			change(r,c);
		    }
		}
	    }
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
	if(board[row][col]>-1){
	    board[row][col]=0;
	}else{
	    if(board[row][col]!=-1){
		if(row-1>0 && board[row-1][col]!=-1){
		    board[row][col]+=board[row-1][col];
		}
		if(row+1<board.length && board[row+1][col]!=-1){
		    board[row][col]+=board[row+1][col];
		}
		if(col-1>0 && board[row-1][col]!=-1){
		    board[row][col]+=board[row][col-1];
		}if(col+1<board[0].length && board[row][col+1]!=-1){
		    board[row][col]+=board[row-1][col];
		}
	    }
	}
    }
    
    public void print(){
	String print="";
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board[r].length; c++){
		if(board[r][c]<10 && board[r][c]>=0){
		    print+=" ";
		}
		print+=board[r][c]+" ";
	    }
	    print+="\n";
	}
	System.out.println(print);
    }

    public static void main(String[]args){
	Silver s1 = new Silver();
	s1.print();
	s1.solve();
	s1.print();
    }
}
