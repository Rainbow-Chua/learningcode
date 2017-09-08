package com.java.chap7.sec03;

import java.util.Iterator;
import java.util.LinkedList;

import com.java.chap7.sec01.Student;

public class TestIterator {
	public static void main(String[] args) {
		LinkedList<Student> list=new LinkedList<Student>();
		list.add(new Student("����",10));
		list.add(new Student("��s",10));
		list.add(new Student("��w",10));
		
		Iterator<Student> it=list.iterator();//����һ��������
		while(it.hasNext()){
			Student s=it.next();
			System.out.println("����:"+s.getName());
		}
	}
}