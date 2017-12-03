package com.javaRainbow.jdbc_demo;

import java.util.Random;

public class Sort {
	/**
	 * ��������Ļ��ֲ���
	 * @param a
	 * @param low
	 * @param high
	 * @return
	 */
	private static int Partition(int a[], int low, int high){
		int p = a[low];
		while(low<high){
			while(low<high&&a[high]>=p) --high;
			a[low]=a[high];
			while(low<high&&a[low]<=p) ++low;
			a[high]=a[low];
		}
		a[low]=p;
		return low;
	}
	/**
	 * ��������
	 * @param a
	 * @param low
	 * @param high
	 */
	private static void QuickSort(int a[], int low, int high){
		if(low<high){
			int pivotpos = Partition(a, low, high);
			QuickSort(a,low,pivotpos-1);
			QuickSort(a,pivotpos+1,high);
		}

	}
	/**
	 * ð�ݺͿ���Ч�ʶԱ�demo
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = new int[100000];
		int b[] = new int[100000];

		int n = 100000;
		for (int k = 0; k < n; k++) {
			a[k] = new Random().nextInt(10);
		}
		for (int k = 0; k < n; k++) {
			b[k] = a[k];
		}
/*		for (int k = 0; k < n; k++) {
			System.out.print(a[k] + " ");
		}*/
		/**
		 * ð�ݷ�����
		 */
		new Thread(){
			public void run(){
				long startTime=System.currentTimeMillis();
				for (int i = 0; i < n - 1; i++) {
					for (int j = 0; j < n - 1 - i; j++) {
						if (a[j] < a[j + 1]) {
							int temp;
							temp = a[j];
							a[j] = a[j + 1];
							a[j + 1] = temp;
						}
					}
				}
				long endTime=System.currentTimeMillis();
				System.out.println("ð�ݷ������㷨��10w��10�������������ʱ��Ϊ(��λ����)"+(endTime-startTime));
			}
		}.start();
		
		new Thread(new Runnable(){
			@Override
			public void run(){
				long startTime=System.currentTimeMillis();
				QuickSort(b,0,b.length-1);
				long endTime=System.currentTimeMillis();
				System.out.println("���������㷨��10w��10�������������ʱ��Ϊ(��λ����)"+(endTime-startTime));
			}
		}).start();

/*		for (int k = 0; k < n; k++) {
			System.out.print(a[k] + " ");
		}*/

	}
}
