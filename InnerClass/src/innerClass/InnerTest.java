package innerClass;

class OutClass{
	private int num = 10;
	private static int sNum=20;
	private InClass inClass;
	
	public OutClass() {
		inClass = new InClass ();
	}
	
	class InClass{
		int inNum =10;
		
		void inTest() {
			System.out.println("num"+num+"sNum"+sNum+"inNum"+inNum);
		}
		
		
	}
	public void usingClass() {
		inClass.inTest();
	}
}
public class InnerTest {
	public static void main(String args[]) {
		OutClass outClass= new OutClass();
		outClass.usingClass();
	}
	
}
