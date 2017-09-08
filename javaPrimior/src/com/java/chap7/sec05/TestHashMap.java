package com.java.chap7.sec05;

import java.util.HashMap;
import java.util.Iterator;

import com.java.chap7.sec01.Student;

public class TestHashMap {

	public static void main(String[] args) {
		/*
		 * HashMapʵ����Map�ӿڣ�Map�ӿڶԼ�ֵ�Խ���ӳ�䡣Map�в������ظ��ļ���Map�ӿ�������������ʵ�֣�
		 * HashMap��TreeMap��TreeMap�����˶�������д��򣬶�HashMap���ܡ�HashMap�������ֵΪnull��
		 * HashMap�Ƿ�synchronized�ģ���collection����ṩ�����ܱ�֤HashMap
		 * synchronized����������߳�ͬʱ����HashMapʱ���ܱ�ֻ֤��һ���̸߳���Map��
		 */
		HashMap<String, Student> hm = new HashMap<String, Student>();
		hm.put("1", new Student("zhangsan", 10));
		hm.put("2", new Student("zhangsi", 10));
		hm.put("3", new Student("zhangwu", 10));
		hm.put("4", new Student("zhangliu", 10));

		// ͨ��key��ȡvalue
		Student s = hm.get("1");
		System.out.println(hm.hashCode() + s.getName());

		Iterator<String> it = hm.keySet().iterator();// ��ȡkey�ļ����ٻ�ȡ������
		while (it.hasNext()) {
			String key = it.next();
			Student s1 = hm.get(key);
			System.out.println(s1.getName());
		}
	}
}
