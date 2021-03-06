package marble.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.*;
import javax.swing.event.*;

import marble.model.Charcter;
import marble.run.TestGUI;
import marble.controller.*;

public class PageLogIn extends JPanel {

	private Charcter c;
	private JLabel titleBL, titleL, loginL, idL, pwdL;
	private JTextField tfID, tfPWD;
	private JButton buttonLogin, buttonJoin;
	private JPanel panel1, panel2;
	private MainFrame m;
	private ClientBackground client;

	public PageLogIn(MainFrame m) {

		this.setSize(new Dimension(1200, 800));

		this.setLayout(null);

		titleL = new JLabel("로그인");
		idL = new JLabel("ID");
		pwdL = new JLabel("PWD");
		tfID = new JTextField(7);
		tfPWD = new JTextField(7);
		buttonLogin = new JButton("Login");
		buttonJoin = new JButton("Join");

		// 블루마블
		ImageIcon title = new ImageIcon("title.png");
		titleBL = new JLabel(title);
		titleBL.setBounds(360, 140, 452, 250);
		
		// 로그인
		titleL.setFont(new Font("SansSerif", Font.BOLD, 20));
		titleL.setSize(80, 80);
		titleL.setLocation(560, 400);

		// 아이디 입력
		idL.setSize(20, 20);
		idL.setLocation(480, 470);
		tfID.setSize(100, 20);
		tfID.setLocation(520, 470);
		tfID.setNextFocusableComponent(tfPWD);

		// 패스워드 입력
		pwdL.setSize(40, 20);
		pwdL.setLocation(480, 490);
		tfPWD.setSize(100, 20);
		tfPWD.setLocation(520, 490);
		tfPWD.setNextFocusableComponent(buttonLogin);

		// 버튼
		buttonLogin.setBounds(40, 40, 65, 40);
		buttonLogin.setLocation(630, 470);
		buttonLogin.setBackground(new Color(176, 196, 222));
		buttonLogin.setNextFocusableComponent(buttonJoin);
		buttonLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = 0, i =1;
				client = getClient();
				PageGame gamePanel = (PageGame) m.getPan3();
				try {
					client.loginTry(tfID.getText() + " " + tfPWD.getText());
					Thread.sleep(3000);
					System.out.println(answer = client.getButtonResult());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				switch (answer) {
				case 0:
					JOptionPane.showMessageDialog(tfID.getParent(), "회원 정보가 일치하지 않습니다.");
					break;

				case 1:
					//JOptionPane.showMessageDialog(tfID.getParent(), "로그인 성공"); 에러
					c = new Charcter(i, tfID.getText(), 4000000, 0, false, true, 0, 0);
					
					break;
				}
			}
		});
		buttonJoin.setBounds(40, 40, 175, 40);
		buttonJoin.setLocation(520, 520);
		buttonJoin.setBackground(new Color(52, 200, 233));
		buttonJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				m.getCardLayout().show(m.getContentPane(), "Join");
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

	}

	public ClientBackground getClient() {
		return client;
	}

	public void setClient(ClientBackground client) {
		this.client = client;
	}

	public JTextField getTfID() {
		return this.tfID;
	}

}
