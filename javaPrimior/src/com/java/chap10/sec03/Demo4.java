package com.java.chap10.sec03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Demo4 {

	public static void main(String[] args) throws Exception {
		File file=new File("D://java������Ŀ¼//java�������ļ�.txt");
		OutputStream out=new FileOutputStream(file,true);//trueΪ׷�ӣ����򸲸�
		String str="�����������ԣ�";
		byte b[]=str.getBytes();
		out.write(b);
		out.close();
	}
}
