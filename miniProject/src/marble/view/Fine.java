package marble.view;

import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class Fine extends JFrame{
	private JLabel fine, cityName2, cityfine, ans2 ;
	private JButton yes2, no2;

	public Fine(){
 		super();
		this.setSize(230, 270);
		this.setLayout(null);
		this.finepopup();
		this.setVisible(true);
		
	}
	public void finepopup(){
		EtchedBorder eborder;             
		this.fine = new JLabel("�����",JLabel.CENTER);
		eborder = new EtchedBorder(EtchedBorder.RAISED); 
		fine.setBorder(eborder);
		fine.setSize(212, 30);
		fine.setFont(new Font("����",Font.BOLD, 15));
		
		this.cityName2 = new JLabel("���ø�", JLabel.CENTER);
		cityName2.setSize(210 , 160);
		cityName2.setFont(new Font("����", Font.BOLD, 12));
		
		this.cityfine = new JLabel("�����", JLabel.CENTER);
		cityfine.setSize(210,230);
		cityfine.setFont(new Font("����", Font.BOLD, 12));
		
		this.ans2 = new JLabel("����Ḧ �����Ͻðڽ��ϱ�?");
		ans2.setSize(200,100);
		ans2.setLocation(30, 100);
		ans2.setFont(new Font("����", Font.BOLD, 12));
		
		this.yes2 = new JButton("����");
		yes2.setBounds(30, 170, 70, 30);
		yes2.setFont(new Font("Dialog", Font.ITALIC, 12));
		
		this.no2= new JButton("�Ļ�");
		no2.setBounds(120, 170, 70, 30);
		no2.setFont(new Font("Dialog", Font.ITALIC, 12));
		
		this.add(fine);
		this.add(cityName2);
		this.add(cityfine);
		this.add(ans2);
		this.add(yes2);
		this.add(no2);
		
		
	}

	public static void main(String[] args) {
		new Fine();
	}

}
