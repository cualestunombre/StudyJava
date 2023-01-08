class playGeneric {
	public static void main(String args[]) {
		newPri n = new newPri<String,Integer>(null);//raw 타입을 사용하면 타입검사를 포기해버린다
		
		
	}
}
class pri<T,J>{
	private T t;
	private J j;
	pri(T t){
		this.t = t;
	}
	public J returnJ(J j) {
		return j; 
	}
}
class newPri<T,J> extends pri<T,J>{
	newPri(T t) {
		super(t);
		// TODO Auto-generated constructor stub
	}
	
}