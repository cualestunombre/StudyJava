package ErrorTest;
/*
 RuntimeException클래스의 자손들은 반드시 예외처리가 필요하지는 않지만
그외에 Exception의 자손들은 반드시 예외처리가 필요하다

메서드에 throws 형태로 예외가 명시 되어있으면, 반드시 예외처리를 해주어야 한다

 */
public class Error {
	public static void main (String args[]) {
		/*try {
			errorTest();
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		try {
			errorTest();
		} catch
		(Exception e) {}
		runTimeError();//따로 에러 처리를 해줄 필요가 없음 왜냐하면 RuntimeException이기 때문에
		
		
	}
	/*
	static void errorTest() throws Exception {
		throw new Exception("Talk to me Goose");
	}*/
	static void errorTest() throws Exception {
		try {
			throw new Exception("Talk to me Goose");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	static void runTimeError() throws RuntimeException {
		
	}
}
