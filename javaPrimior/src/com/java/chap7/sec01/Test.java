package com.java.chap7.sec01;

import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		Student student[]=new Student[3];
		student[0]=new Student("张三",4);
		student[1]=new Student("张si",24);
		student[2]=new Student("张wu",3);
		for(Student s:student){
			System.out.println(s.getName());
		}
		LinkedList<Student> list=new LinkedList<Student>();
		for(Student s:student){
			list.add(s);
		}
		for(Student s:list){
			System.out.println(s.getName());
		}
	}
}
