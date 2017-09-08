package com.java.chap7.sec04;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class TestLinkedHashSet {

	public static void main(String[] args) {
		/*
		 * 相比HashSet
		 * 有序且顺序不受重新插入的影响
		 * 注意，此实现不是同步的。如果多个线程同时访问链接的哈希 set，而其中至少
		 * 一个线程修改了该 set，则它必须 保持外部同步。这一般通过对
		 * 自然封装该 set 的对象进行同步操作来完成。如果不存
		 * 在这样的对象，则应该使用 Collections.synchronizedSet 方
		 * 法来“包装”该 set。最好在创建时完成这一操作，以防止意外
		 * 的非同步访问： 
		 * Set s = Collections.synchronizedSet(new LinkedHashSet(...));
		 */
		LinkedHashSet<String> lhs=new LinkedHashSet<String>();
		lhs.add("2");
		lhs.add("3");
		lhs.add("4");
		lhs.add("1");
		lhs.add("3");
		System.out.println(lhs.hashCode());
		for(String s:lhs){
			System.out.println(s);
		}
		/*
		 * 此类的 iterator 方法返回的迭代器是快速失败 的：
		 * 在迭代器创建之后，如果对 set 进行修改，除非通过迭代器自身的 remove 方法，其
		 * 他任何时间任何方式的修改，迭代器都将
		 * 抛出 ConcurrentModificationException。因此，面对并发
		 * 的修改，迭代器很快就会完全失败，而不冒将来不确定的时间
		 * 任意发生不确定行为的风险。 
		 */
		Iterator<String> it=lhs.iterator();
		lhs.add("s");
		lhs.remove("3");
		while(it.hasNext()){
			try {
				String s=it.next();
				System.out.println(s);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				break;
			}
		}
	}
}
