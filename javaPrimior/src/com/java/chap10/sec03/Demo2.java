package com.java.chap10.sec03;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Demo2 {

	public static void main(String[] args) throws Exception {
		File file=new File("D://java������Ŀ¼//java�������ļ�.txt");
		InputStream inputStream=new FileInputStream(file);
		int fileLength=(int)file.length();
		byte b[]=new byte[fileLength];
		inputStream.read(b);
		inputStream.close();//�ر�������
		System.out.println("��ȡ���������ǣ�"+new String(b));
	}
}