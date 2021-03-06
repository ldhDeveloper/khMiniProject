package marble.controller;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import marble.model.Charcter;
import marble.model.Cities;
import marble.view.PageGame;

import java.util.*;

public class MarbleController extends JFrame implements MouseListener {

	private Charcter c;
	private JFrame f = new JFrame();
	private JPanel p = new JPanel();
	private JPanel panelBoard;
	private JLabel user1Money, user2Money, user3Money, user4Money;
	private JLabel car, carinfo, diceLabel;
	private JLabel diceLabelImage1, diceLabelImage2;
	private JLabel selectedCountry, beforeOlympic = null;
	private ImageIcon diceImage[];
	private JButton btn1;
	private JLabel cityInfoLabel, planeMsg, sellMsg, olympicMsg, endMsg;
	private JLabel[] Jlist;
	private Cities[] ct = new Cities[24];
	private int dice1, dice2, dice, location = 0;
	private int previousLocation, xPoint = 100, yPoint = 68;
	private GoldKey goldkey;
	private CityManager cityManager;
	private PageGame pg;
	private int lastolympic;
	private ClientBackground client;
	

	public MarbleController() {

		cityManager = new CityManager();
		goldkey = new GoldKey();

		
		
		cityInit();
		
		f.setTitle("부루마블");
		f.setSize(1000, 780);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);

		p.setSize(f.getSize());
		p.setOpaque(true);
		p.setBackground(Color.white);
		p.setLayout(null);

		
		
		/*car = new JLabel("A");
		car.setOpaque(true);
		car.setBackground(Color.RED);
		car.setSize(15, 15);
		car.setLocation(100, 68);
		car.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		car2 = new JLabel("B");
		car2.setSize(15,15);
		car2.setLocation(118,68);
		car2.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		
		car3 = new JLabel("C");
		car3.setSize(15,15);
		car3.setLocation(100,86);
		car3.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		
		car4 = new JLabel("D");
		car4.setSize(15,15);
		car4.setLocation(118,86);
		car4.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		
		carinfo = new JLabel("이름 : " + c.getName() + " 자금 : " + c.getMoney(), JLabel.CENTER);
		carinfo.setSize(200, 100);
		carinfo.setLocation(200, 300);
		carinfo.setBorder(BorderFactory.createLineBorder(Color.black, 1));*/

		/*
		 * lb2.addMouseListener(new MouseAdapter(){ String title =
		 * lb2.getText();
		 * 
		 * @Override public void mouseEntered(MouseEvent me) {
		 * lb2.setText(c1.getName()); }
		 * 
		 * @Override public void mouseExited(MouseEvent me){ lb2.setText(title);
		 * }
		 * 
		 * 
		 * 
		 * });
		 */

		diceImage = new ImageIcon[6];
		for (int i = 0; i < 6; i++)
			diceImage[i] = new ImageIcon("dice" + (i + 1) + ".png");

		diceLabel = new JLabel("");
		diceLabel.setLocation(230, 220);
		diceLabel.setSize(100, 20);

		diceLabelImage1 = new JLabel("");
		diceLabelImage1.setLocation(430, 180);
		diceLabelImage1.setSize(100, 100);

		diceLabelImage2 = new JLabel("");
		diceLabelImage2.setLocation(540, 180);
		diceLabelImage2.setSize(100, 100);

		// add();

	}

	

	public Charcter getC() {
		return c;
	}



	public void setC(Charcter c) {
		this.c = c;
	}

	public JLabel getCar() {
		return car;
	}

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	public void setCar(JLabel car) {
		this.car = car;
	}

	public void setPanelBoard(JPanel panelBoard) {
		this.panelBoard = panelBoard;
	}
	
	public void createUserInfo(JLabel user1Money, JLabel user2Money, JLabel user3Money, JLabel user4Money){
		this.user1Money = user1Money;
		this.user2Money = user2Money;
		this.user3Money = user3Money;
		this.user4Money = user4Money;
	}
	
	
	public void setUserInfo(String user1, String user2, String user3, String user4) {
		this.user1Money.setText(user1);
		this.user2Money.setText(user2); 
		this.user3Money.setText(user3); 
		this.user4Money.setText(user4); 
		//goldkey.setUserInfo(user1Money);

	}

	public void setCityInfoLabel(JLabel cityInfoLabel) {
		this.cityInfoLabel = cityInfoLabel;
		cityInfoLabel.setSize(150, 150);
		cityInfoLabel.setOpaque(true);
		cityInfoLabel.setBackground(new Color(255, 255, 255));
		cityInfoLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		cityInfoLabel.setVisible(false);

	}

	public void setPlaneMsg(JLabel planeMsg) {
		this.planeMsg = planeMsg;
		planeMsg.setSize(400, 150);
		planeMsg.setLocation(panelBoard.getSize().width / 2 - 400 / 2, panelBoard.getSize().height / 2 - 150);
		planeMsg.setOpaque(true);
		planeMsg.setBackground(new Color(225, 225, 225));
		planeMsg.setVisible(false);
	}

	public void setSellMsg(JLabel sellMsg) {
		this.sellMsg = sellMsg;
		sellMsg.setSize(400, 150);
		sellMsg.setLocation(panelBoard.getSize().width / 2 - 400 / 2, panelBoard.getSize().height / 2 - 150);
		sellMsg.setOpaque(true);
		sellMsg.setBackground(new Color(225, 225, 225));
		sellMsg.setVisible(false);
	}

	public void setOlympicMsgMsg(JLabel olympicMsg) {
		this.olympicMsg = olympicMsg;
		olympicMsg.setSize(400, 150);
		olympicMsg.setLocation(panelBoard.getSize().width / 2 - 400 / 2, panelBoard.getSize().height / 2 - 150);
		olympicMsg.setOpaque(true);
		olympicMsg.setBackground(new Color(225, 225, 225));
		olympicMsg.setVisible(false);
	}
	
	public void setEndMsgMsg(JLabel endMsg) {
		this.endMsg = endMsg;
		endMsg.setSize(400, 150);
		endMsg.setLocation(panelBoard.getSize().width / 2 - 400 / 2, panelBoard.getSize().height / 2 - 150);
		endMsg.setOpaque(true);
		endMsg.setBackground(new Color(225, 225, 225));
		endMsg.setVisible(false);
	}

	public void setJlist(JLabel[] Jlist) {
		this.Jlist = Jlist;
	}

	public void addJlistEvent(JLabel[] Jlist) {
		for (int i = 0; i < Jlist.length; i++)
			if (!(i == 6)) // 비행기가 아니면
				Jlist[i].addMouseListener(this);
	}

	public void add() {

		/*
		 * for(int i =0; i<Jlist.length ; i++){ if (!(i==6)) // 비행기가 아니면
		 * Jlist[i].addMouseListener(this); f.add(Jlist[i]); }
		 */

		/*
		 * p.add(car); p.add(carinfo); p.add(btn1); p.add(diceLabel);
		 * p.add(diceLabelImage1); p.add(diceLabelImage2); p.add(planeMsg, 0);
		 * f.add(p);
		 */

		f.add(carinfo);
		f.add(diceLabel);
		f.add(diceLabelImage1);
		f.add(diceLabelImage2);
		f.add(planeMsg, 0);

		planeMsg.setVisible(false);
		f.setVisible(true);
	}

	public void cityInit() {
		ct[1] = new Cities("리스본", 0, 0, 20, 0, false);
		ct[2] = new Cities("방콕", 0, 0, 20, 0, false);
		ct[4] = new Cities("도쿄", 0, 0, 15, 0, false);
		ct[5] = new Cities("베이징", 0, 0, 20, 0, false);
		ct[7] = new Cities("뉴델리", 0, 0, 25, 0, false);
		ct[8] = new Cities("두바이", 0, 0, 30, 0, false);
		ct[10] = new Cities("캔버라", 0, 0, 35, 0, false);
		ct[11] = new Cities("카이로", 0, 0, 40, 0, false);
		ct[13] = new Cities("상파울로", 0, 0, 45, 0, false);
		ct[14] = new Cities("아테네", 0, 0, 45,0, false);
		ct[16] = new Cities("코펜하겐", 0, 0, 45, 0, false);
		ct[17] = new Cities("베를린", 0, 0, 45, 0, false);
		ct[19] = new Cities("런던", 0, 0, 45, 0, false);
		ct[20] = new Cities("파리", 0, 0, 45, 0, false);
		ct[22] = new Cities("뉴욕", 0, 0, 45, 0, false);
		ct[23] = new Cities("서울", 0, 0, 45, 0, false);
	}

	public void rollDice(JTextArea gameInfo) {
		endMsg.setVisible(false);
		dice1 = new Random().nextInt(6) + 1;
		dice2 = new Random().nextInt(6) + 1;
		dice = dice1 + dice2;
		//dice = 6;
		
		gameInfo.setText(gameInfo.getText()+"\n" + c.getcNo() + " 님 : " + dice + "칸 이동! ");

		previousLocation = c.getLocation();
		location = c.getLocation() + dice;

		if (location >= ct.length)
			location -= ct.length;

		moveHorse(location);

		if (c.getLocation() < previousLocation) {
			salary();
		}
		/*
		 * diceLabelImage1.setIcon(diceImage[dice1-1]);
		 * diceLabelImage2.setIcon(diceImage[dice2-1]);
		 */
	}

	public void moveHorse(int location) {
		
		
		int cGapX = 0, cGapY = 0;
		switch(c.getcNo()){
		case 1 : cGapX = 50; cGapY = 18; break;
		case 2 : cGapX = 50; cGapY = 36; break;
		case 3 : cGapX = 68; cGapY = 18; break;
		case 4 : cGapX = 68; cGapY = 36; break;
		}
		c.setLocation(location); // 캐릭터 위치 값 저장
		
		
		xPoint = (int) Jlist[location].getLocation().getX() + cGapX;
		yPoint = (int) Jlist[location].getLocation().getY() + cGapY;
		car.setLocation(xPoint, yPoint);
		/*if (previousLocation + dice >= ct.length) {
			for (int i = previousLocation + 1; i < Jlist.length; i++) {
				xPoint = (int) Jlist[i].getLocation().getX() + cGapX;
				yPoint = (int) Jlist[i].getLocation().getY() + cGapY;
				car.setLocation(xPoint, yPoint);
			}
			for (int i = 0; i <= location; i++) {
				xPoint = (int) Jlist[i].getLocation().getX() + cGapX;
				yPoint = (int) Jlist[i].getLocation().getY() + cGapY;
				car.setLocation(xPoint, yPoint);
			}
		}

		for (int i = previousLocation + 1; i <= location; i++) {

			xPoint = (int) Jlist[i].getLocation().getX() + cGapX;
			yPoint = (int) Jlist[i].getLocation().getY() + cGapY;
			car.setLocation(xPoint, yPoint);

		}*/

		if (ct[location] != null) {
			cityAction(location);
			//클라이언트에서 신호 쏴준다
			/*
			 * carinfo.setText("이름 : " + c.getName() + " 자금 : " + c.getMoney());
			 */
		} else
			func();
	}
	
	public JLabel CharcterMoney(Charcter c){
		JLabel userMoney = null;
		switch(c.getcNo()){
		case 1 : userMoney = user1Money; break;
		case 2 : userMoney = user2Money; break;
		case 3 : userMoney = user3Money; break;
		case 4 : userMoney = user4Money; break;
		}
		return userMoney;
	}

		
	public JLabel OwnerMoney(Cities ct){
		JLabel userMoney = null;
		switch(ct.getOwner()){
		case 1 : userMoney = user1Money; break;
		case 2 : userMoney = user2Money; break;
		case 3 : userMoney = user3Money; break;
		case 4 : userMoney = user4Money; break;
		}
		return userMoney;
	}
	
	
	public void cityAction(int location) {
		int result = 0;
		int cityStatus = ct[location].getStatus();
		JLabel userMoney = null;
		switch(c.getcNo()){
		case 1 : userMoney = user1Money; break;
		case 2 : userMoney = user2Money; break;
		case 3 : userMoney = user3Money; break;
		case 4 : userMoney = user4Money; break;
		
		}
		

		if (cityStatus == 0) {
			// 구입 X 0
			
			result = cityManager.OwnCity(ct[location], c, userMoney);

			if (result == 0) {
				cityAction(location);
			}

			else if (result == JOptionPane.CLOSED_OPTION);
		}

		else {
			if(ct[location].getOwner() == c.getcNo()){
				String r = cityManager.UpgradeCity(ct[location], c, userMoney);

				if (r == null){
					try {
						client.getOos().writeByte(10);
						client.getOos().flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;}

				if (cityStatus == 1) {
					// 건물이 0채일 때

					if (r.equals("1")) // 1채 짓기
						building(location, cityStatus, 1);

					else if (r.equals("2")) // 2채 짓기
						building(location, cityStatus, 2);

					else if (r.equals("3")) // 3채 짓기
						building(location, cityStatus, 3);
				}

				else if (cityStatus == 2) {

					if (r.equals("1"))
						building(location, cityStatus, 1);

					else if (r.equals("2"))
						building(location, cityStatus, 2);
				}

				else if (cityStatus == 3) {//2채인 상태

					if (r.equals("1"))
						building(location, cityStatus, 2);
				}

				else if (cityStatus == 4) {//건물 3채인 상태
					cityStatus = ct[location].getStatus();// 주석처리하면 랜드마크 색 표시가 안됨
					if (r.equals("0"))
						building(location, cityStatus, 1);
				}

				else
					System.out.println("랜드마크 방문 보상 ");
			} else {
				//String compName = null;
				if(c.getFreeCoupon() == 0){
					JOptionPane.showMessageDialog(this, "통행료 지불 : " + ct[location].getFee() + " 원 지불합니다." );
					c.setMoney(c.getMoney() - ct[location].getFee());
					userMoney.setText(c.getMoney()+"");
					OwnerSelect(ct[location]).setMoney(OwnerSelect(ct[location]).getMoney() + ct[location].getFee());;
					OwnerMoney(ct[location]).setText(OwnerSelect(ct[location]).getMoney() + ct[location].getFee()+"");
				} else {
					JOptionPane.showMessageDialog(this, "무료 통행권을 사용합니다.");
					c.setFreeCoupon(c.getFreeCoupon()-1);
				}
				
				if(ct[location].getStatus() != 5){
					Object[] option = { "예", "아니오" };
					if(c.getMoney() >=  ct[location].getFee()/2){
						int result1;
						result1 = JOptionPane.showOptionDialog(this, "인수 : 도시를 인수 하시겠습니까?\n인수비용 : " + (ct[location].getFee()/2) , "도시 인수",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
						if(result1 == 0){
							/*for (Component pan : panelBoard.getComponents()) {

								for (int j = 1; j <= 3; j++) {
									compName = pan.getName();
									if (compName != null) {
										if (compName.equals("Jlist" + location + "" + j)) {
											((JComponent) pan).setOpaque(true);
											pan.repaint();
										}
									}
								}
							}*/
							c.setMoney(c.getMoney() - ct[location].getFee()/2);
							c.setOwnBuild(c.getOwnBuild()+1);
							userMoney.setText(c.getMoney()+"");
							OwnerSelect(ct[location]).setMoney(OwnerSelect(ct[location]).getMoney() + ct[location].getFee()/2);
							OwnerMoney(ct[location]).setText(OwnerSelect(ct[location]).getMoney() + ct[location].getFee()/2+"");
							OwnerSelect(ct[location]).setOwnBuild(OwnerSelect(ct[location]).getOwnBuild()-1);
							ct[location].setOwner(c.getcNo());
							printBuildingColor(location, 1, ct[location].getStatus() - 1);
							pg.repaint();
						}
					} else {
						JOptionPane.showMessageDialog(this, "자금이 부족해서 도시를 인수할 수 없습니다.");
					}
					
					
				}
			}
			
		} 
		setTooltip();
		pg.repaint();
		listEnableTrue(ct, Jlist);
		try {
			client.getOos().writeByte(10);
			client.getOos().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Charcter OwnerSelect(Cities ct){
		Charcter Owner=null;
		System.out.println(ct.getOwner());
		Charcter[] ch = (Charcter[])pg.getCarArr().toArray();
		switch(ct.getOwner()){
		/*case 1 : Owner = pg.getC1(); break;
		case 2 : Owner = pg.getC2(); break;
		case 3 : Owner = pg.getC3(); break;
		case 4 : Owner = pg.getC4(); break;*/
		case 1 : Owner = ch[0]; break;
		case 2 : Owner = ch[1]; break;
		case 3 : Owner = ch[2]; break;
		case 4 : Owner = ch[3]; break;
		}
		return Owner;
	}

	public void func() {

		previousLocation = location;

		JLabel userMoney = null;
		switch(c.getcNo()){
		case 1 : userMoney = user1Money; break;
		case 2 : userMoney = user2Money; break;
		case 3 : userMoney = user3Money; break;
		case 4 : userMoney = user4Money; break;
		}
		
		
		//
		switch (location) {
		case 0:
			salary();
			break;
		case 3:
			goldkey.setUserInfo(userMoney);
			goldkey.setFlag(true);
			goldkey.goldKeyEvent(ct, Jlist, car, c, btn1, planeMsg, sellMsg, olympicMsg);
			if ((location = c.getLocation()) != previousLocation)
				func();
			break;
		case 6:
			goldkey.setUserInfo(userMoney);
			goldkey.gotoAirport(btn1, planeMsg);
			break;
		case 9:
			goldkey.setUserInfo(userMoney);
			goldkey.setFlag(true);
			goldkey.goldKeyEvent(ct, Jlist, car, c, btn1, planeMsg, sellMsg, olympicMsg);
			if ((location = c.getLocation()) != previousLocation)
				func();
			break;
		case 12:
			goldkey.openOlympic(ct, Jlist, c , btn1, olympicMsg);
			break;
		case 15:
			goldkey.setUserInfo(userMoney);
			goldkey.setFlag(true);
			goldkey.goldKeyEvent(ct, Jlist, car, c, btn1, planeMsg, sellMsg, olympicMsg);
			if ((location = c.getLocation()) != previousLocation) {
				func();
			}
			break;
		case 18:
			System.out.println("무인도 ");
			c.setIslandflag(true);
			goldkey.setUserInfo(userMoney);
			goldkey.setFlag(false);
			goldkey.toIsland(Jlist, car, c);
			location = c.getLocation();
			break;
		case 21:
			goldkey.setUserInfo(userMoney);
			goldkey.setFlag(true);
			goldkey.goldKeyEvent(ct, Jlist, car, c, btn1, planeMsg, sellMsg, olympicMsg);
			if ((location = c.getLocation()) != previousLocation)
				func();
			break;
		}
		pg.repaint();
		listEnableTrue(ct, Jlist);
	}

	public void salary() {
		JOptionPane.showMessageDialog(this, "월급을 받습니다 (+30원)");
		c.setMoney(c.getMoney() + 30);

		/*
		 * user1Info.setText("<html>아이디: " + c.getName() + "<br>자산: " +
		 * c.getMoney() + "</html>");
		 */
		CharcterMoney(c).setText(c.getMoney() + "");

	}

	public void building(int location, int cityStatus, int upto) {
		printBuildingColor(location, cityStatus, cityStatus - 1 + upto);
	}

	public void printBuildingColor(int location, int cityStatus, int lastBuilding) {

		String name;
		Color buildColor = null, randColor = null;
		switch(c.getcNo()){
		case 1 : 
			buildColor = new Color(238, 99, 99);
			randColor = new Color(238, 99, 99, 80); 
		break;
		case 2 : 
			buildColor = new Color(113, 198, 113);
			randColor = new Color(113, 198, 113, 80); break;
		case 3 : 
			buildColor = new Color(99, 184, 255);
			randColor = new Color(99, 184, 255, 80); break;
		case 4 : 
			buildColor = new Color(142, 56, 142); 
			randColor = new Color(142, 56, 142, 80); break;
		}
		
		if (cityStatus == 5) {
			Jlist[location].setOpaque(true);
			Jlist[location].setBackground(randColor);
		}

		else{
			for (Component pan : panelBoard.getComponents()) {
				for (int i = cityStatus; i <= lastBuilding; i++) {
					
					name = pan.getName();
					if (name != null) {
						
						if (name.equals("Jlist" + location + "" + i)){
							((JComponent) pan).setOpaque(true);
							pan.setBackground(buildColor); 
							pan.repaint();
						}
					}
				}
			}
		}
			
			
	}

	public void selection(JLabel selectedCountry) {
		
		if (planeMsg.isVisible()) {
			for (int i = 1; i < Jlist.length; i++)
				if (Jlist[i] == selectedCountry) {
					moveHorse(location = i);
					planeMsg.setVisible(false);
					btn1.setEnabled(true);
					break;
				}
		} else if (sellMsg.isVisible()) {

			int cityStatus = 0, result;
			int cost = 0;
			Object[] option = { "예", "아니오" };
			String compName = null;

			for (int i = 1; i < ct.length; i++)
				if (c.getOwnBuild() == 0){
					JOptionPane.showMessageDialog(this, "보유한 도시가 없습니다.");
				}
				else if (Jlist[i] == selectedCountry) {

					try {
						cityStatus = ct[i].getStatus();
					} catch (NullPointerException e) {
						JOptionPane.showMessageDialog(this, "선택 불가");
						goldkey.sellCity(btn1, sellMsg, c, ct, Jlist, planeMsg);
						break;
					}

					if (cityStatus == 0  || ct[i].getOwner() != c.getcNo()) {
						JOptionPane.showMessageDialog(this, selectedCountry.getText() + " 은(는) 소유한 도시가 아닙니다.");
						goldkey.sellCity(btn1, sellMsg, c, ct, Jlist, planeMsg);
						break;
					}

					else if (cityStatus == 1)
						cost = ct[i].getGrandCost();

					else if (cityStatus == 2)
						cost = ct[i].getGrandCost() + 10;

					else if (cityStatus == 3)
						cost = ct[i].getGrandCost() + 25;

					else if (cityStatus == 4)
						cost = ct[i].getGrandCost() + 45;

					else {
						JOptionPane.showMessageDialog(this, "랜드마크는 매각할 수 없습니다.");
						goldkey.sellCity(btn1, sellMsg, c, ct, Jlist, planeMsg);
						break;
					}

					result = JOptionPane.showOptionDialog(this, selectedCountry.getText() + " 을(를) 매각하시겠습니까?", "도시 매각",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);

					if (result == 0) {

						JOptionPane.showMessageDialog(this,
								selectedCountry.getText() + "의 건물 " + (cityStatus - 1) + "채를 매각합니다.\n+" + cost + "원");
						//c.setMoney(c.getMoney() + cost);
						//CharcterMoney(c).setText(c.getMoney() + "");
						OwnerSelect(ct[i]).setMoney(OwnerSelect(ct[i]).getMoney() + cost);
						OwnerSelect(ct[i]).setOwnBuild(OwnerSelect(ct[i]).getOwnBuild() - 1);
						OwnerMoney(ct[i]).setText(OwnerSelect(ct[i]).getMoney() + cost+"");
						ct[i].setStatus(0);

						for (Component pan : panelBoard.getComponents()) {

							for (int j = 1; j <= 3; j++) {
								compName = pan.getName();
								if (compName != null) {
									if (compName.equals("Jlist" + i + "" + j)) {
										System.out.println(compName+" "+ct[i].getName() + " 매각");
										((JComponent) pan).setOpaque(false);
									}
								}
							}
						}
						beforeOlympic = deselectOlympic(selectedCountry);
						sellMsg.setVisible(false);
						btn1.setEnabled(true);
						listEnableTrue(ct, Jlist);
						break;
					}
				}
		}
		
		else if (olympicMsg.isVisible()) {
			if(beforeOlympic != null)
				beforeOlympic.setBorder(BorderFactory.createLineBorder(Color.black, 1)); 
			
			if(ct[lastolympic] != null) {
			ct[lastolympic].setFee(ct[lastolympic].getFee()-computeFee(ct[lastolympic]));
			}
			
			for (int i = 1; i < Jlist.length; i++) {
				if (c.getOwnBuild() == 0){
					JOptionPane.showMessageDialog(this, "보유한 도시가 없습니다.");
				}
				else if (Jlist[i] == selectedCountry) {
					
					if (ct[i].getStatus() == 0 || ct[i].getOwner() != c.getcNo()) {
						JOptionPane.showMessageDialog(this, "본인 소유가 아니므로 올림픽 개최가 불가능한 도시입니다.");
						
						goldkey.openOlympic(ct, Jlist, c, btn1, olympicMsg);
						listEnableTrue(ct, Jlist);
						break;
					}					
					
					olympicMsg.setVisible(false);
					beforeOlympic = selectOlympic(selectedCountry);
					JOptionPane.showMessageDialog(this,
							ct[i].getName() + " 올림픽 개최!\n통행료가 " + computeFee(ct[i]) + "원 인상되었습니다.");
					ct[i].setFee(ct[i].getFee()+computeFee(ct[i]));
					lastolympic=i;
					
					btn1.setEnabled(true);
					listEnableTrue(ct, Jlist);

					break;
					
				}
			}
		}
	}
	
	public JLabel selectOlympic(JLabel selectedCountry){
		selectedCountry.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
		return selectedCountry;
	}
	public JLabel deselectOlympic(JLabel selectedCountry){
		selectedCountry.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		return selectedCountry;
	}
	
	public  void listEnableTrue(Cities[] ct, JLabel[] Jlist) {
		for (int i = 0; i < ct.length; i++) {
			if (i % 3 != 0)
				continue;
			Jlist[i].setEnabled(true);
		}
	}

	public int computeFee(Cities city) {

		int cityStatus = city.getStatus();
		int fee = city.getGrandCost();

		if (cityStatus == 2)
			fee += 10;
		else if (cityStatus == 3)
			fee += 25;
		else if (cityStatus == 4)
			fee += 45;

		return fee;
	}

	public void exitMarble() {
		Object[] option = { "종료", "취소" };
		if ((JOptionPane.showOptionDialog(this, "종료 하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, option, option[1])) == 0)
			System.exit(0);
	}

	public void makeTooltip() {
		for (int i = 0; i < Jlist.length; i++) {
			Jlist[i].createToolTip();
		}
	}

	public void setTooltip() {
		int grand = 0, owner, status = 0, fee = 0;
		String sOwner = "", sFee = "";
		for (int i = 0; i < Jlist.length; i++) {
			for (int j = 0; j < ct.length; j++) {
				if (ct[j] != null) {
					if (ct[j].getName().equals(Jlist[i].getText())) {
						grand = ct[j].getGrandCost();
						if ((ct[j].getOwner()) == 0) {
							sOwner = "없음";
						} else {
							sOwner = String.valueOf(ct[j].getOwner());
						}

						fee = ct[j].getFee();
						if (fee == 0) {
							sFee = "없음";
						} else {
							sFee = String.valueOf(fee);
						}
						status = ct[j].getStatus();

						Jlist[i].setToolTipText("<html>  " + Jlist[i].getText() + "<br> 토지가격 : " + grand + "<br> 소유주 : "
								+ sOwner + "<br> 통행료 : " + sFee + "</html>");
					}
				}

			}

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		selection((JLabel) (e.getSource()));
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		/*
		 * cityLabel = (JLabel)(e.getSource()); int grand = 0, owner, status =
		 * 0; String sOwner = "", sFee = ""; for(int i = 0; i <= ct.length;
		 * i++){ if(ct[i] != null){
		 * if(ct[i].getName().equals(cityLabel.getText())){ grand =
		 * ct[i].getGrandCost(); if((ct[i].getOwner()) == 0){ sOwner = "없음"; }
		 * else { sOwner = String.valueOf(ct[i].getOwner()); }
		 * 
		 * if(ct[i].getOwner() == 0 && ct[i].getStatus() == 0){ sFee = "없음"; }
		 * else if(ct[i].getStatus() == 0) { sFee = String.valueOf(grand * 2); }
		 * else if(ct[i].getStatus() == 1) { sFee = String.valueOf((grand+10) *
		 * 2); } else if(ct[i].getStatus() == 2) { sFee =
		 * String.valueOf((grand+25) * 2); } else { sFee =
		 * String.valueOf((grand+45) * 2); } status = ct[i].getStatus();
		 * 
		 * cityInfoLabel.setSize(100, 80); cityInfoLabel.setText("<html>  "
		 * +cityLabel.getText() + "<br> 토지가격 : " + grand + "<br> 소유주 : " +
		 * sOwner + "<br> 통행료 : " + sFee + "</html>");
		 * if(cityLabel.getLocation().x < 625 && cityLabel.getLocation().y ==0){
		 * cityInfoLabel.setLocation(cityLabel.getLocation().x,
		 * cityLabel.getLocation().y + 110); } else if
		 * (cityLabel.getLocation().x == 750 && cityLabel.getLocation().y
		 * <=385){ cityInfoLabel.setLocation(cityLabel.getLocation().x-110,
		 * cityLabel.getLocation().y); } else if (cityLabel.getLocation().x <=
		 * 750 && cityLabel.getLocation().y ==450){
		 * cityInfoLabel.setLocation(cityLabel.getLocation().x,
		 * cityLabel.getLocation().y-90); } else if (cityLabel.getLocation().x
		 * == 0 && cityLabel.getLocation().y <=450){
		 * cityInfoLabel.setLocation(cityLabel.getLocation().x + 160,
		 * cityLabel.getLocation().y); }
		 * 
		 * cityInfoLabel.setVisible(true); } }
		 * 
		 * }
		 */

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// cityInfoLabel.setVisible(false);
	}

	public PageGame getPg() {
		return pg;
	}

	public void setPg(PageGame pg) {
		this.pg = pg;
	}

	public ClientBackground getClient(){
		return this.client;
	}
	public void setClient(ClientBackground client){
		this.client = client;
	}
	public void setGoldKey(GoldKey gKey){
		this.goldkey=gKey;
	}
	public GoldKey getGoldKey(){
		return this.goldkey;
	}
	
}
