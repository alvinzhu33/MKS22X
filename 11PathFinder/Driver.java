import java.util.*;

public class Driver{
    public static void main(String[]args){
        BetterMaze b = new BetterMaze("data2.dat");
        BetterMaze d = new BetterMaze("data2.dat");

        b.clearTerminal();
        b.setAnimate(true);
        b.solveBFS();
        System.out.println(b);

        d.clearTerminal();
        d.setAnimate(true);
        d.solveDFS();
        System.out.println(d);
        //d.printFinalBoard();

        //System.out.println(b.startRow);
        //System.out.println(b.startCol);

        System.out.println(b.printSolution());
        /*System.out.println(d.printSolution());
        System.out.println(b.solutionCoordinates());*/
    }
}
