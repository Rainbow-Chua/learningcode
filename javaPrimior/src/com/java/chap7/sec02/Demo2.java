package com.java.chap7.sec02;


import java.util.LinkedList;

public class Demo2 {
	public static void print(LinkedList<String> List){
		System.out.println("��ǰԪ��");
		for(int i=0;i!=List.size();i++){
			System.out.print(List.get(i)+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		LinkedList<String> linkedList=new LinkedList<String>();
		linkedList.add("����");
		linkedList.add("��1��");
		linkedList.add("��2��");
		linkedList.add("��3��");
		print(linkedList);
	}
}
