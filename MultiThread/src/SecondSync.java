import java.util.ArrayList;

class Table{
	String[] dishNames = {"pizza","sushi","sushi"};
	final int MAX_FOOD = 6; 
	private ArrayList<String> dishes = new ArrayList<>();
	public synchronized void add(String dish) {
		while(dishes.size()>=MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + "is wating");
			try {
				wait();
				Thread.sleep(500);
			}catch(InterruptedException e) {}
		}
		dishes.add(dish);
		notify();
		System.out.println("Dishes:" + dishes.toString());
	}
	public synchronized void remove(String dishName) {
		String name = Thread.currentThread().getName();
		while(dishes.size()==0) {
			System.out.println(name+"is waiting");
			try {
				wait();
				Thread.sleep(500);
			}catch(InterruptedException e) {}
		}
		while(true) {
			for(int i=0; i<dishes.size();i++) {
				if(dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					notify();
					return;
				}
			}
			try {
				System.out.println(name+"is wating");
				wait();
				Thread.sleep(500);
			}catch(InterruptedException e) {}
		}
		
	}
	public int dishNum() {return dishNames.length;}
}
class Customer implements Runnable{
	private Table table;
	private String food;
	
	Customer(Table table, String food){
		this.table = table;
		this.food = food;
	}
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
			}
			table.remove(food);
			String name = Thread.currentThread().getName();
			System.out.println(name + "ate a" + food);
		}
	}
}

class Cook implements Runnable{
	private Table table;
	
	Cook(Table table){
		this.table = table;
	}
	public void run() {
		while(true) {
			int idx = (int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {}
		}
		
		
	}
}
class shop{
	public static void main(String args[]) {
		Table table = new Table();
		new Thread(new Cook(table),"cook1").start();
		new Thread(new Customer(table,"pizza"),"cust1").start();
		new Thread(new Customer(table,"sushi"),"cust2").start();
		
	}
}
