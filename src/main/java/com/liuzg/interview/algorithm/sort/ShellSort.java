package com.liuzg.interview.algorithm.sort;

/**
 * ϣ������
 * 
 * ����˼�룺 
 * �㷨�Ƚ�Ҫ�����һ������ĳ������d(n/2,nΪҪ����ĸ���)�ֳ������飬ÿ���м�¼��
 * �±����d����ÿ����ȫ��Ԫ�ؽ���ֱ�Ӳ�������Ȼ������һ����С������(d/2)����
 * ���з��飬��ÿ�����ٽ���ֱ�Ӳ�������
 * ����������1ʱ������ֱ�Ӳ��������������ɡ�
 * 
 * @author ������
 * 
 */
public class ShellSort {

	public static void main(String[] args) {
		SortInputAndOutput sort = new SortInputAndOutput();
		int[] arr = sort.getRandom();// ��ȡ��Ҫ���е���������
		int d = arr.length;
		int temp = 0;
		long start = System.currentTimeMillis();

		while (true) {
			d = d / 2;
			for (int k = 0; k < d; k++) {
				for (int i = k + d; i < arr.length; i += d) {
					int j = i - d;
					temp = arr[i];
					for (; j >= 0 && temp < arr[j]; j--) {
						arr[j + d] = arr[j];
					}
					arr[j + d] = temp;
				}
			}
			if (d == 1) {
				break;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("ϣ�������ʱ��" + (end - start));//ϣ�������ʱ��45ms
		//sort.output(arr);

	}

}
