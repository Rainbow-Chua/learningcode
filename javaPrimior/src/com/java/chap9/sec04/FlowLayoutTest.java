package com.java.chap9.sec04;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * FlowLayout流式布局
 * @author Useradmin
 *
 */

public class FlowLayoutTest {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setTitle("JButton测试");//设置容器标题
		jFrame.setLayout(new FlowLayout(FlowLayout.LEFT,15,15));
		JButton jb=null;
		for(int i=0;i!=9;i++){
			jb=new JButton("button"+i);
			jFrame.add(jb);
		}
		jFrame.add(jb);
		jFrame.setLocation(300,200);//设置容器初始位置
		jFrame.setSize(600,700);//设置容器大小
		jFrame.setVisible(true);//让容器显示
		jFrame.getContentPane().setBackground(Color.blue);//设置背景颜色
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭按钮点击后程序退出
	}
}
