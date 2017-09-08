package com.java.chap9.sec07;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class JButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "我被点击了");
	}
	
}
public class EventTest1 {

	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		jFrame.setTitle("Swing事件测试");//设置容器标题
		JPanel jPanel=new JPanel();
		jPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		jPanel.setLayout(new GridLayout(3, 2, 10, 10));
		jFrame.add(jPanel);
		JLabel jLabel1=new JLabel("用户名:");
		JLabel jLabel2=new JLabel("密码:");
		JPasswordField jpf=new JPasswordField();
		JTextField jTextField=new JTextField();
		JButton jb1=new JButton("登录");
		JButton jb2=new JButton("重置");
		JButtonListener jbl=new JButtonListener();
		jb2.addActionListener(jbl);
		jPanel.add(jLabel1);
		jPanel.add(jTextField);
		jPanel.add(jLabel2);
		jPanel.add(jpf);
		jPanel.add(jb1);
		jPanel.add(jb2);
		jFrame.setLocation(300,200);//设置容器初始位置
		jFrame.setSize(250,150);//设置容器大小
		jFrame.setVisible(true);//让容器显示
		jFrame.getContentPane().setBackground(Color.CYAN);//设置背景颜色
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭按钮点击后程序退出
	}
}
