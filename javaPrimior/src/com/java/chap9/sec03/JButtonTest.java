package com.java.chap9.sec03;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setTitle("JButton测试");//设置容器标题
		JButton jb=new JButton("按钮");
		jFrame.add(jb);
		jFrame.setLocation(300,200);//设置容器初始位置
		jFrame.setSize(600,700);//设置容器大小
		jFrame.setVisible(true);//让容器显示
		jFrame.getContentPane().setBackground(Color.blue);//设置背景颜色
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭按钮点击后程序退出
	}
}
