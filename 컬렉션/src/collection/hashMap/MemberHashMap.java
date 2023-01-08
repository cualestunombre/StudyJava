package collection.hashMap;
import java.util.HashMap;
import java.util.Iterator;
import collection.Member;

public class MemberHashMap {
	private HashMap memberHashMap;
	public MemberHashMap(){
		this.memberHashMap = new HashMap<Integer,Member>();
	}
	public void addMember(Member member) {
		memberHashMap.put(member.getMemberId(),member);
	}
	public boolean removeMember(int memberId) {
		if(memberHashMap.containsKey(memberId)) {
			memberHashMap.remove(memberId);
			return true;
		}
		else {
			return false;
		}
		
	}
	public void showAllMembers() {
		Iterator <Integer> ir = this.memberHashMap.keySet().iterator();
		while (ir.hasNext()) {
			int key = ir.next();
			Member member = (Member) this.memberHashMap.get(key);
			System.out.println(member.getMemberId());
			
		}
		System.out.println("출력 완료");
	}

}
