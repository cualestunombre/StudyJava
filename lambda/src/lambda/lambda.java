package lambda;
@FunctionalInterface
interface MyFunction{
	public void run();
}

public class lambda {
	static void execute(MyFunction f) {
		f.run();
	}
	static MyFunction getMyFunction() {
		return ()->System.out.println("헤위"); //함수 반환 값으로 쓸 수 도 있다
	}
	static MyFunction getMyFunctionSecond() {
		return new MyFunction() {
			public void run() {
				System.out.println("안녕하세요");
			}
		};
	}
	public static void main(String[] args) {
		MyFunction f1 = ()->System.out.println("안녕");
		MyFunction f2 = new MyFunction() {
			public void run() {
				System.out.println("흐앙");
			}
		};
		MyFunction f3 = getMyFunction();
		MyFunction f4 = getMyFunctionSecond();
		MyFunction f5 = (MyFunction)()->{}; // 람다식은 익명객체이다
		f4.run();
		f1.run();
		f2.run();
		f3.run();
		execute(f1);
	}
}
