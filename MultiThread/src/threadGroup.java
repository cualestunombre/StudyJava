
public class threadGroup {
	public static void main(String args[]) {
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup grp1 = new ThreadGroup("Group1");
		ThreadGroup grp2 = new ThreadGroup("Group2");
		ThreadGroup subGrp1 = new ThreadGroup(grp1,"SubGroup1");
		System.out.println("Active ThreadGroup"+main.activeGroupCount()+"\n"+"Active Thread"+main.activeCount()); 
		
	}
}
