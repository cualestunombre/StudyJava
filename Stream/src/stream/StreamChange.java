package stream;
import java.util.*;
import java.util.stream.*;
public class StreamChange {
	public static void main(String[] args) {
		//Stream<Integer>를 IntStream으로 바꾸기
		Stream<Integer> arrStream = Stream.of(1,2,3,4,5,6,7,8,9,10);
		IntStream s = arrStream.mapToInt(x->x);
//		int sum = s.sum();
		
//		System.out.println(sum);
		//IntStream을 Stream<Integer>로 바꾸기
		arrStream = s.mapToObj(x->x);
		arrStream.forEach(System.out::println);
		//Stream<String>을 IntStream으로 바꾸기
		Stream<String> ss = Stream.of("1","2","3");
		System.out.println(ss.mapToInt(Integer::parseInt).sum());
		Stream<Student> sss =  Stream.of(new Student(50,"a"),new Student(40,"b"));
		System.out.println(sss.mapToInt(Student::getAge).sum());
		//map의 역할->새로운 스트림을 반환
		Stream<String> s3 = Arrays.stream(new String[] {"a","b","c"});
		s3.map(x->x+"1").forEach(System.out::println);
		
	}	
	
}
