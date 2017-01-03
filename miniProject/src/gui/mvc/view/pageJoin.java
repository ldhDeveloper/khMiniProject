package gui.mvc.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class pageJoin extends JFrame {
	
	private JLabel titleBL, titleL, loginL, idL, pwdL1, pwdL2;
	private JTextField tfID, tfPWD1, tfPWD2;
	private JButton buttonCancel, buttonJoin;

	public pageJoin(){
		this.setTitle("BlueMarble");
		this.setSize(new Dimension(1200, 800));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		titleBL = new JLabel("블루마블");
		titleL = new JLabel("회원가입");
		idL = new JLabel("ID");
		pwdL1 = new JLabel("PWD");
		pwdL2 = new JLabel("PWD 확인");
		
		
		tfID = new JTextField(7);
		tfPWD1 = new JTextField(7);
		tfPWD2 = new JTextField(7);
		buttonJoin = new JButton("가입하기");
		buttonCancel = new JButton("가입취소");
		
		//블루마블
		titleBL.setFont(new Font("SansSerif", Font.BOLD, 40));
		titleBL.setBounds(100, 100, 400, 200);
		titleBL.setLocation(540, 200);
		
		//회원가입
		titleL.setFont(new Font("SansSerif", Font.BOLD, 20));
		titleL.setSize(100, 80);
		titleL.setLocation(590, 400);
		
		//아이디입력
		idL.setSize(20, 20);
		idL.setLocation(520, 480);
		tfID.setSize(100, 20);
		tfID.setLocation(580, 480);
		
		//패스워드, 패스워드확인입력
		pwdL1.setSize(40, 20);
		pwdL1.setLocation(520, 500);
		tfPWD1.setSize(100, 20);
		tfPWD1.setLocation(580, 500);
		pwdL2.setSize(60, 20);
		pwdL2.setLocation(520, 520);
		tfPWD2.setSize(100, 20);
		tfPWD2.setLocation(580, 520);
		
		//(new Color(176,196,222));
		
		//버튼
		buttonJoin.setBounds(40, 40, 175, 30);
		buttonJoin.setLocation(540, 550);
		buttonJoin.setBackground(new Color(35,144,255));
		
		buttonCancel.setBounds(40, 40, 175, 30);
		buttonCancel.setLocation(540, 590);
		buttonCancel.setBackground(Color.GRAY);
		
		
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
		
		this.setVisible(true);
	}
	


}
