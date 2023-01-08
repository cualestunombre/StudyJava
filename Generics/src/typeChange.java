class typeChangetest {
	public static void main(String args[]) {
		//제네릭과 논제네릭간의 타입 변환은 된다
		Boxs<String> sbox = null;
		Boxs box = null;
		sbox = (Boxs<String>)box;
		box = sbox;
		//제네릭간 타입변환은 불가능하다
		Boxs<String> nbox = new Boxs<String>();
		Boxs<Integer> ibox = new Boxs<Integer>();
//		nbox = (Box<String>)ibox;
//		ibox = (Box<Integer>)nbox; 타입변환 불가 에러 발생
		// 와일드 카드를 쓴다면?? 
		Boxs<? extends Object> wbox = new Boxs<String>();
		//반대의 형변환
		sbox = (Boxs<String>)wbox; //가능은 함 
		
		
	}
	
	
}
class Boxs<T>{
	
}
