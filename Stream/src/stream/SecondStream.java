package stream;
import java.util.stream.*;
import java.util.*;
public class SecondStream {
	public static void main(String[] args) {
		Stream<Student> s = Stream.of(new Student(15,"seok"),new Student(15,"aeok"),new Student(10,"woo"),new Student(70,"min"));
		s.sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getName)).forEach(System.out::println);;
		// 배열 스트림을 하나로 합치기

		Stream<String[]> ss = Stream.of(new String[]{"a","b","c"}, new String[] {"c","f"});
		Stream<String> sss = ss.flatMap(Arrays::stream);
		sss.forEach(System.out::println);
		String[] a = new String[] {
			"Believe or not It is true",
			"Do or do not There is no try"
		};
		Stream<String> ssss= Arrays.stream(a);
		ssss.flatMap(x->Stream.of(x.split(" +"))).forEach(System.out::println); 
		// stream의 stream을 합치기
		Stream<Integer> c = Stream.of(1,2,3,4,5);
		Stream<Integer> b = Stream.of(6,7,8,9,10);
		Stream<Stream<Integer>> v = Stream.of(c,b);
		v.map(x->x.toArray(Integer[]::new)).flatMap(Arrays::stream).forEach(System.out::println);;
		
	}
}
class Student implements Comparable<Student>{
	private int age;
	private String name;
	@Override
	public int compareTo(Student s) {
		if(this.age>s.age) return 1;
		if(this.age==s.age) return 0;
		return -1;
	}
	Student(int age,String name){this.name=name; this.age=age;}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	@Override
	public String toString() {
		return this.name+this.age;
	}
	
	
}