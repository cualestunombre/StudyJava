package lambda;
import java.util.*;
import java.util.function.*;

class ForTest<T,R>{
	public void run(Function<T,R> f,T t) {
		f.apply(t);
	}
}
public class functionPacakge {
	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList();
		for(int i=0;i<10;i++) list.add(i);
		list.forEach(i->System.out.println(i));
		list.removeIf(x->x%2==0||x%3==0);
		Map<String,String> map = new HashMap<>();
		map.put("1", "4");
		map.forEach((i,j)->System.out.println(i+j));
		ForTest<Integer, String> f = new ForTest<>();
		f.run(x->Integer.toString(x),5);
	}
}
