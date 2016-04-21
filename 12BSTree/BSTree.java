import java.util.*;

public class BSTree<T extends Comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;

	public Node(T value){
	    data=value;
	}

	public T getData(){
	    return data;
	}
	public Node getLeft(){
	    return left;
	}
	public Node getRight(){
	    return right;
	}

	public void setData(T value){
	    data=value;
	}
	public void setLeft(Node l){
	    left=l;
	}
	public void setRight(Node r){
	    right=r;
	}

	public int height(){ 
	    if(left!=null || right!=null){
		return 1;
	    }
	    return 0;
	}
	public void add(T value){
	    if(value.compareTo(data)<0){
		left = new Node(value);
	    }
	    if(value.compareTo(data)>0){
		right = new Node(value);
	    }
	}
	public String toString(){
	    String l = "_";
	    String r = "_";
	    if(left!=null){
		l=""+left;
	    }
	    if(right!=null){
		r=""+right;
	    }
	    return ""+data+":|"+l+" "+r+"| ";
	}
	public boolean contains(T value){
	    return data==value;
	}
     
    }

    private Node root;

    //OUTER methods here are wrapper methods for the root
    public int getHeight(){
	//call the root's methods
	//check for empty first!
	return root.height();
    }

    public void add(T value){
	//check for empty before you do things with root.
	if(root==null){
	    root=new Node(value);
	}
	System.out.println(root);
    }
    public String toString(){
	//check for empty before you do things with root.
	return "";
    }
    public boolean contains(T value){
	//check for empty before you do things with root.
	return false;
    }

    public static void main(String[]args){
	BSTree<Integer> b= new BSTree<Integer>();
	b.add(1);
    }
}
