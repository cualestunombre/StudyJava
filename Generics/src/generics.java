import java.util.*;
class generictest{
	public static void main(String args[]) {
		FruitBox<Fruit> box = new FruitBox<Fruit>();
		box.add(new Apple(5000));
		box.add(new Apple(150));
		box.add(new Apple(200000));
		box.add(new Grape(12300));
		Collections.sort(box.getList(),new FruitComp());
		System.out.println(box);
		//appleBox.add(new Grape()); 에러 발생a
		
		
		
	}
}


/* 
 Box<Fruit> = new Box<Apple> ; 에러 발생 
 Box<Apple> = new FruitBox<Apple> ; 가능 
*/
class Fruit{
	public int weight;
	public String toString() {return "Fruit";}
	Fruit(int weight){
		this.weight = weight;
	}
}
class Apple extends Fruit{
	Apple(int weight) {
		super(weight);
	}
	public String toString() {return "Apple";}
}
class Grape extends Fruit{
	Grape(int weight) {
		super(weight);
		// TODO Auto-generated constructor stub
	}
	public String toString() {return "Grape";}
}
class FruitComp implements Comparator<Fruit>{
	public int compare(Fruit f1, Fruit f2) {
		return f1.weight - f2.weight;
	}
}

class Box<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {list.add(item);}
	T get(int i) {return list.get(i);}
	ArrayList<T> getList(){return list;}
	int size() {return list.size();}
	@Override
	public String toString() {
		return list.toString();
	}
}
class FruitBox<T extends Fruit> extends Box<T>{}
class appleBox extends Box<Apple>{}

