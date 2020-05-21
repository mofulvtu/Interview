package com.liuzg.interview.design_patterns.singleton;

/**
 * ����ģʽ2������ʽ 
 * @author ������
 */
public class SingleTon2 {

	// 1.˽�л������������ⲿ�޷�����
	private SingleTon2() {

	}

	// 2�������ڲ�����ʵ����˽�л��˶���ͨ�������ķ��������ã�
	private static SingleTon2 instance = new SingleTon2();

	// 3���˹�������ֻ�����������ã����б�������Ϊstatic��
	// ���Ҫ�����ʵ��Ҳ����Ϊstatic����̬����ֻ�ܵ��þ�̬����
	public static SingleTon2 getInstance() {
		return instance;
	}

}
