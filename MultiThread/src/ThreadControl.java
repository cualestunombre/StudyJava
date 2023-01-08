import javax.swing.JOptionPane;
/*
 스레드의 상태 
 1. NEW : 스레드가 생성되고 아직 start가 호출되지 않은 상태
 2. RUNNABLE : 실행 중 또는 실행 가능한 상태
 3. BLOCKED : 동기화블록에 의해서 일시 정지된 상태
 4. WATING, TIMED_WATING : 스레드의 작업이 종료되지는 않았지만 실행가능하지 않은 일시 정지 상태
 TIMED_WATING은 일시 정지시간이 지정된 경우
 5. TERMINATED : 스레드의 작업이 종료된 상태
 
 
 스레드의 실행제어 함수
 1. sleep() --> static 함수임
 2. interrupt(), interrupted() --> 스레드 작업을 멈추는 함수
void interrupt() 스레드의 interrupted상태를 false에서 true로 변경
boolean isInterrupted() 스레드의 interrupted 상태 반환
static boolean interrupted() 현재 스레드의 상태 반환 후, false로 변경
즉, 스레드가 sleep, wait, join에 의해 일시 정지 상태에 있을 때, interrupt를 실행하면
예외가 발생하고, 스레드는 RUNNABLE상태가 된다
3. suspend(), resume(), stop() --> 
suspend를 실행하면 스레드가 일시정지 상태가 되고 resume으로 다시 실행대기 상태로 돌릴 수 있다
stop을 실행하면 스레드가 즉시 종료된다
4. yield 다른 스레드에게 작업을 양보함
5. join은 현재 스레드가 자신이 하던 작업을 잠시 멈추고, 다른 스레드가 지정된 시간동안 작업을 수행하도록 한다
void join() , void join(long mills) 시간이 설정되면, 해당 시간동안 작업을 멈추고
시간이 설정되있지 않으면 다른스레드가 작업을 완료할 때 까지 기다린다
join도 반드시 try catch 구조로 감싸주어야 한다

 */
class ThreadControl {
	static long startTime = 0;
	public static void main(String args[]) {
		ThreadTests t1 = new ThreadTests();
		t1.start();
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
		System.out.println("입력하신 값은"+input+"입니다");
		t1.interrupt();
		System.out.println(t1.isInterrupted());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		//interrupt 테스트
		SuspendTests s1 = new SuspendTests("topgun");
		s1.start();
		try {Thread.sleep(5000);}
		catch(InterruptedException e) {}
		s1.suspend();
		//suspend,stop을 세련되게
		Thread j1 = new joinTest();
		Thread j2 = new joinTestSecond();
		j1.start();
		j2.start();
		startTime = System.currentTimeMillis();
		try {
			j1.join();
			j2.join();
		}catch(InterruptedException e) {}
		System.out.println(System.currentTimeMillis()-startTime);
		//join 테스트 원래라면 main은 종료되었어야 하나 j1,j2가 종료될 때까지 기다렸다
	}
}
class ThreadTests extends Thread{
	public void run() {
		int i=10;
		while (i!=0 && !isInterrupted()) {
			System.out.println(i--);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println("중단");
				interrupt();
			}
		}
		System.out.println("카운트가 종료 되었습니다");
	}
}
class SuspendTests implements Runnable{
	boolean suspended = false;
	boolean stopped = false;
	Thread th;
	SuspendTests(String name){
		th = new Thread(this,name);
	}
	public void run() {
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
				}
			}
			else {
				Thread.yield(); //추가
			}
		}
		System.out.println("-stopped");
		
	}
	public void suspend() {this.suspended=true; th.interrupt();}
	public void stop() {this.stopped=true; th.interrupt();}
	public void resume() {this.suspended=false;}
	public void start() {this.th.start();}
}
class joinTest extends Thread{
	public void run() {
		for(int i=0; i < 300; i++) {
			System.out.println("-");
		}
	}

	
}
class joinTestSecond extends Thread{
	public void run() {
		for(int i=0; i<300 ; i++) {
			System.out.println("|");
		}
	}
}