package com.java.chap10.sec03;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		File file = new File("D://java创建的目录//java创建的文件.txt");
		InputStream in = new FileInputStream(file);
		byte b[] = new byte[(int)file.length()];
		in.read(b);
		in.close();
		System.out.println(new String(b));
	}
}
