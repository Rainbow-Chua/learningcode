package com.java.chap10.sec04;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class Demo2 {
	public static void main(String[] args) throws Exception {
		File file=new File("D://java������Ŀ¼//java�������ļ�.txt");
		Reader reader=new FileReader(file);
		byte c[]=new byte[1024];
		int temp=0;
		int len=0;
		while((temp=reader.read())!=-1){
			c[len++]=(byte)temp;
		}
		reader.close();
		System.out.println(new String(c,0,len));
	}
}
