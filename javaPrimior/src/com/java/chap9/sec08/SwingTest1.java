package com.java.chap9.sec08;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SwingTest1 {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame("Swing�ۺ�ʾ������");
		jFrame.setLayout(null);//ʹ�þ��Բ���
		JTextField num1=new JTextField();
		JTextField num2=new JTextField();
		JTextField result=new JTextField();
		String fuHao[]={"+","-","*","/"};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox jcb=new JComboBox(fuHao);
//		JLabel fuHao=new JLabel("+",JLabel.CENTER);
		JButton jb=new JButton("=");
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String num11=num1.getText();
				String num22=num2.getText();
				int result0 = 0;
				switch(jcb.getSelectedItem().toString()){
				case "+":
					result0=Integer.parseInt(num11)+Integer.parseInt(num22);
					result.setText(String.valueOf(result0));
					break;
				case "-":
					result0=Integer.parseInt(num11)-Integer.parseInt(num22);
					result.setText(String.valueOf(result0));
					break;
				case "*":
					result0=Integer.parseInt(num11)*Integer.parseInt(num22);
					result.setText(String.valueOf(result0));
					break;
				case "/":
					if(0!=Integer.parseInt(num22)){
						float result1=0.0f;
						result1=Float.parseFloat(num11)/Float.parseFloat(num22);//Integer.parseInt(num11)/Integer.parseInt(num22);
						result.setText(String.valueOf(result1));
					}else{
						JOptionPane.showMessageDialog(null, "��������Ϊ0");
					}
				}
			}
		});
		num1.setBounds(20, 30, 50, 25);
//		fuHao.setBounds(80, 30, 40, 25);
		num2.setBounds(130, 30, 50, 25);
		jb.setBounds(190, 30, 50, 25);
		result.setBounds(250, 30, 100, 25);
		jcb.setBounds(80, 30, 40, 25);
//		jFrame.add(fuHao);
		jFrame.add(jcb);
		jFrame.add(num1);
		jFrame.add(num2);
		jFrame.add(jb);
		jFrame.add(result);
		jFrame.setLocation(300,200);//����������ʼλ��
		jFrame.setSize(400,150);//����������С
		jFrame.setVisible(true);//��������ʾ
		jFrame.getContentPane().setBackground(Color.lightGray);//���ñ�����ɫ
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رհ�ť���������˳�
	}
}
