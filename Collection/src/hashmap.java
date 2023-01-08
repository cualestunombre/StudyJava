import java.util.*;
public class hashmap{
	public static void main(String[] args) {
		HashMap h = new HashMap();
		h.put("a", new Unit(100,"marin"));
		System.out.println(h.get("a"));
		//객체를 키로 하면?
		Unit b = new Unit(120,"battle");
		h.put(b,"A");
		System.out.println(h.get(b));
		
	}
}