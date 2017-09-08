package com.java.chap9.sec05;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JTextFieldTest {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setTitle("JTextField测试");//设置容器标题
		jFrame.setLayout(new GridLayout(1, 2, 10, 10));
		JLabel jLabel=new JLabel("用户名");
		JTextField jTextField=new JTextField();
		jFrame.add(jLabel);
		jFrame.add(jTextField);
		jFrame.setLocation(300,200);//设置容器初始位置
		jFrame.setSize(60,70);//设置容器大小
		jFrame.setVisible(true);//让容器显示
		jFrame.getContentPane().setBackground(Color.CYAN);//设置背景颜色
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭按钮点击后程序退出
	}
}
