package stream;
import java.util.stream.*;
import java.util.*;
class Unit implements Comparable{
	int hp;
	String name;
	boolean isCombatU;
	Unit(int hp, String name,boolean c){
		this.isCombatU=c;
		this.hp = hp;
		this.name = name;
	}
	public int compareTo(Object c) {
		if(c instanceof Unit) {
			Unit u = (Unit) c;
			if(this.hp>u.hp) return -1;
			if(this.hp==u.hp) return 0 ;
		}
		return 1;
		
	}
	public int getHp() {
		return this.hp;
	}
	public String getName() {
		return this.name;
	}
	public boolean isCombat() {
		return this.isCombatU;
	}
	@Override
	public String toString() {
		return "hp :"+this.hp+"name: "+this.name;
	}
	@Override
	public int hashCode() {
		return (Integer.toString(hp)+"@"+name).hashCode();
	}
	@Override 
	public boolean equals(Object c) {
		if(c instanceof Unit && ((Unit) c).hp==this.hp && ((Unit)c).name == this.name) {
			return true;
		}
		return false;
	}

	
}
public class StreamTest {
	public static void main(String args[]) {
		IntStream intstream = IntStream.rangeClosed(1, 10);
		intstream.skip(3).limit(5).forEach(System.out::println);// skip, limit
		intstream = IntStream.of(1,1,2,3,4,5,6,7);
		intstream.distinct().forEach(System.out::println); // distinct
		ArrayList<Unit> a = new ArrayList<>();
		a.add(new Unit(135,"a",true));
		a.add(new Unit(70,"a",true));
		a.add(new Unit(50,"a",true));
		a.add(new Unit(60,"b",true));
		a.add(new Unit(70,"c",true));
		Stream<Unit> s = a.stream();
		s.distinct().filter(x->x.hp>=60).forEach(System.out::println); //filter
		System.out.println("");
		s= a.stream();
		s.sorted().forEach(System.out::println);
		s=a.stream();//peek
		s.peek(x->System.out.println(x));
	}
}
