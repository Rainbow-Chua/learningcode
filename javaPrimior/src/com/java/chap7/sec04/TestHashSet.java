package com.java.chap7.sec04;

import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet {

	public static void main(String[] args) {
		/*
		 * �ص㣺
		 * 1��HashSet�������
		 * 2�����������ظ�ֵ
		 */
		HashSet<String> hs=new HashSet<String>();
		hs.add("4");
		hs.add("4");
		hs.add("3");
		hs.add("5");
		hs.add("2");
		hs.add("1");
		/*
		 * ��Iterator��������
		 */
		Iterator<String> it=hs.iterator();
		while(it.hasNext()){
			String s=it.next();
			System.out.println(s);}
	}
}
