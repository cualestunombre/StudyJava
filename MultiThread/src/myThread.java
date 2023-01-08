
// 동시성 예제
class Withdrawer implements Runnable{
	Accounts acc = new Accounts();
	public void run() {
		while(acc.getMoney()>0) {
			acc.withdraw();
		}
	}
}

class Accounts{
	private int money = 10000;
	int getMoney() {
		return this.money;
	}
	synchronized void withdraw() {
		int withdrawMoney = (int)(Math.random()*3 +1 )*100;
		if (money-withdrawMoney>=0) {
			notify();
			System.out.println(Thread.currentThread().getName());
			System.out.println("출금 전 "+this.getMoney());
			money-= withdrawMoney;
			System.out.println("출금 후 "+this.getMoney());
			try {
				wait(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class myThread {
	public static void main(String[] args) {
		Runnable r = new Withdrawer();
		new Thread(r,"c1").start();
		new Thread(r,"c2").start();
	}
}
