package com.liuzg.interview.design_patterns.singleton;

/**
 * <pre>
 *  Desc: 单例模式1：懒汉式
 * </pre>
 *
 * @author liuzg
 * @date  2020/5/21 21:30
 **/
public class SingleTon1 {

	// 1.私有化构造器，使得类外部不能够调用此构造器
	private SingleTon1() {
	}

	// 2、在类的内部创建类的实例，私有化此对象，只能通过公共方法来调用
	private static SingleTon1 instance = null;

	// 3、在类的外部通过类名调用此方法获得实例，此公共方法只能通过类来调用，
	//因此必须为static声明，类内部的实例也需要static声明，公用的对象(静态域)
	public static SingleTon1 getInstance() {

		if (instance == null) {
			instance = new SingleTon1();
		}

		return instance;
	}

}
