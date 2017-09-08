package com.java.chap9.sec07;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

class MyWindowAdapter extends WindowAdapter{

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
		System.out.println("窗口关闭。。。");
	}
	
}
public class EventTest3 {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame("Swing事件测试");
//		MyWindowAdapter myWindowAdapter=new MyWindowAdapter();
//		jFrame.addWindowListener(myWindowAdapter);
		jFrame.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.out.println("窗口关闭。。。");
			}
			
		});
		jFrame.setLocation(300,200);//设置容器初始位置
		jFrame.setSize(250,150);//设置容器大小
		jFrame.setVisible(true);//让容器显示
		jFrame.getContentPane().setBackground(Color.CYAN);//设置背景颜色
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭按钮点击后程序退出
	}
}
