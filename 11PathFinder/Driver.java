public class Driver{
    public static void main(String[]args){
        BetterMaze b = new BetterMaze("data1.dat");
        b.clearTerminal();
        b.setAnimate(true);
        b.solveBFS();
        System.out.println(b);
    }
}
