package javaLangTest;

class Weapon{
	String name;
	Weapon(String s){
		this.name = s;
	}
	Weapon(Weapon w){
		this.name = w.name;
	}
}

class Prototype implements Cloneable{
	Weapon weapon;
	Prototype(Weapon w){
		this.weapon=w;
	}
	@Override
	public Prototype clone() {
		return new Prototype(this.weapon);
	}
	public void changeWeapon(Weapon w) {
		this.weapon =w;
	}
	public void changeWeapon(String s) {
		this.weapon = new Weapon(s);
	}
	
	// 오버라이딩시 자손 클래스의 타입으로 반환형을 바꿀 수 있음
}

class cloneTest{
	public static void main(String args[]) {
		int [] arr = {1,2,3,4};
		int [] brr = arr.clone();
		arr[0]=5;
		System.out.println(brr[0]);
		//clone은 단순 값 복제라(얕은 복사) 참조형 변수는 깊은 복사를 해줘야 한다
		Weapon gun = new Weapon("gun");
		Weapon missle = new Weapon("missle");
		Prototype f16 = new Prototype(gun);
		Prototype f18 = f16.clone();
		f16.changeWeapon(missle);
		System.out.println(f16.weapon.name);
		System.out.println(f18.weapon.name);
		
	}
	
}
