import java.util.*;
class Person{
	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person temp = (Person)obj;
			return name.equals(temp.name) && age==temp.age;
		}
		return false;
	}
	public int hashCode() {
		return (name+age).hashCode();
	}
	public String toString() {
		return name+":"+age; 
	}
}
public class hashset{
	public static void main(String[]args) {
		Set set = new HashSet();
		set.add(new Person("seok",11));
		set.add(new Person("seok",11));
		set.add(new Person("min",12));
		set.add(new Person("min",13));
		set.add(new Person("min",14));
		// iterator 사용
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}