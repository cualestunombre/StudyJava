package collection.treeSet;
import collection.Member;
import java.util.TreeSet;
import java.util.Iterator;
public class MemberTreeSet {
	private TreeSet<Member> memberTreeSet;
	public MemberTreeSet(){
		this.memberTreeSet = new TreeSet <Member>();
	}
	public void addMember(Member member) {
		this.memberTreeSet.add(member);
	}
	public boolean removeMember(int memberId) {
		Iterator <Member> ir = this.memberTreeSet.iterator();
		while (ir.hasNext()) {
			Member member = ir.next();
			if (member.getMemberId()==memberId) {
				memberTreeSet.remove(member);
				return true;
			}
		}
		return false;
	}
	public void showAllMembers() {
		for (Member member:memberTreeSet) {
			System.out.println(member);
		}
		System.out.println();
	}
	
}
