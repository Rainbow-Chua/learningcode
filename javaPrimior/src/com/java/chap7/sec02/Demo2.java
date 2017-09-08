package com.java.chap7.sec02;


import java.util.LinkedList;

public class Demo2 {
	public static void print(LinkedList<String> List){
		System.out.println("当前元素");
		for(int i=0;i!=List.size();i++){
			System.out.print(List.get(i)+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		LinkedList<String> linkedList=new LinkedList<String>();
		linkedList.add("张三");
		linkedList.add("张1三");
		linkedList.add("张2三");
		linkedList.add("张3三");
		print(linkedList);
	}
}
