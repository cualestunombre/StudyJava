package copy;


class Fighter implements Cloneable{
	int maxSpeed;
	Weapon wp ;
	Fighter(int m,Weapon wp){
		this.maxSpeed = m;
		this.wp = wp;
	}
	@Override 
	public Fighter clone() {
		Object obj=null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (Fighter)obj;
	}
	public Fighter deepCopy() {
		return new Fighter(this.maxSpeed,new Weapon());
	}
}

class Weapon{
	String name = "SideWinder";
}
public class Copy{
	private static int a =1000 ;
	public static void main(String args[]) {
		Fighter f18 = new Fighter(1000,new Weapon());
		Fighter f16 = f18.clone();
		f18.wp.name="AMRRAM";
		System.out.println(f16.wp.name);
		Fighter f15 = f18.deepCopy();
		f15.wp.name="Maverick";
		f15.maxSpeed=200;
		System.out.println(f15.wp.name);
		System.out.println(f18.wp.name);
		System.out.println(f15.maxSpeed);
		System.out.println(f18.maxSpeed);
		Class Prototype = f15.getClass();
		System.out.println(a);
		
	}
}