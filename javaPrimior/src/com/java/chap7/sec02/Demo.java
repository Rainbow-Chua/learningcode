package com.java.chap7.sec02;

import java.util.ArrayList;

public class Demo {
	public static void print(ArrayList<String> arrayList){
		System.out.println("��ǰԪ��");
		for(int i=0;i!=arrayList.size();i++){
			System.out.print(arrayList.get(i)+" ");
		}
		System.out.println();
	}
	/**
	 * test ArrayList
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> arrayList=new ArrayList<String>();
		//���Ԫ��
		arrayList.add("����");
		arrayList.add("����");
		arrayList.add("����");
		print(arrayList);
		//��ָ����Ԫ�ز��뵽���б��ָ��λ��
		arrayList.add(1,"С����");
		print(arrayList);
		//��ָ����Ԫ�ش���ָ��λ�õ�Ԫ��
		arrayList.set(2, "С����");
		print(arrayList);
		//�Ƴ����б���ָ��λ�õ�Ԫ��
		arrayList.remove(2);
		print(arrayList);
		
	}
}
