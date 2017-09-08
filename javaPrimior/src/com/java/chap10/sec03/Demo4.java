package com.java.chap10.sec03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Demo4 {

	public static void main(String[] args) throws Exception {
		File file=new File("D://java创建的目录//java创建的文件.txt");
		OutputStream out=new FileOutputStream(file,true);//true为追加，否则覆盖
		String str="略略略略略略！";
		byte b[]=str.getBytes();
		out.write(b);
		out.close();
	}
}
