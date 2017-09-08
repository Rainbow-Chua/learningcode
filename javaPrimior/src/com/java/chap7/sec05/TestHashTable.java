package com.java.chap7.sec05;

import java.util.Hashtable;
import java.util.Iterator;


public class TestHashTable {

	public static void main(String[] args) {
		/*
		 * Hashtable<K,V>
		 * 此类实现一个哈希表，该哈希表将键映射到相
		 * 应的值。任何非 null 对象都可以用作键或值。
		 * 同步，迭代器快速失败
		 */
		  Hashtable<String, Integer> numbers=new Hashtable<String, Integer>();
		   numbers.put("two", 2);
		   numbers.put("three", 3);
		   numbers.put("one", 1);
			Iterator<String> it=numbers.keySet().iterator();//获取key的集合再获取迭代器
			while(it.hasNext()){
				String key=it.next();
				Integer s1=numbers.get(key);
				System.out.println(s1);
			}
	}
}
