package collection.arrayList;
import java.util.ArrayList;
import collection.Member;
public class MemberArrayList {
	private ArrayList<Member> arrayList;
	
	public MemberArrayList() {
		arrayList = new ArrayList<Member>();
		
	}
	
	public void addMemeber(Member member) {
		arrayList.add(member);
	}
	public boolean removeMember(int memberId) {
		for (int i=0; i<arrayList.size();i++) {
			Member member = arrayList.get(i);
			int tempId = member.getMemberId();
			if(tempId == memberId) {
				arrayList.remove(i);
				return true;
			}
		}
		System.out.println("해당 번호를 가진 회원이 존재하지 않습니다!");
		return false;
	}
	public void showAllMember() {
		for (Member member: arrayList) {
			System.out.println(member);
		}
		System.out.println();
	}
}
