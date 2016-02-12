public class Driver{
    public static void main(String[]args){
  	int size = Integer.parseInt(args[0]);
	System.out.println(size);

	KnightBoard kb = new KnightBoard(size);
	
	kb.printSolution();
    }
}
