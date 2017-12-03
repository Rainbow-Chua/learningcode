package com.rainbowpro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.rainbowpro.dao.BookTypeDao;
import com.rainbowpro.model.BookType;
import com.rainbowpro.util.DbUtil;
import com.rainbowpro.util.StringUtil;

@SuppressWarnings("serial")
public class BookTypeAddInterFrm extends JInternalFrame {
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookTypeAddInterFrm() {
		setFrameIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/rainbow_24px_1139532_easyicon.net.png")));
		getContentPane().setBackground(new Color(141, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 452, 446);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		label.setBounds(85, 152, 98, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u6982\u8FF0\uFF1A");
		label_1.setBounds(85, 202, 98, 15);
		getContentPane().add(label_1);
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setBounds(195, 149, 132, 21);
		bookTypeDescTxt = new JTextArea();
		bookTypeDescTxt.setBounds(195, 201, 132, 102);
		getContentPane().add(bookTypeNameTxt);
		getContentPane().add(bookTypeDescTxt);
		bookTypeNameTxt.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeAddActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/add.png")));
		button.setBounds(85, 337, 93, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/reset.png")));
		button_1.setBounds(221, 337, 93, 23);
		getContentPane().add(button_1);
		//设置文本域边框
		bookTypeDescTxt.setBorder(new LineBorder(new Color(127,157,185),1,false));
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/timg copy.jpg")));
		label_2.setBounds(0, 10, 450, 65);
		getContentPane().add(label_2);
	}
	protected void bookTypeAddActionPerformed(ActionEvent e) {
		String bookTypeName = this.bookTypeNameTxt.getText();
		String bookTypeDesc = this.bookTypeDescTxt.getText();
		if(StringUtil.isEmpty(bookTypeName)){
			JOptionPane.showMessageDialog(null, "图书类别不能为空");
			return;
		}
		BookType bookType = new BookType(bookTypeName, bookTypeDesc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = bookTypeDao.add(con, bookType);
			if(n == 1){
				JOptionPane.showMessageDialog(null, "图书类别添加成功");
			}else{
				JOptionPane.showMessageDialog(null, "图书类别添加失败");
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}finally{
			try {
				dbUtil.close(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	protected void resetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		resetValue();
	}

	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}
}
