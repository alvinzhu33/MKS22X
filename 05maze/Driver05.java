public class Driver05{

    public static void main(String[]args){
	Maze f;
        f = new Maze("data2.dat",true);//true animates the maze.
        
        f.clearTerminal();
        //f.solve();

        //f.clearTerminal();
        System.out.println(f);

	
        /*Maze[] f= new Maze[3];
	for(int i=1; i<4; i++){
	    f[i-1] = new Maze("data"+i+".dat",true);//true animates the maze.
	}

	for(int i=0; i<3; i++){
	    f[i].clearTerminal();
	    f[i].solve();
	    
	    f[i].clearTerminal();
	    System.out.println(f[i]);*/
    }
}
