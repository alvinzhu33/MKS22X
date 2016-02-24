import java.util.Scanner;
import java.io.*;

public class Bronze{
    int[][]board;
    int elevation;
    int[][]operations;

    public Bronze(){
	importFile();
	stomp();
	//print(board);
	dig();
	//print(board);
	answer();
    }
    
    public void importFile(){
	File read = new File("makelake.in");
	try{
	    Scanner scan = new Scanner(read);
	    int row = scan.nextInt();
	    int col = scan.nextInt();
	    elevation = scan.nextInt();
	    int opers = scan.nextInt();

	    board = new int[row][col];
	    for(int r=0; r<row; r++){
		for(int c=0; c<col; c++){
		    board[r][c]=scan.nextInt();
		}
	    }

	    operations = new int[opers][3];
	    for(int o=0; o<opers; o++){
		for(int n=0; n<3; n++){
		    operations[o][n]=scan.nextInt();
		}
	    }

	    scan.close();
	}catch(FileNotFoundException e){
	    System.out.println("No such file");
	}
    }

    public void stomp(){
	for(int n=0; n<operations.length; n++){
	    int R_s = operations[n][0]-1;
	    int C_s = operations[n][1]-1;
	    int D_s = operations[n][2];
	    int peak=0;
	    for(int row=R_s; row<R_s+3; row++){
		for(int col=C_s; col<C_s+3; col++){
		    if(board[row][col]>=peak){
			peak=board[row][col];
		    }
		}
	    }
	    peak-=D_s;
	    for(int row=R_s; row<R_s+3; row++){
		for(int col=C_s; col<C_s+3; col++){
		    if(board[row][col]>=peak){
			board[row][col]=peak;
		    }
		}
	    }
	}
    }

    public void dig(){
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board[r].length; c++){
		board[r][c]=elevation-board[r][c];
		if(board[r][c]<0){
		    board[r][c]=0;
		}
	    }
	}
    }

    public void answer(){
	int n=0;
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board[r].length; c++){
		n+=board[r][c];
	    }
	}
	n=n*72*72;
	System.out.println(n+" cubic inches,6,Zhu,Alvin");
    }
    
    public void print(int[][] a1){
	String print="";
	for(int r=0; r<a1.length; r++){
	    for(int c=0; c<a1[r].length; c++){
		if(a1[r][c]<10){
		    print+=" ";
		}
		print+=a1[r][c]+" ";
	    }
	    print+="\n";
	}
	System.out.println(print);
    }
    
    public static void main(String[]args){
	Bronze b = new Bronze();
    }
}
