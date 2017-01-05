package marble.controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import marble.model.Charcter;
import marble.model.Cities;

import java.util.*;

public class marbleController extends JFrame implements ActionListener, MouseListener {
	
	Charcter c;
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JLabel car, carinfo, building, diceLabel;
	JLabel diceLabelImage1, diceLabelImage2;
	ImageIcon diceImage[] ;
	JLabel planeMsg = new JLabel("이동할 도시를 선택해주세요 ", JLabel.CENTER);
	JButton btn1;
	JLabel[] Jlist = new JLabel[24];
	Cities[] ct = new Cities[24];
	int location, xPoint, yPoint ;
	
	
	public marbleController(){ 
		
		c = new Charcter(1, "1번", 2000, 0);

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
		
		Jlist[0] = new JLabel(" 출발지");
		Jlist[0].setLocation(50, 50);
		Jlist[0].setSize(100, 50);
		Jlist[0].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[1] = new JLabel(" 뉴욕");
		Jlist[1].setLocation(160, 50);
		Jlist[1].setSize(100, 50);
		Jlist[1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[2] = new JLabel(" 서울");
		Jlist[2].setLocation(270, 50);
		Jlist[2].setSize(100, 50);
		Jlist[2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[3] = new JLabel(" ★");
		Jlist[3].setLocation(380, 50);
		Jlist[3].setSize(100, 50);
		Jlist[3].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[4] = new JLabel(" 도쿄");
		Jlist[4].setLocation(490, 50);
		Jlist[4].setSize(100, 50);
		Jlist[4].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[5] = new JLabel(" " + ct[5].getName());
		Jlist[5].setLocation(600, 50);
		Jlist[5].setSize(100, 50);
		Jlist[5].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[6] = new JLabel(" ★비행기★ ");
		Jlist[6].setLocation(710, 50);
		Jlist[6].setSize(100, 50);
		Jlist[6].setOpaque(true);
		Jlist[6].setBackground(Color.cyan);
		Jlist[6].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[7] = new JLabel(" " + ct[7].getName());
		Jlist[7].setLocation(710, 110);
		Jlist[7].setSize(100, 50);
		Jlist[7].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[8] = new JLabel(" " + ct[8].getName());
		Jlist[8].setLocation(710, 170);
		Jlist[8].setSize(100, 50);
		Jlist[8].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[9] = new JLabel("★");
		Jlist[9].setLocation(710, 230);
		Jlist[9].setSize(100, 50);
		Jlist[9].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[10] = new JLabel(" " + ct[10].getName());
		Jlist[10].setLocation(710, 290);
		Jlist[10].setSize(100, 50);
		Jlist[10].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[11] = new JLabel(" " + ct[11].getName());
		Jlist[11].setLocation(710, 350);
		Jlist[11].setSize(100, 50);
		Jlist[11].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[12] = new JLabel("★");
		Jlist[12].setLocation(710, 410);
		Jlist[12].setSize(100, 50);
		Jlist[12].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[13] = new JLabel(" " + ct[13].getName());
		Jlist[13].setLocation(600, 410);
		Jlist[13].setSize(100, 50);
		Jlist[13].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[14] = new JLabel(" " + ct[14].getName());
		Jlist[14].setLocation(490, 410);
		Jlist[14].setSize(100, 50);
		Jlist[14].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[15] = new JLabel("★");
		Jlist[15].setLocation(380, 410);
		Jlist[15].setSize(100, 50);
		Jlist[15].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[16] = new JLabel(" " + ct[16].getName());
		Jlist[16].setLocation(270, 410);
		Jlist[16].setSize(100, 50);
		Jlist[16].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[17] = new JLabel(" " + ct[17].getName());
		Jlist[17].setLocation(160, 410);
		Jlist[17].setSize(100, 50);
		Jlist[17].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[18] = new JLabel(" ★무인도★ ");
		Jlist[18].setLocation(50, 410);
		Jlist[18].setSize(100, 50);
		Jlist[18].setOpaque(true);
		Jlist[18].setBackground(Color.darkGray);
		Jlist[18].setForeground(Color.white);
		Jlist[18].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[19] = new JLabel(" " + ct[19].getName());
		Jlist[19].setLocation(50, 350);
		Jlist[19].setSize(100, 50);
		Jlist[19].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[20] = new JLabel(" " + ct[20].getName());
		Jlist[20].setLocation(50, 290);
		Jlist[20].setSize(100, 50);
		Jlist[20].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[21] = new JLabel("★");
		Jlist[21].setLocation(50, 230);
		Jlist[21].setSize(100, 50);
		Jlist[21].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[22] = new JLabel(" " + ct[22].getName());
		Jlist[22].setLocation(50, 170);
		Jlist[22].setSize(100, 50);
		Jlist[22].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[23] = new JLabel(" " + ct[23].getName());
		Jlist[23].setLocation(50, 110);
		Jlist[23].setSize(100, 50);
		Jlist[23].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
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
		
		btn1 = new JButton("주사위 버튼");
		btn1.setLocation(300, 200);
		btn1.setSize(100, 50);
		btn1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		btn1.addActionListener(this);
		
		add();
		
	}
	
	public void add() {
		
		for(int i =0; i<Jlist.length ; i++){
			if (!(i==6)) // 비행기가 아니면 
				Jlist[i].addMouseListener(this);
			f.add(Jlist[i]);
		}
		
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

		f.add(car);
		f.add(carinfo);
		f.add(btn1);
		f.add(diceLabel);
		f.add(diceLabelImage1);
		f.add(diceLabelImage2);
		f.add(planeMsg, 0);
		
		planeMsg.setVisible(false);
		f.setVisible(true);
	}
	
	public void cityInit() {
		ct[1] = new Cities("뉴욕", 0, 0, 20);
		ct[2] = new Cities("서울", 0, 0, 20);
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
	
	public void cityAction(int location) {
		
		int result;
		
		if(ct[location].getStatus() == 0){
			// 구입 했으면 1, 구입 X 0
			
			if ((result = new CityManager().
					OwnCity(ct[location], c)) == 0) {
				building(location);
			}
		}
		
	}
	
	public void building(int location) {
		building = new JLabel();
		building.setSize(30,30);
		building.setLocation(Jlist[location].getLocation());
		building.setOpaque(true);
		building.setBackground(Color.blue);
		building.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		f.add(building);
	}
	
	public void plane() {
		btn1.setEnabled(false);
		planeMsg.setSize(400, 150);
		planeMsg.setLocation(f.getSize().width/2 - 400/2 , f.getSize().height/2 - 150);
		planeMsg.setOpaque(true);
		planeMsg.setBackground(new Color(225, 225, 225));
		planeMsg.setVisible(true);
	}
	
	public void moveHorse(int location) {
		
		c.setLocation(location); // 캐릭터 위치 값 저장
		
		xPoint = (int)Jlist[location].getLocation().getX() + 50;
		yPoint = (int)Jlist[location].getLocation().getY() + 18;
		car.setLocation(xPoint, yPoint); // 말 위치 이동
		
		if(ct[location] != null){
			cityAction(location);
			carinfo.setText("이름 : " + c.getName()
			+ " 자금 : " + c.getMoney());
		}
		else
			switch (location) {
			case 0 :
				System.out.println("월급 ");
				break;
			case 3 :
				System.out.println("★");
				break;
			case 6:
				plane();
				break;
			case 9 :
				System.out.println("★");
				break;
			case 12 :
				System.out.println("★");
				break;
			case 15 :
				System.out.println("★");
				break;
			case 18 :
				System.out.println("무인도 ");
				break;
			case 21 :
				System.out.println("★");
				break;
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
			int dice1 = new Random().nextInt(6) + 1;
			int dice2 = new Random().nextInt(6) + 1;
			int dice = dice1 + dice2;
			
			diceLabel.setText(dice + "칸 이동! ");
			
			diceLabelImage1.setIcon(diceImage[dice1-1]);
			diceLabelImage2.setIcon(diceImage[dice2-1]);

			location = c.getLocation() + dice;
			
			if(location >= Jlist.length)
				location -= Jlist.length;
			
			moveHorse(location);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		JLabel selectedCountry = (JLabel)(e.getSource());
		
		if (planeMsg.isVisible()) {
			for (int i=0 ; i<Jlist.length ; i++)
				if (Jlist[i] == selectedCountry) {
					moveHorse(i);
					planeMsg.setVisible(false);
					btn1.setEnabled(true);
					break;
				}
		}
			
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		marbleController test = new marbleController();
	}

}
