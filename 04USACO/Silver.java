public class Silver{
    char[][]board;
    int steps;
    int startr,startc,endr,endc;

    public Silver(){
	File read = new File("makelake.in");
	try{
	    Scanner scan = new Scanner(read);
	    int row = scan.nextInt();
	    int col = scan.nextInt();
	    steps = scan.nextInt();
	    
	    board = new int[row][col];
	    for(int r=0; r<row; r++){
		for(int c=0; c<col; c++){
		    board[r][c]=scan.next();
		}
	    }
	    
	    startr=scan.nextInt();
	    startc=scan.nextInt();
	    endr=scan.nextInt();
	    endc=scan.nextInt();
	    
	    scan.close();
	}catch(FileNotFoundException e){
	    System.out.println("No such file");
	}
    }
    
    public void print(){
	System.out.println(",6,Zhu,Alvin");
    }
}
