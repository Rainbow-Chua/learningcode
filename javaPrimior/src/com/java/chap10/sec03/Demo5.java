package com.java.chap10.sec03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo5 {

	//定义一个带缓冲的输入输出流
	//在内存中开辟了缓冲区，读得多写得快，效率提高
	public static void bufferStream()throws Exception {
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream("D://Office_2010_激活工具.zip"));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("F://复制的文件.zip"));
		int b=0;
		long startTime=System.currentTimeMillis();
		while((b=bis.read())!=-1){
			bos.write(b);
		}
		bis.close();
		bos.close();
		long endTime=System.currentTimeMillis();//结束时间
		System.out.println("缓冲花费的时间是："+(endTime-startTime));
		
	}
	/*
	 * 非缓冲
	 */
	public static void stream() throws Exception {
		InputStream inputStream=new FileInputStream("D://Office_2010_激活工具.zip");
		OutputStream out=new FileOutputStream("F://复制的文件.zip");
		int b=0;
		long startTime=System.currentTimeMillis();
		while((b=inputStream.read())!=-1){
			out.write(b);
		}
		inputStream.close();
		out.close();
		long endTime=System.currentTimeMillis();//结束时间
		System.out.println("非缓冲花费的时间是："+(endTime-startTime));
		
	}
	public static void main(String[] args) throws Exception {
		stream();
//		bufferStream();
//		File file=new File("D://java创建的目录//java创建的文件.txt");
	}
}
