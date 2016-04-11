public class Node<T>{
    Coordinate what;
    Node prev;

    public Node(Coordinate c, Node from){
	what = c;
	prev = from;
    }
    public Coordinate getCoordinate(){
	return what;
    }
    public Node getPrev(){
	return prev;
    }
}
