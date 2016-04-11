public class Node<T>{
    T value;
    Node prev;

    public Node(T v, Node where){
	value = v;
	prev = where;
    }
    public T getValue(){
	return value;
    }
    public Node getPrev(){
	return prev;
    }
}
