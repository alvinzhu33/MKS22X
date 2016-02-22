import java.util.Scanner;
import java.io.*;

public class Bronze{
    int[][]board;
    int row;
    int col;
    int elevation;
    int numOper;

    public Bronze(){
	importFile();
    }
    
    public void importFile(){
	File read = new File("makelake.txt");
	try{
	    Scanner scan = new Scanner(read);
	    row = scan.nextInt();
	    col = scan.nextInt();
	    elevation = scan.nextInt();
	    numOper = scan.nextInt();

	    System.out.println(row);
	    System.out.println(col);
	    System.out.println(elevation);
	    System.out.println(numOper);

	    board = new int[row][col];
	    for(int r=0; r<row; r++){
		for(int c=0; c<col; c++){
		    board[r][c]=scan.nextInt();
		}
	    }

	    scan.close();
	}catch(FileNotFoundException e){
	    System.out.println("No such file");
	}
    }
    
    public static void main(String[]args){
	Bronze b = new Bronze();
    }
}
