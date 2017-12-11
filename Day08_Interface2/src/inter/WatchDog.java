package inter;

/**
 * WatchDog类,通过implements关键字
 * 与Work接口产生了关联,导致WathcDog就蛮子了Work这个接口的规范
 * 
 * Implements关键字:实现
 * 通过implements关键字,可以让一个类
 * 实现多个接口,多个接口之间通过逗号分隔
 * 这样就让这个类,满足了接口的规范
 * 也叫做实现了接口
 * 
 * A继承了B,那么A叫做子类,B叫做父类
 * A实现了C,那么A叫做实现类,C叫做接口
 * @author lanou3g
 *
 */
public class WatchDog implements Work{

	@Override
	public void work() {
		System.out.println("我是一直看门狗,我要看门");
	}

	@Override
	public void goHome() {
		System.out.println("我已经看完们了,回家睡觉吃骨头");
	}
	
}
