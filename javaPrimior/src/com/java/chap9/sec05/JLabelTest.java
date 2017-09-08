package com.java.chap9.sec05;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLabelTest {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setTitle("JLabel测试");//设置容器标题
		JLabel jLabel=new JLabel("JLabel组件",JLabel.CENTER);
		jFrame.add(jLabel);
		jFrame.setLocation(300,200);//设置容器初始位置
		jFrame.setSize(600,700);//设置容器大小
		jFrame.setVisible(true);//让容器显示
		jFrame.getContentPane().setBackground(Color.CYAN);//设置背景颜色
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭按钮点击后程序退出
	}
}
