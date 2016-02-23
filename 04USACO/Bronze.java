import java.util.Scanner;
import java.io.*;

public class Bronze{
    int[][]board;
    int elevation;
    int[][]operations;

    public Bronze(){
	importFile();
	/*print(board);
	print(operations);
	System.out.println(elevation);*/
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
    
    public void importFile(){
	File read = new File("makelake.txt");
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
    
    public static void main(String[]args){
	Bronze b = new Bronze();
    }
}
