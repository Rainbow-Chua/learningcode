package com.java.chap10.sec03;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		File file = new File("D://java������Ŀ¼//java�������ļ�.txt");
		InputStream in = new FileInputStream(file);
		byte b[] = new byte[(int)file.length()];
		in.read(b);
		in.close();
		System.out.println(new String(b));
	}
}
