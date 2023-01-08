package lambda;
import java.util.Iterator;
import java.util.function.*;

public class methodReference {
	public static void main(String args[]) {
		ForTest<String,Integer> f = new ForTest<>();
		f.run(Integer::parseInt, "23");
	}
}
