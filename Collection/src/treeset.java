import java.util.*;
class Unit implements Comparable{
	int hp;
	String name;
	Unit(int hp,String name){
		this.hp = hp;
		this.name = name;
	}
	@Override
	public int compareTo(Object c) {
		if (c instanceof Unit) {
			Unit temp = (Unit)c;
			if (this.hp >temp.hp) return 1;
			else if (this.hp==temp.hp) return 0;
			else return -1;
		}
		return -1;
	}
	public String toString() {
		return "hp: " + this.hp +" name: "+this.name;
	}
}
public class treeset {
	public static void main(String agrs[]) {
		TreeSet set = new TreeSet();
		set.add(new Unit(120,"battle"));
		set.add(new Unit(180,"vulture"));
		set.add(new Unit(100,"marin"));
		set.add(new Unit(140,"dragon"));
		set.remove(new Unit(100,"marin")); // 객체 삭제
		System.out.println(set);
	}
	
}

