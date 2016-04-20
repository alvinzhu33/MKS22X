public class BSTree<T extends Comparable<T>>{
    public class Node{
	T data;
	Node left,right;

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
    }

    Node root;
}
