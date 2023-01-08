package javaLangTest;
class Node{
	public int code;
	Node(int code){
		this.code = code;
	}
	@Override
	public boolean equals(Object obx) {
	if(obx instanceof Node) {
		return ((Node)obx).code == this.code;
	}
	else return false;
	}
	
}
class Obj {
	public static void main(String args[]) {
		Node n1 = new Node(5);
		Node n2 = new Node(5);
		if (n1.equals(n2)) {
			System.out.println("같은 객체");
		}
		else {
			System.out.println("다른 객체");
		}
		
	}
}
