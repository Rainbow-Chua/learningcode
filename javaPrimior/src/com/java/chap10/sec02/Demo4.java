package com.java.chap10.sec02;

import java.io.File;
/**
 * �ݹ�����ļ�Ŀ¼
 * @author Useradmin
 *
 */
public class Demo4 {

	public static void listFile(File file) {
		if(file!=null){
			if(file.isDirectory()){
				File f[]=file.listFiles();
				if(f!=null){
					for(File f1:f){
						listFile(f1);
					}
				}
			}else{
				System.out.println(file);
			}
		}
	}
	public static void main(String[] args) {
		File file=new File("D:\\java������Ŀ¼");
		listFile(file);
	}
}
