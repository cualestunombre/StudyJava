package innerClass;

class OutClass2{
	private int num =10;
	private static int sNum =11;
	
	static class InStaticClass{
		int inNum =10;
		static int sInNum = 10; //정적 변수 선언 가능
		void inTest() {
			System.out.println(sNum); // 상위 클래스의 정적 변수
			System.out.println(inNum);  //static innerClass 인스턴스 변수
			System.out.println(sInNum); // static innerCl 정적 변수
		}
		static void sTest() {
			System.out.println(sNum);
			System.out.println(sInNum);
		}
	}
	
}





public class InnerStaticTest {
	public static void main(String args[]) { 
		OutClass2.InStaticClass.sTest();
	}
}
