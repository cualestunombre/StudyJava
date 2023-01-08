package collection;

public class Member implements Comparable<Member>{
	private int memberId;
	private String memberName;
	
	public Member(int memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	public int getMemberId() {
		return this.memberId;
	}
	@Override
	public int hashCode() {
		return this.memberId;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Member)) {
			return false;
		}
		else {
			Member member = (Member)obj;
			if (member.memberId==this.memberId) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	public String getMemberName() {
		return this.memberName;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return memberName + "회원님의 아이디는 " + memberId +"입니다";
	}
	@Override
	public int compareTo(Member member) {
		return (this.memberId-member.memberId);
	}
}
