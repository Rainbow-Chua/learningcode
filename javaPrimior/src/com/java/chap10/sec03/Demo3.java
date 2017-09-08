package com.java.chap10.sec03;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Demo3 {

	public static void main(String[] args) throws Exception {
		File file=new File("D://java创建的目录//java创建的文件.txt");
		InputStream inputStream=new FileInputStream(file);
		int fileLength=(int)file.length();
		char b[]=new char[fileLength];
		int temp=0;
		int len=0;
		while((temp=inputStream.read())!=-1){
			//一个个字节读取，放入b字节数组
			b[len++]=(char)temp;
		}
		inputStream.close();//关闭输入流
		System.out.println("读取到的内容是："+new String(b));
	}
}
