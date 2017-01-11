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
	
		public void goldKeyEvent(Cities[] ct, JLabel[] Jlist,
				JLabel car, Charcter c, JButton btn1,
				JLabel planeMsg, JLabel sellMsg, JLabel olympicMsg){
			
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
				sellCity(btn1, sellMsg, ct, Jlist, planeMsg);
				break;
			case 10:
				openOlympic(ct, Jlist, btn1, olympicMsg);
				break;
		}
		
		}

		public void openOlympic(Cities[] ct, JLabel[] Jlist, JButton btn1,
				JLabel olympicMsg) {
			// TODO Auto-generated method stub
			
			if (sellable(ct) == false) {
				JOptionPane.showMessageDialog(this, "황금열쇠 : 올림픽 \n"
						+ "소유한 도시가 없기 때문에 올림픽 개최를 할 수 없습니다.");
				return;
			}

			if (flag==true) {
				olympicMsg.setText("황금열쇠 : 올림픽 \n올림픽을 개최할 도시를 선택해주세요 ");
				flag = false;
			}

			listEnableFalse(ct, Jlist);
			
			olympicMsg.setVisible(true);
			btn1.setEnabled(false);
			
		}

		public void sellCity(JButton btn1, JLabel sellMsg,
				Cities[] ct, JLabel[] Jlist, JLabel planeMsg) {
			// TODO Auto-generated method stub

			if (sellable(ct) == false) {
				JOptionPane.showMessageDialog(this, "황금열쇠 : 도시 매각 \n"
						+ "소유한 도시가 없기 때문에 매각할 수 없습니다.");
				return;
			}

			listEnableFalse(ct, Jlist);

			btn1.setEnabled(false);
			sellMsg.setVisible(true);
			
		}

		public void listEnableFalse(Cities[] ct, JLabel[] Jlist) {
			for (int i=0 ; i<ct.length ; i++) {
				if (i%3!=0)
					continue;
				Jlist[i].setEnabled(false);
			}
		}
		
		public boolean sellable(Cities[] ct) {
			
			boolean sellable = false;
			int cityStatus;
			
			for (int i=1 ; i<ct.length ; i++) {
				if (i%3==0)
					continue;
				cityStatus = ct[i].getStatus();
				if (cityStatus>0 && cityStatus!=5) {
					sellable = true;
					break;
				}
			}
			return sellable;
		}
		
		public void gotoAirport(JButton btn1, JLabel planeMsg) {
			// TODO Auto-generated method stub

			if (flag==true) {
				planeMsg.setText("황금열쇠 : 항공권 \n이동할 도시를 선택해주세요 ");
				flag = false;
			}
			
			else
				planeMsg.setText("이동할 도시를 선택해주세요 ");
			
				btn1.setEnabled(false);
				planeMsg.setVisible(true);
		}

		public void getNoFee() {
			// TODO Auto-generated method stub
			
			JOptionPane.showMessageDialog(this, "황금열쇠 : 무료 통행권 \n"
					+ "다음 상대방 도시 방문 시 무료로 통행합니다.");
			
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
					sum += (ct[i].getStatus() - 1) * 5;
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
			
			/*if(location <= Jlist.length)
				location += Jlist.length;
*/
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
			JOptionPane.showMessageDialog(this, "황금열쇠 : 로또 \n100원 get");
			c.setMoney(c.getMoney() + 100);
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
