package com.java.chap10.sec03;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Demo3 {

	public static void main(String[] args) throws Exception {
		File file=new File("D://java������Ŀ¼//java�������ļ�.txt");
		InputStream inputStream=new FileInputStream(file);
		int fileLength=(int)file.length();
		char b[]=new char[fileLength];
		int temp=0;
		int len=0;
		while((temp=inputStream.read())!=-1){
			//һ�����ֽڶ�ȡ������b�ֽ�����
			b[len++]=(char)temp;
		}
		inputStream.close();//�ر�������
		System.out.println("��ȡ���������ǣ�"+new String(b));
	}
}
