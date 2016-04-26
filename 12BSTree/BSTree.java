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
            if(data==null){
                return 0;
            }else{
                return height(1);
            }
        }

        public int height(int counter){
            if(left==null && right==null){
                return counter;
            }
            if(right==null){
                return left.height(counter+1);
            }
            if(left==null){
                return right.height(counter+1);
            }
            int rightC = right.height(counter+1);
            int leftC = left.height(counter+1);
            if(rightC>leftC){
                return rightC;
            }else{
                return leftC;
            }
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
            if(data==value){
                return true;
            }else{
                if(value.compareTo(getData())<0){
                    if(left!=null){
                        return left.contains(value);
                    }
                }else{
                    if(right!=null){
                        return right.contains(value);
                    }
                }
            }
            return false;
        }
        public T remove(T value){
            if(data==null){
                throw new IllegalArgumentException();
            }
            if(value==left.getData()){
                Node leftD = left.getLeft();
                Node rightD = left.getRight();
                if(leftD.height()>rightD.height()){
                    setLeft(leftD);
                }else{
                    setLeft(rightD);
                }
                return value;
            }
            if(value==right.getData()){
                Node leftD = right.getLeft();
                Node rightD = right.getRight();
                if(leftD.height()>rightD.height()){
                    setRight(leftD);
                }else{
                    setRight(rightD);
                }
                return value;
            }
            if(value.compareTo(data)<0){
                return left.remove(value);
            }else{
                return right.remove(value);
            }
        }
    }

    private Node root;

    public BSTree(){
        root = new Node();
    }

    //OUTER methods here are wrapper methods for the root
    public int getHeight(){
        if(root.getData()==null){
            return 0;
        }
        return root.height();
    }

    public void add(T value){
        root.add(value);
    }
    public String toString(){
        if(root.getData()==null){
            return "";
        }
        return root.toString();
    }
    public boolean contains(T value){
        if(root.getData()==null){
            return false;
        }
        return root.contains(value);
    }
    public T remove(T value){
        return root.remove(value);
    }

    public static void main(String[]args){
        BSTree<Integer> b= new BSTree<Integer>();
        System.out.println(b);
        b.add(1);
        b.add(0);
        b.add(5);
        b.add(-1);
        b.add(6);
        b.add(4);
        b.add(7);
        b.add(8);
        System.out.println(b);
        System.out.println(b.getHeight());
        b.remove(8);
        System.out.println(b);
        /*System.out.println(b.contains(1));
        System.out.println(b.contains(0));
        System.out.println(b.contains(5));
        System.out.println(b.contains(-1));
        System.out.println(b.contains(6));
        System.out.println(b.contains(4));
        System.out.println(b.contains(25));
        System.out.println(b.contains(30));
        System.out.println(b.contains(-5));*/
    }
}
