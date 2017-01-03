package gui.mvc.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class pageLogIn extends JFrame {
	
	private JLabel titleBL, titleL, loginL, idL, pwdL;
	private JTextField tfID, tfPWD;
	private JButton buttonLogin, buttonJoin;
	private JPanel panel1, panel2;
	
	public pageLogIn(){
		this.setTitle("BlueMarble");
		this.setSize(new Dimension(1200, 800));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		titleBL = new JLabel("블루마블");
		titleL = new JLabel("로그인");
		idL = new JLabel("ID");
		pwdL = new JLabel("PWD");
		tfID = new JTextField(7);
		tfPWD = new JTextField(7);
		buttonLogin = new JButton("Login");
		buttonJoin = new JButton("Join");
		
		titleBL.setFont(new Font("SansSerif", Font.BOLD, 40));
		titleBL.setBounds(100, 100, 400,200);
		titleBL.setLocation(540, 200);
		
		
		titleL.setFont(new Font("SansSerif", Font.BOLD, 20));
		titleL.setSize(80, 80);
		titleL.setLocation(590, 400);
		
		idL.setSize(20, 20);
		idL.setLocation(500, 500);
		tfID.setSize(100, 20);
		tfID.setLocation(540, 500);
		
		pwdL.setSize(40, 20);
		pwdL.setLocation(500, 520);
		tfPWD.setSize(100, 20);
		tfPWD.setLocation(540, 520);
		
		buttonLogin.setBounds(40, 40, 65, 40);
		buttonLogin.setLocation(650, 500);
		buttonLogin.setBackground(new Color(176,196,222));
		
		buttonJoin.setBounds(40, 40, 175, 40);
		buttonJoin.setLocation(540, 550);
		buttonJoin.setBackground(new Color(30,144,255));
		
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
