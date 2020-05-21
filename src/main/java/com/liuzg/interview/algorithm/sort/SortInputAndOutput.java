package com.liuzg.interview.algorithm.sort;

import java.util.Scanner;

public class SortInputAndOutput {
	
	/**
	 * �ӿ���̨��ȡ�ַ�����ת������������
	 * @return
	 */
	public  int[] getArr() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();// ����һ��
		String[] str = s.split(" ");// ת�����ַ�������
		int[] arr = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);// ת������������
		}
		return arr;
	}
	
	/**
	 * �������һ��������
	 * @return
	 */
	public int[] getRandom(){
		int arr[] = new int[10000];
		for(int i =0; i<10000;i++){
			
			arr[i] = (int) (Math.random()*(10000-0+1));
		}
		return arr;
	}
	
	/**
	 * �������õ�����
	 * @param arr
	 */
	public void output(int[] arr){
		for(int i = 0;i < arr.length; i++){
			System.out.println(arr[i]+ " ");
		}
	}

}
