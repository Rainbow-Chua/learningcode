package com.java.chap9.sec04;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setTitle("BorderLayout测试");//设置容器标题
		jFrame.setLayout(new BorderLayout(15,15));

		jFrame.add(new JButton("东"),BorderLayout.EAST);
		jFrame.add(new JButton("西"),BorderLayout.WEST);
		jFrame.add(new JButton("南"),BorderLayout.SOUTH);
		jFrame.add(new JButton("北"),BorderLayout.NORTH);
		jFrame.add(new JButton("中"),BorderLayout.CENTER);
		jFrame.setLocation(300,200);//设置容器初始位置
		jFrame.setSize(600,700);//设置容器大小
		jFrame.setVisible(true);//让容器显示
		jFrame.getContentPane().setBackground(Color.blue);//设置背景颜色
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭按钮点击后程序退出
	}
}
