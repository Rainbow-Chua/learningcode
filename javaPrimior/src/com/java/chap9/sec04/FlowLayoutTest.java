package com.java.chap9.sec04;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * FlowLayout��ʽ����
 * @author Useradmin
 *
 */

public class FlowLayoutTest {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setTitle("JButton����");//������������
		jFrame.setLayout(new FlowLayout(FlowLayout.LEFT,15,15));
		JButton jb=null;
		for(int i=0;i!=9;i++){
			jb=new JButton("button"+i);
			jFrame.add(jb);
		}
		jFrame.add(jb);
		jFrame.setLocation(300,200);//����������ʼλ��
		jFrame.setSize(600,700);//����������С
		jFrame.setVisible(true);//��������ʾ
		jFrame.getContentPane().setBackground(Color.blue);//���ñ�����ɫ
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رհ�ť���������˳�
	}
}
