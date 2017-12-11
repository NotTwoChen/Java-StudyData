package test;
public class Student {
	// 封装
	private String name = "值";
	
	// 暴露出一个公共的方法去设置/获得
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	
	public void smile () {
		System.out.println("正常输出打印01");
	}
	
	private void cry() {
		System.out.println("正常输出打印02");
	}
	protected void angry() {
		System.out.println("正常输出打印03");
	}
	
	String sad() {
		return "正常输出打印04";
	}

}
