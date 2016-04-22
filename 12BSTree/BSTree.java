import java.util.*;

public class BSTree<T extends Comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;

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
	    /*if(value.compareTo(data)<0){
		left = new Node(value);
	    }
	    if(value.compareTo(data)>0){
		right = new Node(value);
	    }

	    Node check=root;
	    Node added=root;
	    while(check.height()!=0){
		if(value.compareTo(check.getData())<0){
		    check=check.getLeft(); 
		}else{
		    check=check.getRight();
		}
	    }
	    if(value.compareTo(check.getData())<0){
		check.setLeft(new Node(value));
	    }else{
		check.setRight(new Node(value));
	    }
	    root=check;
	    System.out.println(root);*/
	    if(height()==0){
		data=value;
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
	    return ""+data+":| "+l+" "+r+"| ";
	}
	public boolean contains(T value){
	    return data==value;
	}
     
    }

    private Node root;

    public BSTree(){
	root=new Node();
    }

    //OUTER methods here are wrapper methods for the root
    public int getHeight(){
	//call the root's methods
	//check for empty first!
	return root.height();
    }

    public void add(T value){
	root.add(value);
    }
    public String toString(){
	//check for empty before you do things with root.
	return root.toString();
    }
    public boolean contains(T value){
	//check for empty before you do things with root.
	return false;
    }

    public static void main(String[]args){
	BSTree<Integer> b= new BSTree<Integer>();
	b.add(1);
	System.out.println(b);
	//b.add(0);
	//b.add(5);
	//b.add(-1);
    }
}
