package com.java.chap10.sec04;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class Demo3 {
	public static void main(String[] args) throws Exception {
		File file=new File("D://java������Ŀ¼//java�������ļ�.txt");
		Writer out=new FileWriter(file,true);//trueΪ׷�� 
		String str="�Ұ��л�";
		out.write(str);//���ַ���д�������
		out.append(str);//׷�Ӻ���
		out.close();
	}
}
