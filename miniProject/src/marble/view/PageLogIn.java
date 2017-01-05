package marble.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

public class PageLogIn extends JFrame {

	private JLabel titleBL, titleL, loginL, idL, pwdL;
	private JTextField tfID, tfPWD;
	private JButton buttonLogin, buttonJoin;
	private JPanel panel1, panel2;

	public PageLogIn() {
		this.setTitle("BlueMarble");
		this.setSize(new Dimension(1200, 800));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		titleBL = new JLabel("부루마블");
		titleL = new JLabel("로그인");
		idL = new JLabel("ID");
		pwdL = new JLabel("PWD");
		tfID = new JTextField(7);
		tfPWD = new JTextField(7);
		buttonLogin = new JButton("Login");
		buttonJoin = new JButton("Join");

		// 블루마블
		titleBL.setFont(new Font("SansSerif", Font.BOLD, 40));
		titleBL.setBounds(100, 100, 400, 200);
		titleBL.setLocation(510, 200);

		// 로그인
		titleL.setFont(new Font("SansSerif", Font.BOLD, 20));
		titleL.setSize(80, 80);
		titleL.setLocation(560, 400);

		// 아이디 입력
		idL.setSize(20, 20);
		idL.setLocation(480, 470);
		tfID.setSize(100, 20);
		tfID.setLocation(520, 470);

		// 패스워드 입력
		pwdL.setSize(40, 20);
		pwdL.setLocation(480, 490);
		tfPWD.setSize(100, 20);
		tfPWD.setLocation(520, 490);

		// 버튼
		buttonLogin.setBounds(40, 40, 65, 40);
		buttonLogin.setLocation(630, 470);
		buttonLogin.setBackground(new Color(176, 196, 222));
		buttonLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = 0;
				answer = new Member.creat.Member().Login(tfID.getText(), tfPWD.getText());
				switch (answer) {
				case 0:
					JOptionPane.showMessageDialog(tfID.getParent(), "로그인 성공");
					break;
				case 1:
					JOptionPane.showMessageDialog(tfID.getParent(), "회원 정보가 일치하지 않습니다.");
					break;
				}
			}
		});
		buttonJoin.setBounds(40, 40, 175, 40);
		buttonJoin.setLocation(520, 520);
		buttonJoin.setBackground(new Color(30, 144, 255));
		buttonJoin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				}
			});
		this.add(titleBL);
		this.add(titleL);
		this.add(idL);
		this.add(tfID);
		this.add(pwdL);
		this.add(tfPWD);
		this.add(buttonLogin);
		this.add(buttonJoin);

		this.setVisible(true);
	}

}