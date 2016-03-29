import java.util.*;

public class MyStack<T>{
    MyLinkedList<T> stack;
    int size=0;

    MyStack(){
	stack = new MyLinkedList<T>();
    }
	
    /**
     * Adds the given item to the top of the stack.
     */
    void push(T item){
	stack.add(item);
	size++;
    }

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */

    T pop(){
	if(stack==null){
	    throw new NoSuchElementException();
	}

	T ans = stack.get(size-1);
	stack.remove(size-1);
	return ans;
    }

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T peek(){
	if(stack==null){
	    throw new NoSuchElementException();
	}
	    
	return stack.get(size-1);
    }

    /**
     * Returns the number of items currently in the stack.
     */
    int size(){
	return size;
    }

    /**
     * Returns whether the stack is empty or not.
     */
    boolean isEmpty(){
	return size==0;
    }

    static boolean isMatching(String s){
	MyStack<Character> stackS = new MyStack<Character>();
	int index=0;
	while(index<s.length()){
	    if(s.charAt(index)=='(' ||
	       s.charAt(index)=='{' ||
	       s.charAt(index)=='[' ||
	       s.charAt(index)=='<'){
		stackS.push(s.charAt(index));
	    }else{
		if(stackS.peek()=='(' && s.charAt(index)==')' ||
		   stackS.peek()=='{' && s.charAt(index)=='}' ||
		   stackS.peek()=='[' && s.charAt(index)==']' ||
		   stackS.peek()=='<' && s.charAt(index)=='>'){
		    stackS.pop();
		}
	    }
	    index++;
	    System.out.println(stackS);
	}
	return true;
    }

    public static void main(String[]args){
	String input = "";
	if(args.length>0){
	    input=args[0];
	}

	System.out.println(isMatching(input));
    }
}
