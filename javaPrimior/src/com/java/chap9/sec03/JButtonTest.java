package com.java.chap9.sec03;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setTitle("JButton����");//������������
		JButton jb=new JButton("��ť");
		jFrame.add(jb);
		jFrame.setLocation(300,200);//����������ʼλ��
		jFrame.setSize(600,700);//����������С
		jFrame.setVisible(true);//��������ʾ
		jFrame.getContentPane().setBackground(Color.blue);//���ñ�����ɫ
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رհ�ť���������˳�
	}
}
