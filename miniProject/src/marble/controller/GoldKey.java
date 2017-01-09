package marble.controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import marble.model.*;

public class GoldKey extends JFrame{
	
	private JLabel user1Money;
	private boolean  flag = false;
	private int keyNum;
	
	public void setUserInfo(JLabel user1Money) {
		this.user1Money = user1Money;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
		public void goldKeyEvent(Cities[] ct, JLabel[] Jlist, JLabel car, Charcter c,
				JButton btn1, JLabel planeMsg){
			keyNum = (int) (Math.random() * 10 + 1);
					
			switch(keyNum){
			case 1: 
				toIsland(Jlist, car, c); 
				break;
			case 2:	
				winLotto(c);
				break;
			case 3:
				move3next(car, c, Jlist);
				break;
			case 4:
				move3before(car, c, Jlist);
				break;
			case 5:
				gotoStart(car, c, Jlist);
				break;
			case 6:
				buildingRepair(ct, c, Jlist);
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

			if (flag==true) {
				planeMsg.setText("황금열쇠 : \n이동할 도시를 선택해주세요 ");
				flag = false;
			}
			
			else
				planeMsg.setText("이동할 도시를 선택해주세요 ");
			
				btn1.setEnabled(false);
				planeMsg.setVisible(true);
		}

		public void getNoFee() {
			// TODO Auto-generated method stub
			
		}

		public void buildingRepair(Cities[] ct, Charcter c, JLabel[] Jlist) {
			// TODO Auto-generated method stub
			
			int sum = 0;
			int num = 0;
			int cityStatus;
			
			for (int i=1 ; i<ct.length && i%3!=0 ; i++) {
				cityStatus = ct[i].getStatus();
				if (cityStatus>1 && cityStatus<5) {
					num++;
					sum += (ct[i].getStatus() - 1) * 50000;
				}
			}

			JOptionPane.showMessageDialog(this, "황금열쇠 : 건물 수리 \n"
					+  "건물 " + num + "채 수리비 "
					+ sum + "원");

			c.setMoney(c.getMoney() - sum);
			user1Money.setText(c.getMoney()+"");
			
		}

		public void gotoStart(JLabel car, Charcter c, JLabel[] Jlist) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(this, "출발 지점으로 이동합니다.");
			c.setLocation(0);
			
			int xPoint = (int)Jlist[0].getLocation().getX() + 50;
			int yPoint = (int)Jlist[0].getLocation().getY() + 18;
			
			car.setLocation(xPoint, yPoint);
			
		}

		public void move3before(JLabel car, Charcter c, JLabel[] Jlist) {
			// TODO Auto-generated method stub

			int location = c.getLocation() - 3;
			JOptionPane.showMessageDialog(this, "3칸 뒤로 이동합니다.");
			
			if(location <= Jlist.length)
				location += Jlist.length;

			c.setLocation(location);
			
			int xPoint = (int)Jlist[location].getLocation().getX() + 50;
			int yPoint = (int)Jlist[location].getLocation().getY() + 18;
			
			car.setLocation(xPoint, yPoint);
			
		}

		public void move3next(JLabel car, Charcter c, JLabel[] Jlist) {
			// TODO Auto-generated method stub

			int location = c.getLocation() + 3;
			JOptionPane.showMessageDialog(this, "3칸 앞으로 이동합니다.");
			
			if(location >= Jlist.length)
				location -= Jlist.length;

			c.setLocation(location);
			
			int xPoint = (int)Jlist[location].getLocation().getX() + 50;
			int yPoint = (int)Jlist[location].getLocation().getY() + 18;

			car.setLocation(xPoint, yPoint);
			
		}

		public void winLotto(Charcter c) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(this, "황금열쇠 : 로또 \n300000원 get");
			c.setMoney(c.getMoney() + 300000);
			user1Money.setText(c.getMoney()+"");
			
		}

		public void toIsland(JLabel[] Jlist, JLabel car, Charcter c) {
			
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
						"무인도 입니다.");
			
			
			
			
		}
}
