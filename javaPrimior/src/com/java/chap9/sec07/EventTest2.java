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
//		System.out.println("���ڱ���");
//		
//	}
//
//	@Override
//	public void windowClosing(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("�������ڱ��ر�");
//	}
//
//	@Override
//	public void windowClosed(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("���ڱ��ر�");
//	}
//
//	@Override
//	public void windowIconified(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("������С��");
//	}
//
//	@Override
//	public void windowDeiconified(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("���ڴ���С�����ָ�");
//	}
//
//	@Override
//	public void windowActivated(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("���ڱ�ѡ��");
//	}
//
//	@Override
//	public void windowDeactivated(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("����ѡ�б�ȡ��");
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
				System.out.println("���ڱ���");
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�������ڱ��ر�");
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���ڱ��ر�");
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("������С��");
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���ڴ���С�����ָ�");
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���ڱ�ѡ��");
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("����ѡ�б�ȡ��");
			}
		});
		jFrame.setTitle("Swing�¼�����");//������������
		jFrame.setLocation(300,200);//����������ʼλ��
		jFrame.setSize(250,150);//����������С
		jFrame.setVisible(true);//��������ʾ
		jFrame.getContentPane().setBackground(Color.CYAN);//���ñ�����ɫ
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رհ�ť���������˳�
	}
}
