package com.java.chap10.sec02;

import java.io.File;
import java.io.IOException;

public class Demo2 {

	public static void main(String[] args) throws IOException {
		File file=new File("d://java创建的目录//java创建的文件.txt");
		if(file.exists()){//若文件存在
			boolean b=file.delete();//删除文件
			if(b){
				System.out.println("删除文件成功！");
			}else{
				System.out.println("删除文件失败！");
			}
		}else{
			System.out.println("文件不存在！");
		}
		file=new File("d://java创建的目录");
		if(file.exists()){
			boolean b=file.delete();//删除文件
			if(b){
				System.out.println("删除目录成功！");
			}else{
				System.out.println("删除目录失败！");
			}
		}else{
			System.out.println("目录不存在！");
		}
	}
}
