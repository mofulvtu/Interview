package com.liuzg.interview.algorithm.sort;

/**
 * ֱ�Ӳ�������
 * 
 * ����˼�룺 
 * ��Ҫ�����һ�����У�����ǰ��(n-1)[n>=2]�����Ѿ����ź�˳���,
 * ����Ҫ�ѵ�n��������ǰ����������У�ʹ����n����Ҳ���ź�˳��ġ�
 * ��˷���ѭ����ֱ��ȫ���ź�˳��
 * 
 * @author ������
 */
public class InsertSort {

	public static void main(String[] args) {
		SortInputAndOutput sort = new SortInputAndOutput();
/*
 * ����һ��
 * �ҵ��Ѿ��ź�������һλ��Ҫ��������Ƚϣ���������򽻻�ֵ
 * Ȼ������±��ȥ1���ٱȽϣ�ֱ��ȫ���ź���
 */
		int arr[] = sort.getRandom();
		long start = System.currentTimeMillis();
		for (int j = 1; j < arr.length; j++) {// ���ѭ����Ҫ��������仯
			int a = j;// a��ʾ�տ�ʼ�Ƚϵ�λ��
			for (int k = j - 1; k >= 0; k--, a--) {// k��ʾ֮ǰ�ź�������λ��
				int temp = 0;
				if (arr[a] < arr[k]) {// ���Ҫ���������֮ǰ���е�������С������Ҫ����ֵ
					temp = arr[a];
					arr[a] = arr[k];
					arr[k] = temp;
				}

			}
		}
		long end = System.currentTimeMillis();
		//sort.output(arr);
		System.out.println("����һ��ʱ��" + (end - start));
		// ----------------------------------------------------------------------------
/*
 * ��������
 * ������Ҫ�������Ϊ�ڱ�temp2������ѭ��ǰ���źõ����У�ÿ�������ڱ��ȣ�
 * ������ڱ��������һλ�����ճ����ļ�ʹ�ڱ�λ�á�
 */
		long start2 = System.currentTimeMillis();
		int arr2[] = sort.getRandom();
		int temp2 = 0;
		for (int i = 1; i < arr2.length; i++) {//ÿ��Ҫ����������±�
			int j = i - 1;
			temp2 = arr2[i];
			for (; j >= 0 && temp2 < arr2[j]; j--) {
				arr2[j+1] = arr2[j];//������temp2��ֵ����һ��λ��
			}
			arr2[j+1] = temp2;
		}
		long end2 = System.currentTimeMillis();
		//sort.output(arr2);
		System.out.println("��������ʱ��" + (end2 - start2));
	}
	
	
//-------------------------------------------------------------------------
	/**
	 * ���������Աȷ���һЧ�ʸߡ�
	 * ʵ�ʲ���10000��������
	 * ����һ��ʱ��77ms
     * ��������ʱ��57ms
     * ����һ��Ҫ��ͣ�ػ�������Ȼ��λ�Ȼ���ֵЧ�ʸߡ�
	 */

}
