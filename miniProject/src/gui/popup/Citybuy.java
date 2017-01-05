package gui.popup;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.*;

public class Citybuy extends JFrame{
	private JLabel citybuy;
	private JLabel cityName, citypay, ans1;
	private JButton yes, no;

	public Citybuy(){
 		super();
		this.setSize(230, 270);
		this.setLayout(null);
		this.citypopup();
		this.setVisible(true);
		
	}
	public void citypopup(){
		EtchedBorder eborder;             
		this.citybuy = new JLabel("���� ����",JLabel.CENTER);
		eborder = new EtchedBorder(EtchedBorder.RAISED); 
		citybuy.setBorder(eborder);
		citybuy.setSize(212, 30);
		citybuy.setFont(new Font("����", Font.BOLD, 15));
		
		this.cityName = new JLabel("���ø�", JLabel.CENTER);
		cityName.setSize(210, 160);
		cityName.setFont(new Font("����", Font.BOLD, 12));
		
		this.citypay = new JLabel("���ñݾ�", JLabel.CENTER);
		citypay.setSize(210, 230);
		
		
		
		this.ans1 = new JLabel("�����Ͻðڽ��ϱ�?");
		ans1.setSize(200,100);
		ans1.setLocation(55, 100);
		
		this.yes = new JButton("yes");
		yes.setBounds(30, 170, 70, 30);
		yes.setFont(new Font("Dialog", Font.ITALIC, 12));
		
		
		this.no= new JButton("no");
		no.setBounds(120, 170, 70, 30);
		no.setFont(new Font("Dialog", Font.ITALIC, 12));
		
		this.add(citybuy);
		this.add(cityName);
		this.add(citypay);
		this.add(ans1);
		this.add(yes);
		this.add(no);
	}

	public static void main(String[] args) {
		new Citybuy();
	}

}
