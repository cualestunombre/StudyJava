package overloading;

public class Overloading {
	private int a;
	Overloading(int a){
		this.a=a;
	}
	static double add(double a, double b) {
		return a+b;
	}
	static int add(int... args) {
		int sum=0;
		for (int i=0;i<args.length;i++) {
			sum+=args[i];
		}
		return sum;
	}
}

class main{
	public static void main(String args[]) {
		System.out.println(Overloading.add(5,4,123,23,3));
		System.out.println(Overloading.add(5.34,4.1232));
		Overloading a = new Overloading(5);
		
	}
	public static boolean compare(Object a, Object b) {
		System.out.println("obejct");
		if(a instanceof Integer && b instanceof Integer) {
			if((Integer)a>(Integer)b)return true;
			else return false;
		}
		return true;
	}
	public static boolean compare(Integer a,Integer b) {
		System.out.println("integer");
		if (a>b) return true;
		else return false;
	}// 오버로딩은 더 구체적인 것으로 간다... 
}



