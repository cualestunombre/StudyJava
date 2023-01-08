/*
 객체마다 락을 하나씩 가지고 있고, 락이 걸려있다면,걸린 동안은 해당 객체에 대한 접근이 불가능하다
 스레드간 자원을 공유할 때, 한 스레드가 공유자원을 변경하면 다른 스레드의 작업에 영향을 끼칠 수 가 있다
 방식 
 1. 메서드 전체를 임계 영역으로 지정
 2. 특정한 영역을 임계 영역으로 지정 
 
 wait와 notify -->
 락을 거는 것은 좋으나 하나의 스레드가 특정 자원을 지나치게 오래 독점 하는 것 또한 좋지 않다
 wait, notify, notifyAll은 Object에 정의 되어 있고 동기화 블럭내에서만 사용할 수 있다
wait는 호출 시, 쓰레드가 락을 반납한다 -> 현재스레드는 waiting pool로
notify는 호출 시, waiting pool에 대기 중인 임의의 스레드가 락을 획득한다 

 */
class SyncTest{
	public static void main(String args[]) {
		Runnable r = new Bank();
		new Thread(r).start();
		new Thread(r).start();
		// 한 스레드가 다른 스레드가 바꾸는 도중에 바꿔버림
	}
}
class Account{
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	
	public synchronized void withdraw(int money) {
		if(balance>=money) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
			balance-=money;
		}
	}
	public void anotherWithdraw(int money) {
		synchronized(this) {// 동기화 블럭을 사용
			if(balance>=money) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {}
				balance-=money;
			}
		}
	}
}
class Bank implements Runnable{
	Account acc = new Account();
	public void run() {
		while(acc.getBalance()>0) {
			int money = (int)(Math.random()*3+1)*100;
			acc.withdraw(money);
			System.out.println(acc.getBalance());
			
		}
	}
}