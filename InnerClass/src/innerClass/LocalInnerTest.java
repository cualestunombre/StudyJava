package innerClass;

class Outter{
	int outNum = 100;
	static int sNum =200;
	
	Runnable getRunnable(int i) {
		int num = 100 ;
		class MyRunnable implements Runnable{
			int localNum =10; //변수들이 모두 상수화 된다
			@Override
			public void run() {
				System.out.println(num);
				System.out.println(i);
				System.out.println(localNum);
				System.out.println(outNum);
				System.out.println(sNum);
				
			}
		
		}
		return new MyRunnable();
	}
}





public class LocalInnerTest {
	public static void main(String args[]) {
		Outter outter = new Outter();
		Runnable runner = outter.getRunnable(500);
		runner.run();
	}
}
