package Interface;
/*
 추상 클래스보다 추상도가 높아, 메소드 구현를 할 수 없고 멤버변수를 가질 수가 없다
 인터페이스의 모든 멤버함수는 public abstract 이다
 인터페이스의 모든 멤버변수는 public static final 이다 
 인터페이스는 다중상속이 가능하다
 
 */
interface attackable{
	public static final int damage = 0;
	public static void function() {
		System.out.println("5");
	}
	public default void handle() {
		System.out.println("6");
	}
	public abstract void attack();
}
interface movable{
	public abstract void move();
	public default void handle() {
		System.out.println("7");
	}
}
class unit implements attackable,movable{
	public void attack() {
		System.out.println("attack");
		this.handle();
	}
	public void move() {
		System.out.println("move");
	}
	@Override
	public void handle() {
		System.out.println("fdfd");
	}
}
/*
인터페이스로 다형성을 구현한 예
 */
interface dbAccess{
	void db();
}
class oracle implements dbAccess{
	public void db() {
		System.out.println("오라클 접근");
		attackable.function(); //인터페이스도 static 함수 사용가능
	}
}
class mysql implements dbAccess{
	public void db() {
		System.out.println("mysql 접근");
	}
}
public class Interface {
	public static dbAccess Access(dbAccess d) {
		if (d instanceof oracle) {
			d.db();
			return d;
		}
		else {
			d.db();
			return d;
		}
	}
	public static void main(String args[]) {
		Access(new oracle());
		Access(new mysql());
		
	}
}
