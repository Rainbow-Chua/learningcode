package com.java.chap9.sec04;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setTitle("BorderLayout����");//������������
		jFrame.setLayout(new BorderLayout(15,15));

		jFrame.add(new JButton("��"),BorderLayout.EAST);
		jFrame.add(new JButton("��"),BorderLayout.WEST);
		jFrame.add(new JButton("��"),BorderLayout.SOUTH);
		jFrame.add(new JButton("��"),BorderLayout.NORTH);
		jFrame.add(new JButton("��"),BorderLayout.CENTER);
		jFrame.setLocation(300,200);//����������ʼλ��
		jFrame.setSize(600,700);//����������С
		jFrame.setVisible(true);//��������ʾ
		jFrame.getContentPane().setBackground(Color.blue);//���ñ�����ɫ
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رհ�ť���������˳�
	}
}
