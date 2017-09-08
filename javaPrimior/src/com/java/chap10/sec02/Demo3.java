package com.java.chap10.sec02;

import java.io.File;
/*
 * 遍历文件
 */
public class Demo3 {

	public static void main(String[] args) {
		File file=new File("E:\\JAVA\\视频教程");
		File files[]=file.listFiles();
		for(File f:files){
			System.out.println(f.toString());
		}
	}
}
