package com.java.chap9.sec05;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JTextFieldTest {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setTitle("JTextField����");//������������
		jFrame.setLayout(new GridLayout(1, 2, 10, 10));
		JLabel jLabel=new JLabel("�û���");
		JTextField jTextField=new JTextField();
		jFrame.add(jLabel);
		jFrame.add(jTextField);
		jFrame.setLocation(300,200);//����������ʼλ��
		jFrame.setSize(60,70);//����������С
		jFrame.setVisible(true);//��������ʾ
		jFrame.getContentPane().setBackground(Color.CYAN);//���ñ�����ɫ
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رհ�ť���������˳�
	}
}
