package com.java.chap8.sec01;

public class Demo1 {

	public static void main(String[] args) {
		/*
		 *�̳�Thread��ʵ�ֶ��߳�
		 */
		Music musicThread=new Music();
		Eat eatThread=new Eat();
		musicThread.start();
		eatThread.start();
		
	}
}
