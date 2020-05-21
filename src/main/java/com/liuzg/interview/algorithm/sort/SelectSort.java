package com.liuzg.interview.algorithm.sort;

/**
 * ��ѡ������
 * 
 * ����˼�룺
 * ��Ҫ�����һ�����У�ѡ����С��һ�������һ��λ�õ���������
 * Ȼ����ʣ�µ�������������С����ڶ���λ�õ���������
 * ���ѭ���������ڶ����������һ����Ϊֹ��
 * 
 * @author ������
 */
public class SelectSort {

	public static void main(String[] args) {
		SortInputAndOutput sort = new SortInputAndOutput();
		// int arr[] = sort.getArr();
		int arr[] = sort.getRandom();

		long start = System.currentTimeMillis();

		int position = 0;
		for (int i = 0; i < arr.length; i++) {
			int j = i + 1;
			position = i;
			int temp = arr[i];
			for (; j < arr.length; j++) {
				if (arr[j] < temp) {
					temp = arr[j];
					position = j;
				}
			}
			arr[position] = arr[i];
			arr[i] = temp;
		}

		long end = System.currentTimeMillis();
		System.out.println("��ѡ�������ʱ��" + (end - start));// ��ѡ�������ʱ��45ms

		// sort.output(arr);
	}

}
