package collection.hashSet;
import collection.Member;
import collection.treeSet.MemberTreeSet;
import collection.hashMap.MemberHashMap;

public class test {
	public static void main(String args[]) {
		MemberHashMap m = new MemberHashMap();
		m.addMember(new Member(110,"Cyclone"));
		m.addMember(new Member(5,"Maverick"));
		m.addMember(new Member(2,"Hangman"));
		m.addMember(new Member(10,"Bob"));
		m.showAllMembers();
	}
}
