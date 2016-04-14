import java.util.*;
import java.io.*;

public class BetterMaze{
    private class Node{
        private int x,y;
        private Node prev;

        public Node(int x, int y, Node from){
            this.x=x;
            this.y=y;
            prev = from;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public Node getPrev(){
            return prev;
        }
    }

    private char[][] maze;
    private char[][] finalBoard;
    private int startRow,startCol;

    private Frontier<Node> placesToGo;
    private int[] solution;
    private Node e;

    private boolean  animate;

    /**return a COPY of solution.
    *This should be : [x1,y1,x2,y2,x3,y3...]
    *the coordinates of the solution from start to end.
    *Precondition : one of the solveXXX methods has already been
    * called (solveBFS OR solveDFS OR solveAStar)
    *(otherwise an empty array is returned)
    *Postcondition:  the correct solution is in the returned array
    **/
    public int[] solutionCoordinates(){
        Node end = e;
        int count = 0;
        while(end!=null){
            end = end.getPrev();
            count++;
        }

        end=e;
        solution = new int[count*2];
        for(int i=count; i>0; i--){
            solution[i*2-2]=end.getX();
            solution[i*2-1]=end.getY();
            end = end.getPrev();
        }

        return solution;
    }

    public String printSolution(){
        String ans = "[ ";
        //System.out.println(solution.length);
        for(int i=0; i<solution.length; i++){
            ans+= solution[i]+", ";
        }
        ans+= solution[solution.length-2]+"]";
        return ans;
    }

    public void printFinalBoard(){
        for(int i=0; i<solution.length; i+=2){
            finalBoard[solution[i]][solution[i+1]]='.';
        }
        finalBoard[startRow][startCol]='E';

        String board = "";
        for(int i=0; i<maze.length; i++){
            for(int x=0; x<maze[i].length; x++){
                board+=finalBoard[i][x];
            }
            board+='\n';
        }

        System.out.println(board);
    }

    public boolean solveBFS(){
        placesToGo = new FrontierQueue<Node>();
        return solve();
    }

    public boolean solveDFS(){
        placesToGo=new FrontierStack<Node>();
        return solve();
    }

    /**Search for the end of the maze using the frontier.
    Keep going until you find a solution or run out of elements on the frontier.
    **/
    private boolean solve(){
        Node start = new Node(startRow,startCol,null);
        placesToGo.add(start);
        maze[startRow][startCol]='.';
        //int counter=0;
        while(placesToGo.hasNext()){
            Node current = placesToGo.next();
            for(Node n: getNeighbors(current)){
                //System.out.println(counter);
                //wait(300);
                if(n!=null){
                    int x = n.getX();
                    int y = n.getY();
                    if(maze[x][y]=='E'){
                        e = n;
                        solutionCoordinates();
                        return true;
                    }
                    placesToGo.add(n);
                    maze[x][y]='.';
                }
                if(animate){
                    wait(50);
                    System.out.println(this);;
                }
            }
            //System.out.println(counter);
            //counter++;
        }
        return false;
    }

    private Node[] getNeighbors(Node from){
        Node[] ans = new Node[4];

        int x = from.getX();
        int y = from.getY();
        int n=0;
        if(x+1<maze[0].length && maze[x+1][y]!='#' && maze[x+1][y]!='.'){
            ans[n] = new Node(x+1,y,from);
            n++;
        }
        if(x-1<maze[0].length && maze[x-1][y]!='#' && maze[x-1][y]!='.'){
            ans[n] = new Node(x-1,y,from);
            n++;
        }
        if(y+1<maze.length && maze[x][y+1]!='#' && maze[x][y+1]!='.'){
            ans[n] = new Node(x,y+1,from);
            n++;
        }
        if(y-1>=0 && maze[x][y-1]!='#' && maze[x][y-1]!='.'){
            ans[n] = new Node(x,y-1,from);
            n++;
        }
        return ans;
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public BetterMaze(String filename){
        animate = false;
        int maxc = 0;
        int maxr = 0;
        startRow = -1;
        startCol = -1;
        //read the whole maze into a single string first
        String ans = "";
        try{
            Scanner in = new Scanner(new File(filename));

            //keep reading next line
            while(in.hasNext()){
                String line = in.nextLine();
                if(maxr == 0){
                    //calculate width of the maze
                    maxc = line.length();
                }
                //every new line add 1 to the height of the maze
                maxr++;
                ans += line;
            }
        }
        catch(Exception e){
            System.out.println("File: " + filename + " could not be opened.");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println(maxr+" "+maxc);
        maze = new char[maxr][maxc];
        for(int i = 0; i < ans.length(); i++){
            char c = ans.charAt(i);
            maze[i / maxc][i % maxc] = c;
            if(c == 'S'){
                startCol = i % maxc;
                startRow = i / maxc;
            }
        }
        finalBoard=maze;
    }

    //-------------------------------------------------------------
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
        return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
        System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }

    public String toString(){
        int maxr = maze.length;
        int maxc = maze[0].length;
        String ans = "";
        if(animate){
            ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
        }
        for(int i = 0; i < maxc * maxr; i++){
            if(i % maxc == 0 && i != 0){
                ans += color(37,40) + "\n";
            }
            char c =  maze[i / maxc][i % maxc];
            if(c == '#'){
                ans += color(38,47)+c;
            }else{
                ans += color(33,40)+c;
            }
        }

        /*if(e!=null){
            for(int i=0; i<solution.length/2; i++){
                maze[i]
            }
        }*/

        //nice animation string
        if(animate){
            return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
        }else{
            return ans + color(37,40) + "\n";
        }
    }
}
