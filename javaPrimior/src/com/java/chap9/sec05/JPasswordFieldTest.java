package com.java.chap9.sec05;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JPasswordFieldTest {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setTitle("JTextField����");//������������
		jFrame.setLayout(new GridLayout(2, 2, 10, 10));
		JLabel jLabel1=new JLabel("�û���");
		JLabel jLabel2=new JLabel("����");
		JPasswordField jpf=new JPasswordField();
		JTextField jTextField=new JTextField();
		jFrame.add(jLabel1);
		jFrame.add(jTextField);
		jFrame.add(jLabel2);
		jFrame.add(jpf);
		jFrame.setLocation(300,200);//����������ʼλ��
		jFrame.setSize(700,100);//����������С
		jFrame.setVisible(true);//��������ʾ
		jFrame.getContentPane().setBackground(Color.CYAN);//���ñ�����ɫ
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رհ�ť���������˳�
	}
}
