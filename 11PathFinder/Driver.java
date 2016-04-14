import java.util.*;

public class Driver{
    public static void main(String[]args){
        BetterMaze maze = new BetterMaze("data5.dat");

        maze.clearTerminal();
        maze.setAnimate(true);
        if(args.length>0){
            maze.solveBFS();
        }else{
            maze.solveDFS();
        }
        maze.solutionCoordinates();
        //System.out.println(maze.printSolution());

        /*BetterMaze b = new BetterMaze("data2.dat");

        b.clearTerminal();
        b.setAnimate(true);
        b.solveBFS();
        System.out.println(b);
        System.out.println(b.printSolution());
        System.out.println(b.solutionCoordinates());*/

        /*BetterMaze d = new BetterMaze("data2.dat");

        d.clearTerminal();
        d.setAnimate(true);
        d.solveDFS();
        System.out.println(d);
        System.out.println(d.printSolution());
        System.out.println(d.solutionCoordinates());*/
    }
}
