package com.java.chap9.sec06;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JPanelTest {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setTitle("JPanel����");//������������
		JPanel jPanel=new JPanel();
		jPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		jPanel.setLayout(new GridLayout(3, 2, 10, 10));
		jFrame.add(jPanel);
		JLabel jLabel1=new JLabel("�û���:");
		JLabel jLabel2=new JLabel("����:");
		JPasswordField jpf=new JPasswordField();
		JTextField jTextField=new JTextField();
		JButton jb1=new JButton("��¼");
		JButton jb2=new JButton("����");
		jPanel.add(jLabel1);
		jPanel.add(jTextField);
		jPanel.add(jLabel2);
		jPanel.add(jpf);
		jPanel.add(jb1);
		jPanel.add(jb2);
		jFrame.setLocation(300,200);//����������ʼλ��
		jFrame.setSize(250,150);//����������С
		jFrame.setVisible(true);//��������ʾ
		jFrame.getContentPane().setBackground(Color.CYAN);//���ñ�����ɫ
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رհ�ť���������˳�
	}
}
