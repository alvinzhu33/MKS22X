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

    public void add(T value){
	Node see=root;
	while(root.getLeft()!=null || root.getRight()!=null){
	    if(value<see.getData()){
		see=see.getLeft();
	    }else{
		see=see.getRight();
	    }
	}
    }
    public String toString(){
	return "hello";
    }
    public boolean contains(T value){
	return false;
    }
    public int getHeight(){
	return 0;
    }
}
