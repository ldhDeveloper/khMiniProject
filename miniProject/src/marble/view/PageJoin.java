package marble.view;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import marble.controller.*;


public class PageJoin extends JPanel {
	
	private JLabel titleBL, titleL, loginL, idL, pwdL1, pwdL2;
	private JTextField tfID, tfPWD1, tfPWD2;
	private JButton buttonCancel, buttonJoin;
	private int result;
	boolean focusId = false;
	private ClientBackground client;
	
	public int loginResult(String name, String pwd) {
		System.out.println("loginResult");
		int result =1;
				
		return result;
		
	}
	
	public JTextField getTfID() {
		return this.tfID;
	}
	
	public JTextField getTfPWD1() {
		return this.tfPWD1;
	}
	
	public JTextField getTfPWD2() {
		return this.tfPWD2;
	}
	
	public PageJoin(MainFrame m) {
		
		this.setSize(new Dimension(1200, 800));
		
		this.setLayout(null);

		titleBL = new JLabel("부루마블");
		titleL = new JLabel("회원가입");
		idL = new JLabel("ID");
		pwdL1 = new JLabel("PWD");
		pwdL2 = new JLabel("PWD 확인");
		tfID = new JTextField(7);
		tfPWD1 = new JTextField(7);
		tfPWD2 = new JTextField(7);
		buttonJoin = new JButton("가입하기");
		buttonCancel = new JButton("가입취소");

		// 블루마블
		titleBL.setFont(new Font("SansSerif", Font.BOLD, 40));
		titleBL.setBounds(100, 100, 400, 200);
		titleBL.setLocation(510, 200);

		// 회원가입
		titleL.setFont(new Font("SansSerif", Font.BOLD, 20));
		titleL.setSize(100, 80);
		titleL.setLocation(550, 400);

		// 아이디입력
		idL.setSize(20, 20);
		idL.setLocation(520, 480);
		tfID.setSize(100, 20);
		tfID.setLocation(580, 480);

		// 패스워드, 패스워드확인입력
		pwdL1.setSize(40, 20);
		pwdL1.setLocation(520, 500);
		tfPWD1.setSize(100, 20);
		tfPWD1.setLocation(580, 500);
		pwdL2.setSize(60, 20);
		pwdL2.setLocation(520, 520);
		tfPWD2.setSize(100, 20);
		tfPWD2.setLocation(580, 520);
		// 회원로그인 동작용 KeyListener

		// 버튼
		buttonJoin.setBounds(40, 40, 175, 30);
		buttonJoin.setLocation(510, 550);
		buttonJoin.setBackground(new Color(35, 144, 255));
		buttonJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				client = getClient();
				
				if (tfPWD1.getText().equals(tfPWD2.getText()))
					try {
						
						client.recordTry(tfID.getText() + " " + tfPWD1.getText());
						
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						result = client.getButtonResult();
						
						switch (result) {
						case 0:
							JOptionPane.showMessageDialog(tfID.getParent(), "잘못된 입력이 존재합니다.");
							break;
						case 1:
							System.out.println("회원가입 성공");
							JOptionPane.showMessageDialog(tfID.getParent(), "회원 가입 성공");
							m.getCardLayout().show(m.getContentPane(), "Login");
							break;
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				else
					JOptionPane.showMessageDialog(tfID.getParent(), "비밀번호와 확인문자가 일치하지 않습니다..");
				
				
			}
		});
		buttonCancel.setBounds(40, 40, 175, 30);
		buttonCancel.setLocation(510, 590);
		buttonCancel.setBackground(Color.GRAY);
		buttonCancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
							m.getCardLayout().show(m.getContentPane(), "Login");
			}
			
		});
		
		this.add(titleBL);
		this.add(titleL);
		this.add(idL);
		this.add(tfID);
		this.add(pwdL1);
		this.add(tfPWD1);
		this.add(pwdL2);
		this.add(tfPWD2);
		this.add(buttonJoin);
		this.add(buttonCancel);
		
		
		}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public ClientBackground getClient() {
		return client;
	}
	public void setClient(ClientBackground client) {
		this.client = client;
	}
		
		
	}


