package casting;


class Parent{
	public final int a;
	Parent(int a){
		this.a=a;
	}
	protected int getA() {
		return this.a;
	}
}
class Child extends Parent{
	public final int b;
	public final int a;
	Child(int a, int b){
		super(a);
		this.b=b;
		this.a=10;
	}
	protected int getB() {
		return this.b;
	}
	@Override
	protected int getA() {
		return this.a;
	}
	
}
public class Casting {
	public static void main(String args[]) {
		Parent a = null;
		a = new Child(4,5);
		System.out.println(a.getA());
		Child b = (Child)a;
		System.out.println(b.a);
		a = b;
		System.out.println(a.a);
	}
}
