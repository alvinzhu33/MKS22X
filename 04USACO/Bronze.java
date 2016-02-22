import java.util.Scanner;
import java.io.*;

public class Bronze{
    public static void main(String[]args) throws IOException{
	File read = new File("makelake.txt");
	Scanner scan = new Scanner(read);
	while(scan.hasNextLine()){
	    System.out.println(scan.nextLine());
	}
	scan.close();
    }
}
