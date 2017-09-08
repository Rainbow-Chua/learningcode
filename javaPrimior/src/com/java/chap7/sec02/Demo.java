package com.java.chap7.sec02;

import java.util.ArrayList;

public class Demo {
	public static void print(ArrayList<String> arrayList){
		System.out.println("当前元素");
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
		//添加元素
		arrayList.add("张三");
		arrayList.add("李四");
		arrayList.add("王五");
		print(arrayList);
		//将指定的元素插入到此列表的指定位置
		arrayList.add(1,"小张三");
		print(arrayList);
		//用指定的元素代替指定位置的元素
		arrayList.set(2, "小李四");
		print(arrayList);
		//移除此列表中指定位置的元素
		arrayList.remove(2);
		print(arrayList);
		
	}
}
