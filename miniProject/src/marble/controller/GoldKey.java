package marble.controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import marble.model.*;

public class GoldKey extends JFrame{
		
		public void goldKeyEvent(JLabel[] Jlist,JLabel car, Charcter c){
			//int keyNum = (int)Math.random() * 10 + 1;
			int keyNum = 1;
			
			switch(keyNum){
			case 1: 
				toIslane(Jlist, car, c); 
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
				gotoAirport();
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

		public void gotoAirport() {
			// TODO Auto-generated method stub
			
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

		public void toIslane(JLabel[] Jlist,JLabel car, Charcter c) {
			int xPoint = (int)Jlist[18].getLocation().getX() + 50;
			int yPoint = (int)Jlist[18].getLocation().getY() + 18;
			car.setLocation(xPoint, yPoint); // 말 위치 이동
			c.setLocation(18);
			
			Object[] option = {"구입", "취소"};
			
			int result = JOptionPane.showOptionDialog(this,
					"황금열쇠 : 무인도 \n무인도로 이동합니다.",
					"황금열쇠", 
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, 
					null, option, option[1]);
			
		}
}
