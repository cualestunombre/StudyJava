package innerClass;
/*
 내부클래스의 종류
1.인스턴스 클래스 -> 인스턴스의 변수처럼 다뤄진다
2.스태틱 클래스 -> static 변수 처럼 다뤄진다
3.지역 클래스
4.익명 클래스
 */
class Inner{
	int num=100;
	static int coin =200;
	class Instance{

		int iv=100;
		int num=500;
		// static int cv =100; static 변수를 선언할 수 없음 
		final static int cv=100; //상수로 선언은 가능
		//static 메서드 또한 선언할 수 없다
		void func() {
			System.out.println(this.num);
			System.out.println(Inner.this.num);
		}
	}
	static class StaticInner{
		// num=200; 외부클래스의 멤벼변수 접근 불가능
		int iv=200;
		static int ac=500;
		void func() {
			Inner.coin=200;
		}
	}
	void Method() {
		int v=30;
		class LocalInner{
			int iv=300;
			int record = v;
			//static 사용불가
			final static int vv=200;
		}
		
	}
	
}
public class InnerClass{
	public static void main(String[] args) {
		Inner i = new Inner();
		Inner.Instance in = i. new Instance(); //내부 클래서 생성 방법
		Inner.StaticInner vv = new Inner.StaticInner();
	}
}
	
