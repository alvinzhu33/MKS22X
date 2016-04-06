import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{
    private class LNode{
        private T value;
        private LNode next;
        private LNode prev;

        public LNode(T v){
            value = v;
        }

        public T getValue(){
            return value;
        }
        public LNode getNext(){
            return next;
        }
        public LNode getPrev(){
            return prev;
        }

        public T setValue(T v){
            T old = value;
            value = v;
            return old;
        }
        public void setNext(LNode n){
            next = n;
        }
        public void setPrev(LNode p){
            prev = p;
        }

        public String toString(){
            return value.toString();
        }
    }

    LNode head;
    LNode tail;
    int size;

    public Iterator<T> iterator(){
        //This uses an anonymous class! You don't need to know this.
        return new Iterator<T>()
        {
            private LNode current = head;

            public boolean hasNext(){
                return current != null;
            }
            public T next(){
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                T value = current.getValue();
                current = current.getNext();
                return value;
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
    public Iterator<T> iteratorBack(){
        //This uses an anonymous class! You don't need to know this.
        return new Iterator<T>()
        {
            private LNode current = tail;

            public boolean hasNext(){
                return current != null;
            }
            public T next(){
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                T value = current.getValue();
                current = current.getPrev();
                return value;
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    public String toString(){
        String ans = "[";
        LNode p = head;
        while(p!=null){
            ans += p.getValue();
            if(p.getNext()!=null){
                ans += ", ";
            }
            p = p.getNext();
        }
        return ans+"]";
    }
    public String toString(boolean b){
        return toString()+" head: "+head +", tail: "+tail;
    }

    private LNode getNth(int index){
        //check bounds before calling this method!
        if(index<0 || index>=size()){
            throw new IndexOutOfBoundsException();
        }
        LNode temp;
        if(index<size()/2){
            temp = head;
            while(index > 0){
                temp = temp.getNext();
                index --;
            }
        }else{
            temp = tail;
            index = size()-1-index;
            while(index>0){
                temp = temp.getPrev();
                index --;
            }
        }
        return temp;
    }

    public boolean add(T value){
        if(head == null){
            head = new LNode(value);
            tail = head;
        }else{
            LNode add = new LNode(value);
            add.setPrev(tail);
            tail.setNext(add);
            add.setNext(tail.getNext().getNext());
            tail = tail.getNext();
        }
        size++;
        return true;
    }

    public boolean add(int index, T value){
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
        }
        LNode temp = new LNode(value);
        if(index==size() || size()==0){
            add(value);
            size--;
        }else if(index == 0){
            temp.setNext(head);
            head.setPrev(temp);
            head = temp;
        }else{
            LNode prev = getNth(index-1);
            LNode next = prev.getNext();
            temp.setPrev(prev);
            temp.setNext(next);
            prev.setNext(temp);
            next.setPrev(temp);
            if(tail.getNext() != null){
                tail=tail.getNext();
            }
        }
        size++;
        return true;
    }

    public T remove(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size());
        }
        LNode temp;
        if(size()==1){
            temp=head;
            head=null;
            tail=null;
        }else if(index == 0){
            temp = head;
            head = head.getNext();
            head.setPrev(null);
        }else if(index == size()-1){
            temp = tail;
            tail = tail.getPrev();
            tail.setNext(null);
        }else{
            LNode p = getNth(index-1);
            temp = p.getNext();
            LNode n = temp.getNext();
            n.setPrev(p);
            p.setNext(n);
        }
        size--;
        return temp.getValue();
    }

    public int size(){
        return size;
    }
    public T get(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
        }
        return getNth(index).getValue();
    }
    public T set(int index, T newValue){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
        }
        return getNth(index).setValue(newValue);
    }

    public int indexOf(T target){
        LNode temp = head;
        int index = 0;
        while(temp != null){
            if(temp.getValue().equals(target)){
                return index;
            }
            index++;
            temp = temp.getNext();
        }
        return -1;
    }

    public static void main(String[]args){
        MyLinkedList<String> m = new MyLinkedList<String>();
        ArrayList<String>    n = new ArrayList<String>();

        for(int i = 0; i < 10; i++){
            n.add(""+i);
            m.add(""+i);
        }

        try{
            m.add(-1,"oops");
            System.out.println("\n\nAdd -1 #####################################");
        }catch(IndexOutOfBoundsException e){
            System.out.println("caught");
        }
        try{
            m.add(12,"oops");
            System.out.println("\n\n add 12 #####################################");
        }catch(IndexOutOfBoundsException e){
            System.out.println("caught");
        }
        try{
            m.remove(12);
            System.out.println("\n\n remove 12 #####################################");
        }catch(IndexOutOfBoundsException e){
            System.out.println("caught");
        }

        try{
            m.set(12,"Fwazzat?!?");
            System.out.println("\n\n set 12 #####################################");
        }catch(IndexOutOfBoundsException e){
            System.out.println("caught");
        }

        //replace toString(true) with a debug to string that shows the head/tail
        System.out.println(m.toString(true));
        System.out.println(n);

        //test removing from head/tail/middle
        m.remove(0);
        n.remove(0);
        System.out.println(m.toString(true));
        System.out.println(n);

        m.remove(2);
        n.remove(2);
        System.out.println(m.toString(true));
        System.out.println(n);

        m.remove(m.size()-1);
        n.remove(n.size()-1);
        System.out.println(m.toString(true));
        System.out.println(n);

        //test adding to end/start
        m.add(0,"START");
        n.add(0,"START");
        m.add(m.size(),"PENULTIMATE");
        n.add(n.size(),"PENULTIMATE");
        System.out.println(m.toString(true));
        System.out.println(n);

        //test add
        m.add("Z-END!");
        n.add("Z-END!");
        System.out.println("My Size:"+m.size());
        System.out.println(m.toString(true));
        System.out.println(n);

        //test remove random items:
        Random rand = new Random(0);
        for(int i = 0; i < 6000; i++){
            int op = rand.nextInt(4);
            //System.out.println();
            //System.out.println(op);
            if(op == 0 || n.size()==0){//ensure never empty
                n.add(""+i);
                m.add(""+i);
            }else if(op == 1 ){
                int x = rand.nextInt(n.size());
                n.add(x,""+i);
                m.add(x,""+i);
            }else{
                int x = rand.nextInt(n.size());
                //System.out.println("Index:"+x);
                //System.out.println("Size:"+m.size());
                if(!n.remove(x).equals(m.remove(x))){
                    //System.out.println(m.toString(true));
                    //System.out.println(n);
                    System.out.println("Non matching elements removed\n");
                    System.exit(1);
                }
            }
            //System.out.println(m.toString(true));
            //System.out.println(n);
        }
        //System.out.println(m.toString(true));
        //System.out.println(n);
        System.out.println("Sucess!!!");

        /*test speed of add in front and at end.
        long start,end;
        System.out.println("Add 100k to front");

        start = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++)
            n.add(0,""+i);
        end = System.currentTimeMillis();
        System.out.println( "ArrayList "+(end-start)/1000.0 );

        start = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++)
            m.add(0,""+i);
        end = System.currentTimeMillis();
        System.out.println( "LinkedList "+(end-start)/1000.0 );


        System.out.println("Add 1m to end");

        start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++)
            n.add(""+i);
        end = System.currentTimeMillis();
        System.out.println( "ArrayList "+(end-start)/1000.0 );

        start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++)
            m.add(""+i);
        end = System.currentTimeMillis();
        System.out.println( "LinkedList "+(end-start)/1000.0 );

        */
    }
}
