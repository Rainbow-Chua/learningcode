package com.java.chap7.sec05;

import java.util.Hashtable;
import java.util.Iterator;


public class TestHashTable {

	public static void main(String[] args) {
		/*
		 * Hashtable<K,V>
		 * ����ʵ��һ����ϣ���ù�ϣ����ӳ�䵽��
		 * Ӧ��ֵ���κη� null ���󶼿�����������ֵ��
		 * ͬ��������������ʧ��
		 */
		  Hashtable<String, Integer> numbers=new Hashtable<String, Integer>();
		   numbers.put("two", 2);
		   numbers.put("three", 3);
		   numbers.put("one", 1);
			Iterator<String> it=numbers.keySet().iterator();//��ȡkey�ļ����ٻ�ȡ������
			while(it.hasNext()){
				String key=it.next();
				Integer s1=numbers.get(key);
				System.out.println(s1);
			}
	}
}
