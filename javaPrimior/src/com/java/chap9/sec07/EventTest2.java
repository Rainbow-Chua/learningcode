package com.java.chap9.sec07;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
//class MyWindowListener implements WindowListener{
//
//
//	@Override
//	public void windowOpened(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("窗口被打开");
//		
//	}
//
//	@Override
//	public void windowClosing(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("窗口正在被关闭");
//	}
//
//	@Override
//	public void windowClosed(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("窗口被关闭");
//	}
//
//	@Override
//	public void windowIconified(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("窗口最小化");
//	}
//
//	@Override
//	public void windowDeiconified(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("窗口从最小化被恢复");
//	}
//
//	@Override
//	public void windowActivated(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("窗口被选中");
//	}
//
//	@Override
//	public void windowDeactivated(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("窗口选中被取消");
//	}
//	
//}
public class EventTest2 {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
//		MyWindowListener myWindowListener= new MyWindowListener();
//		jFrame.addWindowListener(myWindowListener);
		jFrame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("窗口被打开");
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("窗口正在被关闭");
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("窗口被关闭");
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("窗口最小化");
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("窗口从最小化被恢复");
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("窗口被选中");
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("窗口选中被取消");
			}
		});
		jFrame.setTitle("Swing事件测试");//设置容器标题
		jFrame.setLocation(300,200);//设置容器初始位置
		jFrame.setSize(250,150);//设置容器大小
		jFrame.setVisible(true);//让容器显示
		jFrame.getContentPane().setBackground(Color.CYAN);//设置背景颜色
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭按钮点击后程序退出
	}
}
