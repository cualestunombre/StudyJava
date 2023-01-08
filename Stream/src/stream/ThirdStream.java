package stream;
import java.util.stream.*;
import java.util.*;
public class ThirdStream {
	public static void main(String[] args) {
		IntStream i1 = IntStream.rangeClosed(1, 100);
		System.out.println(i1.reduce(5,(a,b)->a+b));
		Stream<Unit> us = Stream.of(new Unit(500,"sd",true),new Unit(400,"ad",true),new Unit(300,"td",true));
		System.out.println(us.mapToInt(x->x.hp).reduce(0,(x,y)->x+y));
	}
}
