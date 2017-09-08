package com.java.chap7.sec05;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class TestLinkedMap {

	public static void main(String[] args) {
		/*
		 * Map 接口的哈希表和链接列表实现，具有可
		 * 预知的迭代顺序。此实现与 HashMap 的不同
		 * 之处在于，后者维护着一个运行于所有条目的
		 * 双重链接列表。此链接列表定义了迭代顺序，该
		 * 迭代顺序通常就是将键插入到映射中的顺序（
		 * 插入顺序）。注意，如果在映射中重新插入 键，则
		 * 插入顺序不受影响。（如果在调用 m.put(k, v) 前 
		 * m.containsKey(k) 返回了 true，则调用时会将键 k 重新插入到映射 m 中。） 
		 * 非同步，迭代器快速失败
		 */
		LinkedHashMap<String, Integer> numbers=new LinkedHashMap<String, Integer>();
		   numbers.put("one", 1);
		   numbers.put("two", 2);
		   numbers.put("three", 3);
			Iterator<String> it=numbers.keySet().iterator();//获取key的集合再获取迭代器
			while(it.hasNext()){
				String key=it.next();
				Integer s1=numbers.get(key);
				System.out.println(s1);
			}
	}
}
