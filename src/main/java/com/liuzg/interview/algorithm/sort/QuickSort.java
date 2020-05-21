package com.liuzg.interview.algorithm.sort;

/**
 * ��������
 * 
 * ����˼�룺
 * ѡ��һ����׼Ԫ�أ�ͨ��ѡ���һ��Ԫ�ػ������һ��Ԫ�أ�ͨ��һ��ɨ�裬���������зֳ������֣�
 * һ���ֱȻ�׼Ԫ��С��һ���ִ��ڵ��ڻ�׼Ԫ�أ���ʱ��׼Ԫ�������ź�������ȷλ�ã�Ȼ������
 * ͬ���ķ��� �ݹ�����򻮷ֵ������֡�
 * 
 * @author ������
 *
 */
public class QuickSort {

	public int adujstArray(int arr[], int left, int right) {
		int i = left, j = right;
		int pivot = arr[left];
		while (i < j) {
			// ����������С��pivot��������arr[i]
			while (i < j && arr[j] >= pivot)
				j--;
			if (i < j) {
				arr[i] = arr[j];// ��arr[j]�arr[i]�У�arr[j]�γ�һ���µĿ�
				i++;
			}

			// ���������Ҵ��ڻ����pivot��������arr[j]
			while (i < j && arr[i] < pivot)
				i++;
			if (i < j) {
				arr[j] = arr[i];// ��arr[i]�arr[j]�У�arr[i]�γ�һ���µĿ�
				j--;
			}

		}
		//�˳�ʱ��i����j����pivot��������
		arr[i] = pivot;

		return i;
	}

	public void quick_sort(int arr[], int left, int right) {
		if (left < right) {
			int i = adujstArray(arr, left, right);
			quick_sort(arr, left, i - 1);
			quick_sort(arr, i+1, right);

		}
	}

	public static void main(String[] args) {
		SortInputAndOutput sort = new SortInputAndOutput();
//		int arr[] = sort.getArr();
		int arr[] = sort.getRandom();
		sort.output(arr);
		QuickSort quickSort = new QuickSort();
		long start = System.currentTimeMillis();
		System.out.println(start);
		quickSort.quick_sort(arr, 0, arr.length - 1);
		
		long end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println("���������ʱ��" + (end-start));//���������ʱ��15ms
		sort.output(arr);
		

	}

}
