import java.util.*;
import java.lang.*;
class Boxes<T>{
	ArrayList<T> box;
	Boxes(ArrayList<T> a){
		this.box=a;
	}
	Boxes(){
		this.box = new ArrayList<T>();
	}
	public void addContent(T c) {
		this.box.add(c);
	}
	public void sort(Comparator<T> c) {
		Collections.sort(this.box,c);
	}
	
	
}

class UnitCompare<T> implements Comparator<T>{
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2);
		}
		
		return -1;
	}

}
class Unit implements Comparable{
	int hp;
	String name; 
	Unit(int hp, String name){
		this.hp = hp;
		this.name = name;
	}
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
		return this.hp+this.name;
	}
	
}

public class GenericsTest {
	public static void main(String[] args) {
		Boxes<Unit> b = new Boxes<Unit>();
		b.addContent(new Unit(500,"sdsd"));
		b.addContent(new Unit(400,"sdsd"));
		b.addContent(new Unit(300,"sdsd"));
		b.addContent(new Unit(1100,"sdsd"));
		b.addContent(new Unit(250,"sdsd"));
		b.sort(new UnitCompare<Unit>());
		System.out.println(b.box);
		
		
	}
}
