package com.java.chap9.sec02;

import java.awt.Color;

import javax.swing.JFrame;

public class JFrameTest {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setTitle("����һ������");//������������
		jFrame.setLocation(300,200);//����������ʼλ��
		jFrame.setSize(600,700);//����������С
		jFrame.setVisible(true);//��������ʾ
		jFrame.getContentPane().setBackground(Color.blue);//���ñ�����ɫ
	}
}
