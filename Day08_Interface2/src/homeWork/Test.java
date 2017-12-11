package homeWork;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		
		List<Object> list = new ArrayList<>();
		
		System.out.println(list.size());
		
		list.add("ÕÅÈı");
		list.add(new Person());
		list.add(1);
		
		System.out.println(list.size());
	}
}
