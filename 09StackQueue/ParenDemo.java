import java.util.*;

public class ParenDemo{
    static boolean isMatching(String s){
	MyStack<Character> stackS = new MyStack<Character>();
	int index=0;
	//for(char next : s.toCharArray()){;}
	while(index<s.length()){
	    if(s.charAt(index)=='(' ||
	       s.charAt(index)=='{' ||
	       s.charAt(index)=='[' ||
	       s.charAt(index)=='<'){
		stackS.push(s.charAt(index));
	    }else{
		try{
		    if(stackS.peek()=='(' && s.charAt(index)==')' ||
		       stackS.peek()=='{' && s.charAt(index)=='}' ||
		       stackS.peek()=='[' && s.charAt(index)==']' ||
		       stackS.peek()=='<' && s.charAt(index)=='>'){
			stackS.pop();
		    }
		}catch(NoSuchElementException e){
		    return false;
		}
	    }
	    index++;
	}
	return stackS.isEmpty();
    }

    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println( isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
    }

    /*public static void main(String[]args){
	System.out.println(isMatching("[ ( { } ) ]"));
	System.out.println(isMatching("[FISHIES]"));
	System.out.println(isMatching("[FISH(I)ES]"));
	System.out.println(isMatching("[FISHIES][][][]"));
	System.out.println(isMatching("({ )}"));
	System.out.println(isMatching("[({"));
	System.out.println(isMatching(")[ ( { } ) ]"));
	System.out.println(isMatching("({ }) (]"));
	System.out.println(isMatching("[({})}"));
	}*/
}
