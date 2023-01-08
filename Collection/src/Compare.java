//Comparable 기본정렬기준을 구현하는 데 사용
//Comparator 기본정렬기준 외에 다른 기준으로 정렬하고자할 때 사용
//둘다 공통적으로 컬렉션 프레임워크에 정렬 기준을 제공해 주고자 할 때 주로 사용한다
import java.util.*;
import java.lang.*;
class Descending implements Comparator{
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2)*-1;
		}
		
		return -1;
	}
}

public class Compare {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("a");
		a.add("z");
		a.add("o");
		a.add("x");
		a.sort(new Descending());
		System.out.println(a);
	}
	
	
}
