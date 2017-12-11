package com.lanou3g.string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringDemo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String a = "   abadefg   ";
		String b = "��������";
		
		// ȥ���ַ���ǰ��Ŀո�
		// �������a�ı�,ֻ��������
		// ����������Ҫ�������ֵ��a
		a = a.trim();
		
		// ��ȡ�ַ�������
		System.out.println(a.length());
		System.out.println(b.length());
		
		// �滻,��a�滻��h
		System.out.println(a.replace("a", "h464"));
		System.out.println(a);
		System.out.println(a.replace("ba", "qwe"));
		System.out.println(a);
		a.replace("de", "asd");
		System.out.println(a);
		System.out.println(b.replace("����", "��"));
		// ���Ᵽ��:
		// 1,����ִ�к�,a��ֵ��ʲô,
		// 2.Ϊʲô�����ֵ,
		// 3.�滻ǰ���ֵ�Ƿ��б���
		// �滻��ķ���ֵ���Ǳ任ֵ,������ǽ��
		// ���Ƕ�����Ӹ�ֵ����
		
		// ȡ�ַ����е��Ӵ�
		// ��0λ�ÿ�ʼ,ȡ��2
		// ����һ������ҿ�������
		// [0,3) ���Ծ��Ǵ�0ȡ��2
		System.out.println(a.substring(0, 3));
		
		// ȡ�ַ����е��Ӵ�
		// ��4��ʼһֱȡ��ĩβ
		System.out.println(a.substring(4));
		
		//�ָ��ַ���
		// ��eΪ�����ָ��ַ���
		// ��õ�һ���ַ���������
		System.out.println(a.split("e"));
		System.out.println(Arrays.toString(a.split("e")));
		
		// �ж������ַ����������Ƿ����
		System.out.println(a.equals("bcd"));
		// �ж������ַ����������Ƿ���Ȳ����Դ�Сд
		System.out.println(a.equalsIgnoreCase("abaDeFg"));
		
		// ��ȡ��һ���ַ�e��a����ַ����е�λ��
		// ���������e,�򷵻�-1
		int index = a.indexOf('a');
		System.out.println(index);
		
		// ��ȡindexλ�õ��ַ�
		// �����index��ֵһ��Ҫ���ַ���������
		// ����ᱨ��
		char qwe = a.charAt(4);
		a.charAt(index);
		System.out.println(a.charAt(5));
		
		// �Ƿ���a��ͷ,����boolean��true��false
		a.startsWith("a");
		a.startsWith("a", 1);
		// �Ƿ���a��β
		a.endsWith("a");
		
		// ���ַ������ӵ�a����
		a.concat("���Ǻ����ϵ�");
		
		// �ַ���a�Ƿ����"bcd",����boolean
		a.contains("bcd");
		
		// ���ַ���a�е�Сд��ת���ɴ�д
		a.toUpperCase();
		System.out.println(b.toUpperCase());
		
		// ���ַ���a�еĴ�д��ת����Сд
		a.toLowerCase();
		
		// �õ�a�ַ������ַ�����
		char chs[] = a.toCharArray();
		System.out.println(Arrays.toString(chs));
		
		// �漰������ת����
		byte bytes [] = b.getBytes();
		
		String aa = new String(bytes,"unicode");
		
		System.out.println(aa);
	}
}
