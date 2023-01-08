package stream;
/* collect() : 스트림의 최종 연산, 매개변수로 컬렉터를 필요로 한다
 * Collector : 인터페이스, 컬렉터는 이 인터페이스를 구현해야 한다
 * Collectors : 클래스, static메서드로 미리 작성된 컬렉터를 제공한다
 *  
 *  
 *  
 */
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
public class collectorBasic {
	public static void main(String[] args) {
		//스트림을 컬렉션과 배열로 반환 
		ArrayList<Integer> au = (ArrayList )Stream.of(1,2,3,4,5).collect(Collectors.toList());
		Iterator it = au.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		String [] arr = Stream.of("1","2").toArray(String[]::new);
		Integer[] iarr = Stream.of(1,2,3,4,5).toArray(Integer[]::new);
		IntStream is = IntStream.rangeClosed(1, 10000);
		System.out.println(is.mapToObj(x->x).collect(reducing(0,(a,b)->a+b))); 
		
		
		
	}
}
