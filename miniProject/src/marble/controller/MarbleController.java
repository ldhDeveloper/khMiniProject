package marble.controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import marble.model.Charcter;
import marble.model.Cities;

import java.util.*;

public class MarbleController extends JFrame implements MouseListener{
	
	private Charcter c;
	private JFrame f = new JFrame();
	private JPanel p = new JPanel();
	private JPanel panelBoard;
	private JLabel user1Money;
	private JLabel car, carinfo, diceLabel;
	private JLabel diceLabelImage1, diceLabelImage2;
	private JLabel selectedCountry;
	private ImageIcon diceImage[] ;
	private JButton btn1;
	private JLabel planeMsg, sellMsg, olympicMsg;
	private JLabel[] Jlist;
	private Cities[] ct = new Cities[24];
	private int dice1, dice2, dice, location = 0;
	private int previousLocation, xPoint = 100, yPoint = 68 ;
	private GoldKey goldkey;
	private CityManager cityManager;
	
	public MarbleController() { 
		
		cityManager = new CityManager();
		goldkey = new GoldKey();
		
		c = new Charcter("1번", 2000, 0);

		cityInit();
		
		f.setTitle("부루마블");
		f.setSize(1000, 780);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		
		p.setSize(f.getSize());
		p.setOpaque(true);
		p.setBackground(Color.white);
		p.setLayout(null);
		
		car = new JLabel("A");
		car.setOpaque(true);
		car.setBackground(Color.RED);
		car.setSize(15,15);
		car.setLocation(100,68);
		car.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		carinfo = new JLabel("이름 : " + c.getName() +
				" 자금 : " + c.getMoney(), JLabel.CENTER);
		carinfo.setSize(200,100);
		carinfo.setLocation(200,300);
		carinfo.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		/*lb2.addMouseListener(new MouseAdapter(){
			String title = lb2.getText();
			@Override
            public void mouseEntered(MouseEvent me) {
				lb2.setText(c1.getName());
            }
			
			@Override
			public void mouseExited(MouseEvent me){
				lb2.setText(title);
			}
			
			
			
		});*/

		diceImage = new ImageIcon[6];
		for (int i=0 ; i<6 ; i++) 
			diceImage[i] = new ImageIcon("dice" + (i+1) + ".png");
		
		diceLabel = new JLabel("");
		diceLabel.setLocation(230, 220);
		diceLabel.setSize(100, 20);
		
		diceLabelImage1 = new JLabel("");
		diceLabelImage1.setLocation(430, 180);
		diceLabelImage1.setSize(100, 100);
		
		diceLabelImage2 = new JLabel("");
		diceLabelImage2.setLocation(540, 180);
		diceLabelImage2.setSize(100, 100);
		
		//add();
		
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

	public void setUserInfo(JLabel user1Money) {
		this.user1Money = user1Money;
		goldkey.setUserInfo(user1Money);
		
	}
	
	public void setPlaneMsg(JLabel planeMsg) {
		this.planeMsg = planeMsg;
		planeMsg.setSize(400, 150);
		planeMsg.setLocation(panelBoard.getSize().width/2 - 400/2 , panelBoard.getSize().height/2 - 150);
		planeMsg.setOpaque(true);
		planeMsg.setBackground(new Color(225, 225, 225));
		planeMsg.setVisible(false);
	}
	
	public void setSellMsg(JLabel sellMsg) {
		this.sellMsg = sellMsg;
		sellMsg.setSize(400, 150);
		sellMsg.setLocation(panelBoard.getSize().width/2 - 400/2 , panelBoard.getSize().height/2 - 150);
		sellMsg.setOpaque(true);
		sellMsg.setBackground(new Color(225, 225, 225));
		sellMsg.setVisible(false);
	}
	
	public void setOlympicMsgMsg(JLabel olympicMsg) {
		this.olympicMsg = olympicMsg;
		olympicMsg.setSize(400, 150);
		olympicMsg.setLocation(panelBoard.getSize().width/2 - 400/2 , panelBoard.getSize().height/2 - 150);
		olympicMsg.setOpaque(true);
		olympicMsg.setBackground(new Color(225, 225, 225));
		olympicMsg.setVisible(false);
	}
	
	public void setJlist(JLabel[] Jlist) {
		this.Jlist = Jlist;
	}
	
	public void addJlistEvent(JLabel[] Jlist) {
		for(int i =0; i<Jlist.length ; i++)
			if (!(i==6)) // 비행기가 아니면 
				Jlist[i].addMouseListener(this);
	}
	
	public void add() {
		
		/*
		for(int i =0; i<Jlist.length ; i++){
			if (!(i==6)) // 비행기가 아니면 
				Jlist[i].addMouseListener(this);
			f.add(Jlist[i]);
		}
		*/
		
		/*
		p.add(car);
		p.add(carinfo);
		p.add(btn1);
		p.add(diceLabel);
		p.add(diceLabelImage1);
		p.add(diceLabelImage2);
		p.add(planeMsg, 0);
		f.add(p);
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
		ct[1] = new Cities("리스본", 0, 0, 20);
		ct[2] = new Cities("방콕", 0, 0, 20);
		ct[4] = new Cities("도쿄", 0, 0, 15);
		ct[5] = new Cities("베이징", 0, 0, 20);
		ct[7] = new Cities("뉴델리", 0, 0, 25);
		ct[8] = new Cities("두바이", 0, 0, 30);
		ct[10] = new Cities("캔버라", 0, 0, 35);
		ct[11] = new Cities("카이로", 0, 0, 40);
		ct[13] = new Cities("상파울로", 0, 0, 45);
		ct[14] = new Cities("아테네", 0, 0, 45);
		ct[16] = new Cities("코펜하겐", 0, 0, 45);
		ct[17] = new Cities("베를린", 0, 0, 45);
		ct[19] = new Cities("런던", 0, 0, 45);
		ct[20] = new Cities("파리", 0, 0, 45);
		ct[22] = new Cities("뉴욕", 0, 0, 45);
		ct[23] = new Cities("서울", 0, 0, 45);
	}
	
	public void rollDice(JTextArea gameInfo) {

		dice1 = new Random().nextInt(6) + 1;
		dice2 = new Random().nextInt(6) + 1;
		dice = dice1 + dice2;
		
		gameInfo.setText(dice + "칸 이동! ");
		
		previousLocation = location;
		location = c.getLocation() + dice;
		
		if(location >= ct.length)
			location -= ct.length;

		moveHorse(location);
		
		/*
		diceLabelImage1.setIcon(diceImage[dice1-1]);
		diceLabelImage2.setIcon(diceImage[dice2-1]);
		 */
	}
	
	public void moveHorse(int location) {
		
		c.setLocation(location); // 캐릭터 위치 값 저장
		
		if(previousLocation+dice >= ct.length) {
			for (int i=previousLocation+1 ; i<Jlist.length ; i++) {
				xPoint = (int)Jlist[i].getLocation().getX() + 50;
				yPoint = (int)Jlist[i].getLocation().getY() + 18;
				car.setLocation(xPoint, yPoint);
			}
			for (int i=0 ; i<=location ; i++) {
				xPoint = (int)Jlist[i].getLocation().getX() + 50;
				yPoint = (int)Jlist[i].getLocation().getY() + 18;
				car.setLocation(xPoint, yPoint);
			}
		}
		
		for (int i=previousLocation+1 ; i<=location ; i++) {
			
			xPoint = (int)Jlist[i].getLocation().getX() + 50;
			yPoint = (int)Jlist[i].getLocation().getY() + 18;
			car.setLocation(xPoint, yPoint);
			
		}
		
		if(ct[location] != null){
			cityAction(location);
			
			/*
			carinfo.setText("이름 : " + c.getName()
			+ " 자금 : " + c.getMoney());
			*/
		}
		else
			func();
	}
	
	public void cityAction(int location) {
		
		int result = 0;
		int cityStatus = ct[location].getStatus();
		
		if(cityStatus == 0) {
			// 구입 X 0
			
			result = cityManager.OwnCity(ct[location], c, user1Money);
			
			if (result == 0) {
				cityAction(location);
			}
			
			else if (result == JOptionPane.CLOSED_OPTION)
				;
		}

		else {
			
			String r  = cityManager.UpgradeCity(
					ct[location], c, user1Money);
			
			if (r==null) return;
			
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
			
			else if (cityStatus == 3) {

				cityStatus = ct[location].getStatus();
				
				if (r.equals("1"))
					building(location, cityStatus, 1);
			}
			
			else if (cityStatus == 4) {

				cityStatus = ct[location].getStatus();
				
				if (r.equals("0")) 
					building(location, cityStatus, 0);
			}
			
			else
				System.out.println("랜드마크 방문 보상 ");
		}
		
	}

	public void func() {
		
		previousLocation = location;
		
		switch (location) {
		case 0 :
			salary();
			break;
		case 3 :
			goldkey.setFlag(true);
			goldkey.goldKeyEvent(ct, Jlist, car, c, btn1,
					planeMsg, sellMsg, olympicMsg);
			if ((location = c.getLocation())
					!=previousLocation)
					func();
			break;
		case 6:
			goldkey.gotoAirport(btn1, planeMsg); 
			break;
		case 9 :
			goldkey.setFlag(true);
			goldkey.goldKeyEvent(ct, Jlist, car, c, btn1,
					planeMsg, sellMsg, olympicMsg);
			if ((location = c.getLocation())
					!=previousLocation)
					func();
			break;
		case 12 :
			goldkey.openOlympic(ct, Jlist, btn1, olympicMsg);
			break;
		case 15 :
			goldkey.setFlag(true);
			goldkey.goldKeyEvent(ct, Jlist, car, c, btn1,
					planeMsg, sellMsg, olympicMsg);
			if ((location = c.getLocation())
				!=previousLocation) {
				func();
			}
			break;
		case 18 :
			System.out.println("무인도 ");
			goldkey.setFlag(false);
			goldkey.toIsland(Jlist, car, c); 
			location = c.getLocation();
			break;
		case 21 :
			goldkey.setFlag(true);
			goldkey.goldKeyEvent(ct, Jlist, car, c, btn1,
					planeMsg, sellMsg, olympicMsg);
			if ((location = c.getLocation())
					!=previousLocation)
					func();
			break;
		}
	}
	
	public void salary() {
		JOptionPane.showMessageDialog(this, "월급을 받습니다 (+1000000원)");
		c.setMoney(c.getMoney()+1000000);
		
		/*
		user1Info.setText("<html>아이디: " + c.getName()
		+ "<br>자산: " + c.getMoney() + "</html>");
		*/
		user1Money.setText(c.getMoney()+"");
		
	}
	
	public void building(int location, int cityStatus, int upto) {
		printBuildingColor(location, cityStatus, cityStatus-1+upto);
	}	

	public void printBuildingColor(int location,
			 int cityStatus, int lastBuilding) {
		
		String name;
		
		if (cityStatus==5) {
			Jlist[location].setOpaque(true);
			Jlist[location].setBackground(Color.blue);
		}
		
		else
			for(Component pan : panelBoard.getComponents()) {
				
				for (int i=cityStatus ; i<=lastBuilding ; i++) {
					name = pan.getName();
					if (name!=null) {
						if (name.equals("Jlist"+location+""+i))
							pan.setBackground(Color.blue);
					}
				}
			}
	}
	
	public void selection(JLabel selectedCountry) {
		
		if (planeMsg.isVisible()) {
			for (int i=1 ; i<Jlist.length ; i++)
				if (Jlist[i] == selectedCountry) {
					moveHorse(location = i);
					planeMsg.setVisible(false);
					btn1.setEnabled(true);
					break;
				}
		}
		else if (sellMsg.isVisible()) {
			
			int cityStatus=0, result;
			int cost = 0;
			Object[] option = {"예", "아니오"};
			String compName = null;
			
			for (int i=1 ; i<ct.length ; i++)
				
				if (Jlist[i] == selectedCountry) {
					
					try{
						cityStatus = ct[i].getStatus();
					} catch (NullPointerException e) {
						JOptionPane.showMessageDialog(this,
								"선택 불가");
						goldkey.sellCity(btn1, sellMsg, ct, Jlist, planeMsg);
						break;
					}
					
					if (cityStatus == 0) {
						JOptionPane.showMessageDialog(this,
								selectedCountry.getText()
								+ " 은(는) 소유한 도시가 아닙니다.");
						goldkey.sellCity(btn1, sellMsg, ct, Jlist, planeMsg);
						break;
					}
					
					else if (cityStatus == 1)
						cost = ct[i].getGrandCost();
					
					else if (cityStatus == 2)
						cost = 10;
					
					else if (cityStatus == 3)
						cost = 25;
					
					else if (cityStatus == 4)
						cost = 45;
					
					else {
						JOptionPane.showMessageDialog(this,
								"랜드마크는 매각할 수 없습니다.");
						goldkey.sellCity(btn1, sellMsg, ct, Jlist, planeMsg);
						break;
					}
					
					result = JOptionPane.showOptionDialog(this,
							selectedCountry.getText()
							+ " 을(를) 매각하시겠습니까?", "도시 매각",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, 
							null, option, option[1]);
					
					if (result==0) {
					
						JOptionPane.showMessageDialog(this,
								selectedCountry.getText()
								+ "의 건물 " + (cityStatus-1)
								+ "채를 매각합니다.\n+"
								+ cost + "원");
						c.setMoney(c.getMoney() + cost);
						user1Money.setText(c.getMoney()+"");
						ct[i].setStatus(0);
						
						for(Component pan : panelBoard.getComponents()) {
							
							for (int j=1 ; j<=3 ; j++) {
								compName = pan.getName();
								if (compName!=null) {
									if (compName.equals("Jlist"+i+""+j)) {
										((JComponent) pan).setOpaque(false);
										System.out.println(compName + " 매각");
									}
								}
							}
						}
						
						sellMsg.setVisible(false);
						btn1.setEnabled(true);
						listEnableTrue(ct, Jlist);
						break;
					}
				}
		}
		
		else {
			
			for (int i=1 ; i<Jlist.length ; i++)
				
				if (Jlist[i] == selectedCountry) {
					
					if (ct[i].getStatus()==0) {
						JOptionPane.showMessageDialog(this,
								"본인 소유가 아니므로 올림픽 개최가 불가능한 도시입니다.");
						goldkey.openOlympic(ct, Jlist, btn1, olympicMsg);
						break;
					}
					
					olympicMsg.setVisible(false);
					JOptionPane.showMessageDialog(this,
							ct[i].getName()
							+ " 올림픽 개최!\n통행료가 "
									+ computeFee(ct[i])*2
									+ "원 인상되었습니다.");
					btn1.setEnabled(true);
					listEnableTrue(ct, Jlist);
					break;
				}
		}
	}
	
	public void listEnableTrue(Cities[] ct, JLabel[] Jlist) {
		for (int i=0 ; i<ct.length ; i++) {
			if (i%3!=0)
				continue;
			Jlist[i].setEnabled(false);
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
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		selection((JLabel)(e.getSource()));		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
