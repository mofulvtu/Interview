package com.liuzg.interview.algorithm.sort;

/**
 * ð������
 * 
 * ����˼�룺 ��Ҫ�����һ�����У��Ե�ǰ��δ�ź���ķ�Χ�ڵ�ȫ������
 * ���϶��¶����ڵ����������ν��бȽϺ͵������ýϴ�������³�����С��������ð��
 * ��:ÿ�������ڵ����ȽϺ������ǵ�˳����Ҫ���෴ʱ���ͻ�����
 * 
 * @author ������
 * 
 */
public class BubbingSort {

	public static void main(String[] args) {
		SortInputAndOutput sort = new SortInputAndOutput();
		//int arr[] = sort.getArr();
		int arr[] = sort.getRandom();
		int temp = 0;

		long start = System.currentTimeMillis();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

		}

		long end = System.currentTimeMillis();
		System.out.println("ð�������ʱ��" + (end - start));//ð�������ʱ��160ms
        //sort.output(arr);
	}

}
