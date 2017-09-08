package com.java.chap9.sec04;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AbsoluteLayoutTest {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setTitle("绝对布局测试");//设置容器标题
		jFrame.setLayout(null);
		JButton jb1=new JButton("a");
		JButton jb2=new JButton("a");
		jb1.setBounds(50, 10, 100, 20);
		jb2.setBounds(100, 20, 100, 20);
		jFrame.add(jb1);
		jFrame.add(jb2);
		jFrame.setLocation(300,200);//设置容器初始位置
		jFrame.setSize(600,700);//设置容器大小
		jFrame.setVisible(true);//让容器显示
		jFrame.getContentPane().setBackground(Color.blue);//设置背景颜色
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭按钮点击后程序退出
	}
}
