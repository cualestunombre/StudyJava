import java.util.*;
public class Iter {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList();
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(4);
		list.add(4);
		ListIterator ti = list.listIterator();
		while(ti.hasNext()) {
			System.out.println(ti.next());
		}
		while(ti.hasPrevious()) {
			System.out.println(ti.previous());
		}
		
	}
	
	
}
