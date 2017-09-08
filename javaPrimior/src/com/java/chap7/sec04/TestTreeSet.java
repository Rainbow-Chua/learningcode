package com.java.chap7.sec04;

import java.util.TreeSet;

public class TestTreeSet {

	public static void main(String[] args) {
		/*
		 * 基于 TreeMap 的 NavigableSet 实现。使用元素的自然顺序对元素进行排
		 * 序，或者根据创建 set 时提供的 Comparator 进行排序，具体取决于使用的构造方法。
		 * 此实现为基本操作（add、remove 和 contains）提供受保证的 log(n) 时间开销。  
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
		 * 与LinkedHHashSet相同 ：非同步，iterator快速失败
		 */
	}
}
