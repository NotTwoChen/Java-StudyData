package homeWork;

public class Person implements UserInter {
	private String name;
	private String username;
	private String pssword;
	private String work;
	
	
	
	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return "用户姓名:" + getName()
			+	"用户职业:" + getWork();
	}

	public void add(String name, String username, String password, String work) {
		this.setName(name);
		this.setUsername(username);
		this.setPssword(password);
		this.setWork(work);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPssword() {
		return pssword;
	}
	public void setPssword(String pssword) {
		this.pssword = pssword;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public void onLine() {
	}
	public void offLine() {
	}
}
