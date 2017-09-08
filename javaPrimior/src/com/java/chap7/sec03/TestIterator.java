package com.java.chap7.sec03;

import java.util.Iterator;
import java.util.LinkedList;

import com.java.chap7.sec01.Student;

public class TestIterator {
	public static void main(String[] args) {
		LinkedList<Student> list=new LinkedList<Student>();
		list.add(new Student("张三",10));
		list.add(new Student("张s",10));
		list.add(new Student("张w",10));
		
		Iterator<Student> it=list.iterator();//返回一个迭代器
		while(it.hasNext()){
			Student s=it.next();
			System.out.println("姓名:"+s.getName());
		}
	}
}
