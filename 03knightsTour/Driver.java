public class Driver{
    public static void main(String[]args){
	KnightBoard kb;
	if(args.length==1){
	    kb = new KnightBoard(Integer.parseInt(args[0]));
	}
	else{
	    kb = new KnightBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	}
	
	System.out.println(kb.solve());
    }
}
