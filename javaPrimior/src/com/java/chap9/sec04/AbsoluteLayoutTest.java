package com.java.chap9.sec04;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AbsoluteLayoutTest {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setTitle("���Բ��ֲ���");//������������
		jFrame.setLayout(null);
		JButton jb1=new JButton("a");
		JButton jb2=new JButton("a");
		jb1.setBounds(50, 10, 100, 20);
		jb2.setBounds(100, 20, 100, 20);
		jFrame.add(jb1);
		jFrame.add(jb2);
		jFrame.setLocation(300,200);//����������ʼλ��
		jFrame.setSize(600,700);//����������С
		jFrame.setVisible(true);//��������ʾ
		jFrame.getContentPane().setBackground(Color.blue);//���ñ�����ɫ
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رհ�ť���������˳�
	}
}
