package com.lanou3g.main;

public class Punctuation {
	public static void main(String[] args) {
		
		String[] a = {"~","!","@","$","%","^","&","*","(",")","_","+","{","}","|",":","<",">","?","`", "-", "=", "[", "]", "2", ";","'",",",".","/", "'", "0", "1"}; 
		System.out.println(a.length);
		int b = 0;
		while(b<=520) {
		int punctuation = (int)(Math.random()*33);
		System.out.print(a[punctuation]);
		b++;
		}
	}
}
