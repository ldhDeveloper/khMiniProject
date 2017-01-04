package popup;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.*;

public class CityUpgrade extends JFrame{
	private JPanel panel, panel1, panel2;
	private JLabel cityUpgrade, cityName3, upPay, ans3;
	private JButton yes1, no1;
	
	public CityUpgrade(){
		super();
		this.setLayout(null);
		this.setSize(230, 270);
	
		EtchedBorder eborder;
		this.cityUpgrade = new JLabel("도시 업그레이드", JLabel.CENTER);
		eborder = new EtchedBorder(EtchedBorder.RAISED); 
		cityUpgrade.setBorder(eborder);
		cityUpgrade.setSize(212, 30);
		cityUpgrade.setFont(new Font("굴림", Font.BOLD, 15));
		
		this.cityName3 = new JLabel("도시명", JLabel.CENTER);
		cityName3.setSize(210, 160);
		cityName3.setFont(new Font("굴림", Font.BOLD, 12));
		
		this.upPay = new JLabel("업그레이드 비용", JLabel.CENTER);
		upPay.setSize(210, 230);
		upPay.setFont(new Font("굴림", Font.BOLD, 12));
		
		this.ans3 = new JLabel("업그레이드 하시겠습니까?",JLabel.CENTER);
		ans3.setSize(223,280);
		ans3.setFont(new Font("굴림", Font.BOLD, 12));
		
		this.yes1 = new JButton("yes");
		yes1.setBounds(30, 170, 70, 30);
		yes1.setFont(new Font("Dialog", Font.ITALIC, 12));
		
		
		this.no1= new JButton("no");
		no1.setBounds(120, 170, 70, 30);
		no1.setFont(new Font("Dialog", Font.ITALIC, 12));
		
		this.add(cityUpgrade);
		this.add(cityName3);
		this.add(upPay);
		this.add(ans3);
		this.add(yes1);
		this.add(no1);
		this.setVisible(true);
	
	}

	public static void main(String[] args) {
		new CityUpgrade();

	}

}
