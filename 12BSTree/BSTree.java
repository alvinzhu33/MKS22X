import java.util.*;

public class BSTree<T extends Comparable<T>>{
    private class Node{
        T data;
        Node left;
        Node right;

        public Node(){
            data=null;
        }

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
            int counter=0;
            if(left!=null || right!=null){
                return 1;
            }
            return 0;
        }
        public void add(T value){
            if(data==null){
                data=value;
            }else{
                if(value.compareTo(data)<0){
                    if(left==null){
                        setLeft(new Node(value));
                    }else{
                        left.add(value);
                    }
                }else{
                    if(right==null){
                        setRight(new Node(value));
                    }else{
                        right.add(value);
                    }
                }
            }
        }
        public String toString(){
            String l = "_";
            String r = "_";
            if(left!=null){
                l=""+left.toString();
            }
            if(right!=null){
                r=""+right.toString();
            }
            return "|"+data+": "+l+" "+r+"| ";
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
        b.add(0);
        b.add(5);
        b.add(-1);
        b.add(6);
        b.add(4);
        System.out.println(b);
    }
}
