package com.java.chap7.sec05;

import java.util.HashMap;
import java.util.Iterator;

import com.java.chap7.sec01.Student;

public class TestHashMap {

	public static void main(String[] args) {
		/*
		 * HashMap实现了Map接口，Map接口对键值对进行映射。Map中不允许重复的键。Map接口有两个基本的实现，
		 * HashMap和TreeMap。TreeMap保存了对象的排列次序，而HashMap则不能。HashMap允许键和值为null。
		 * HashMap是非synchronized的，但collection框架提供方法能保证HashMap
		 * synchronized，这样多个线程同时访问HashMap时，能保证只有一个线程更改Map。
		 */
		HashMap<String, Student> hm = new HashMap<String, Student>();
		hm.put("1", new Student("zhangsan", 10));
		hm.put("2", new Student("zhangsi", 10));
		hm.put("3", new Student("zhangwu", 10));
		hm.put("4", new Student("zhangliu", 10));

		// 通过key获取value
		Student s = hm.get("1");
		System.out.println(hm.hashCode() + s.getName());

		Iterator<String> it = hm.keySet().iterator();// 获取key的集合再获取迭代器
		while (it.hasNext()) {
			String key = it.next();
			Student s1 = hm.get(key);
			System.out.println(s1.getName());
		}
	}
}
