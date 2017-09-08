package com.java.chap10.sec04;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class Demo3 {
	public static void main(String[] args) throws Exception {
		File file=new File("D://java创建的目录//java创建的文件.txt");
		Writer out=new FileWriter(file,true);//true为追加 
		String str="我爱中华";
		out.write(str);//将字符串写入输出流
		out.append(str);//追加函数
		out.close();
	}
}
