class threadTest{
	static long startTime = 0;
	public static void main(String args[]) {
		Threads th1 = new Threads();
		th1.start();//한번 호출된 쓰레드는 다시 실행할 수 없다
		startTime = System.currentTimeMillis();
		for(int i = 0 ; i<300; i++) {
			System.out.println("-");
		}
		System.out.println("소요시간"+(System.currentTimeMillis()-startTime)); 
	}
}

class Threads extends Thread {
	public void run() {
		for(int i=0 ; i < 300 ; i++) {
			System.out.println("|");
		}
		System.out.println("소요시간"+(System.currentTimeMillis()-threadTest.startTime));
	}
}
/* 
 메인 쓰레드가 메인 함수를 실행 시킨다
 모든 쓰레드가 종료되면 프로그램이 종료된다
 
 */ 

