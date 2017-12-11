package inter;

public class Company{
	
	// Work是一个接口
	// 这里就是创建了一个接口的引用
	private Work work;
	
	public void setWork(Work work) {
		this.work = work;
	}

	public void startWork() {
		this.work.work();
	}

	public void endWork() {
		this.work.goHome();
	}
}
