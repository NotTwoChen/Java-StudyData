package com.lanou3g.string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringDemo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String a = "   abadefg   ";
		String b = "张三李四";
		
		// 去处字符串前后的空格
		// 并不会把a改变,只是输出结果
		// 所以这里需要将结果赋值给a
		a = a.trim();
		
		// 获取字符串长度
		System.out.println(a.length());
		System.out.println(b.length());
		
		// 替换,把a替换成h
		System.out.println(a.replace("a", "h464"));
		System.out.println(a);
		System.out.println(a.replace("ba", "qwe"));
		System.out.println(a);
		a.replace("de", "asd");
		System.out.println(a);
		System.out.println(b.replace("张三", "许"));
		// 问题保留:
		// 1,命令执行后,a的值是什么,
		// 2.为什么是这个值,
		// 3.替换前后的值是否并列保存
		// 替换后的返回值才是变换值,输出的是结果
		// 除非额外添加赋值过程
		
		// 取字符串中的子串
		// 从0位置开始,取到2
		// 这是一个左闭右开的区间
		// [0,3) 所以就是从0取到2
		System.out.println(a.substring(0, 3));
		
		// 取字符串中的子串
		// 从4开始一直取到末尾
		System.out.println(a.substring(4));
		
		//分割字符串
		// 以e为条件分割字符串
		// 会得到一个字符串的数组
		System.out.println(a.split("e"));
		System.out.println(Arrays.toString(a.split("e")));
		
		// 判断两个字符串的内容是否相等
		System.out.println(a.equals("bcd"));
		// 判断两个字符串的内容是否相等并忽略大小写
		System.out.println(a.equalsIgnoreCase("abaDeFg"));
		
		// 获取第一个字符e在a这个字符串中的位置
		// 如果不存在e,则返回-1
		int index = a.indexOf('a');
		System.out.println(index);
		
		// 获取index位置的字符
		// 输入的index数值一定要在字符串长度内
		// 否则会报错
		char qwe = a.charAt(4);
		a.charAt(index);
		System.out.println(a.charAt(5));
		
		// 是否以a开头,返回boolean的true或false
		a.startsWith("a");
		a.startsWith("a", 1);
		// 是否以a结尾
		a.endsWith("a");
		
		// 将字符串连接到a后面
		a.concat("我是后连上的");
		
		// 字符串a是否包含"bcd",返回boolean
		a.contains("bcd");
		
		// 将字符串a中的小写都转换成大写
		a.toUpperCase();
		System.out.println(b.toUpperCase());
		
		// 将字符串a中的大写都转换成小写
		a.toLowerCase();
		
		// 得到a字符串的字符数组
		char chs[] = a.toCharArray();
		System.out.println(Arrays.toString(chs));
		
		// 涉及到编码转换的
		byte bytes [] = b.getBytes();
		
		String aa = new String(bytes,"unicode");
		
		System.out.println(aa);
	}
}
