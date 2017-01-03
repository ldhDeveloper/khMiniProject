package gui.mvc.view;

import java.awt.*;
import javax.swing.*;

public class login extends JFrame{

	private JPanel panel;
	private JLabel titleL;
	
	public login(){
		
		this.setTitle("BlueMarble");
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titleL = new JLabel("test", JLabel.CENTER);
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		add(panel);
		
		showJPanel();
		
		this.setVisible(true);
	}
	
	private void showJPanel() {
		JPanel jpanel = new JPanel();
		jpanel.setBackground(Color.BLACK);
		jpanel.setLayout(new FlowLayout());
		jpanel.add(titleL);
		
		panel.add(panel);
		panel.setVisible(true);
	}

	
}
