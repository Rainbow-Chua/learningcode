package com.java.chap8.sec02;

public class Thread1 extends Thread{

	private int baoZi=1;
	private String threadName;
	private Thread1(String threadName){
		super();
		this.threadName=threadName;
	}
	@Override
	public void run() {
		while(baoZi<=10){
			System.out.println(threadName+"�Ե�"+baoZi+"����");
			baoZi++;
		}
	}
	public static void main(String[] args) {
		Thread1 t11=new Thread1("�����߳�");
		Thread1 t1=new Thread1("�����߳�");
		t11.start();
		t1.start();
	}
}
