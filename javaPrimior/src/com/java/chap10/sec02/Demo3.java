package com.java.chap10.sec02;

import java.io.File;
/*
 * �����ļ�
 */
public class Demo3 {

	public static void main(String[] args) {
		File file=new File("E:\\JAVA\\��Ƶ�̳�");
		File files[]=file.listFiles();
		for(File f:files){
			System.out.println(f.toString());
		}
	}
}
