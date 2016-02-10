public class Driver{
    public static void main(String[]args){
	QueenBoard b1 = new QueenBoard(5);
	b1.print();
	System.out.println();
	
	b1.addQ(0,0);
	b1.print();
	System.out.println();
	b1.addQ(1,2);
	b1.print();
	System.out.println();
	b1.addQ(4,3);
	b1.print();
	System.out.println();
	b1.addQ(0,4);
	b1.print();
	System.out.println();
	b1.addQ(4,2);
	b1.print();
	System.out.println();

	b1.print();
	System.out.println();

	b1.minusQ(0,2);
	b1.print();
	System.out.println();
	b1.minusQ(3,2);
	b1.print();
	System.out.println();
	b1.minusQ(4,4);
	b1.print();
	System.out.println();
	b1.minusQ(0,0);
	b1.print();
	System.out.println();
    }
}
