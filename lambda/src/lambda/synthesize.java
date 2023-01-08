package lambda;
import java.util.function.*;
public class synthesize {
	public static void main(String[] args) {
		Function<String,Integer> f = (s)->Integer.parseInt(s);
		Function<Integer,String> g = (i)->Integer.toBinaryString(i);
		Function<String,String> h = f.andThen(g);
		
	}
}
