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
		System.out.println("���ڹرա�����");
	}
	
}
public class EventTest3 {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame("Swing�¼�����");
//		MyWindowAdapter myWindowAdapter=new MyWindowAdapter();
//		jFrame.addWindowListener(myWindowAdapter);
		jFrame.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.out.println("���ڹرա�����");
			}
			
		});
		jFrame.setLocation(300,200);//����������ʼλ��
		jFrame.setSize(250,150);//����������С
		jFrame.setVisible(true);//��������ʾ
		jFrame.getContentPane().setBackground(Color.CYAN);//���ñ�����ɫ
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رհ�ť���������˳�
	}
}
