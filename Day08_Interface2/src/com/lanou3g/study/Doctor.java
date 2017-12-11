package com.lanou3g.study;

import inter.Work;

public class Doctor extends Person implements Work{
	public void work() {
		System.out.println("ÑÌÑÌ¾Æ¾ÆĞÂĞÇ±ù¶¾");
	}

	@Override
	public void goHome() {
		System.out.println("ÀÛËÀ¸öÈË,»Ø¼ÒË¯¾õ");
	}
}
