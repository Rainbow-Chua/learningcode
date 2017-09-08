package com.java.chap7.sec04;

import java.util.TreeSet;

public class TestTreeSet {

	public static void main(String[] args) {
		/*
		 * ���� TreeMap �� NavigableSet ʵ�֡�ʹ��Ԫ�ص���Ȼ˳���Ԫ�ؽ�����
		 * �򣬻��߸��ݴ��� set ʱ�ṩ�� Comparator �������򣬾���ȡ����ʹ�õĹ��췽����
		 * ��ʵ��Ϊ����������add��remove �� contains���ṩ�ܱ�֤�� log(n) ʱ�俪����  
		 */
		TreeSet<String> ts=new TreeSet<String>();
		ts.add("4");
		ts.add("6");
		ts.add("P");
		ts.add("2");
		ts.add("A");
		ts.add("8");
		System.out.println(ts.hashCode());
		for(String s:ts){
			System.out.println(s);
		}
		/*
		 * ��LinkedHHashSet��ͬ ����ͬ����iterator����ʧ��
		 */
	}
}
