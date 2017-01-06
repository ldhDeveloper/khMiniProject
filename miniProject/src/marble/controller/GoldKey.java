package marble.controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import marble.model.*;

public class GoldKey extends JFrame{
	
	private JPanel panelBoard;
	private boolean  flag = false;
	
	public void setPanelBoard(JPanel panelBoard) {
		this.panelBoard = panelBoard;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
		public void goldKeyEvent(JLabel[] Jlist,JLabel car, Charcter c,
				JButton btn1, JLabel planeMsg){
			//int keyNum = (int)Math.random() * 10 + 1;
			int keyNum = 1;
			
			switch(keyNum){
			case 1: 
				toIsland(Jlist, car, c); 
				break;
			case 2:	
				winLotto(); 
				break;
			case 3:
				move3next();
				break;
			case 4:
				move3before();
				break;
			case 5:
				gotoStart();
				break;
			case 6:
				buildingRepair();
				break;
			case 7:
				getNoFee();
				break;
			case 8:
				gotoAirport(btn1, planeMsg);
				break;
			case 9:
				sellCity();
				break;
			case 10:
				openOlympic();
				break;
		}
		
		}

		public void openOlympic() {
			// TODO Auto-generated method stub
			
		}

		public void sellCity() {
			// TODO Auto-generated method stub
			
		}

		public void gotoAirport(JButton btn1, JLabel planeMsg) {
			// TODO Auto-generated method stub
			System.out.println("세계여행 ");
			
			btn1.setEnabled(false);
			planeMsg.setVisible(true);
		}

		public void getNoFee() {
			// TODO Auto-generated method stub
			
		}

		public void buildingRepair() {
			// TODO Auto-generated method stub
			
		}

		public void gotoStart() {
			// TODO Auto-generated method stub
			
		}

		public void move3before() {
			// TODO Auto-generated method stub
			
		}

		public void move3next() {
			// TODO Auto-generated method stub
			
		}

		public void winLotto() {
			// TODO Auto-generated method stub
			
		}

		public void toIsland(JLabel[] Jlist,JLabel car, Charcter c) {
			
			int xPoint = (int)Jlist[18].getLocation().getX() + 50;
			int yPoint = (int)Jlist[18].getLocation().getY() + 18;

			if (flag==true) {
				JOptionPane.showMessageDialog(this, 
						"황금열쇠 : 무인도 \n무인도로 이동합니다.");
				car.setLocation(xPoint, yPoint); // 말 위치 이동
				c.setLocation(18);
			}
			
			else
				JOptionPane.showMessageDialog(this, 
						"무인도로 이동합니다.");
			
			
			
			
		}
}
