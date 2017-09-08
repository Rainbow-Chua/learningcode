package com.java.chap10.sec03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo5 {

	//����һ������������������
	//���ڴ��п����˻����������ö�д�ÿ죬Ч�����
	public static void bufferStream()throws Exception {
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream("D://Office_2010_�����.zip"));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("F://���Ƶ��ļ�.zip"));
		int b=0;
		long startTime=System.currentTimeMillis();
		while((b=bis.read())!=-1){
			bos.write(b);
		}
		bis.close();
		bos.close();
		long endTime=System.currentTimeMillis();//����ʱ��
		System.out.println("���廨�ѵ�ʱ���ǣ�"+(endTime-startTime));
		
	}
	/*
	 * �ǻ���
	 */
	public static void stream() throws Exception {
		InputStream inputStream=new FileInputStream("D://Office_2010_�����.zip");
		OutputStream out=new FileOutputStream("F://���Ƶ��ļ�.zip");
		int b=0;
		long startTime=System.currentTimeMillis();
		while((b=inputStream.read())!=-1){
			out.write(b);
		}
		inputStream.close();
		out.close();
		long endTime=System.currentTimeMillis();//����ʱ��
		System.out.println("�ǻ��廨�ѵ�ʱ���ǣ�"+(endTime-startTime));
		
	}
	public static void main(String[] args) throws Exception {
		stream();
//		bufferStream();
//		File file=new File("D://java������Ŀ¼//java�������ļ�.txt");
	}
}
