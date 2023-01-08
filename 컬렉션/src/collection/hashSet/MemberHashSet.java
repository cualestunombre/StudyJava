package collection.hashSet;
import java.util.HashSet;
import java.util.Iterator;
import collection.Member;
public class MemberHashSet {
	private HashSet <Member> memberHashSet;
	MemberHashSet(){
		this.memberHashSet = new HashSet <Member>();
	}
	public void addMember(Member member) {
		this.memberHashSet.add(member);
	}
	public boolean removeMember(int memberId) {
		Iterator <Member> ir = memberHashSet.iterator();
		while (ir.hasNext()) {
			Member member = ir.next();
			if (member.getMemberId()==memberId) {
				memberHashSet.remove(member);
				return true;
			}
		}
		return false;
		
	}
	public Member getInstance(int memberId) {
		Iterator <Member> ir = this.memberHashSet.iterator();
		while (ir.hasNext()) {
			Member member = ir.next();
			if (member.getMemberId() == memberId) {
				return member;
			}
		}
		
		return null;
	}
	
	public void showAllMembers() {
		Iterator <Member> ir = memberHashSet.iterator();
		while (ir.hasNext()) {
			Member member = ir.next();
			System.out.println(member.getMemberId());
		}
	}
}

