package marble.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import marble.model.Cities;
import marble.controller.ClientBackground;
import marble.controller.MarbleController;
import java.io.*;
public class PageGame extends JPanel implements MouseListener, ActionListener {

	private JPanel panelBoard, panelChat, panelInfo;
	private JLabel infoLabel, infoLabel2, infoLabel3, user1Label, user2Label, 
					user3Label, user4Label, user1Info, user2Info, user3Info, user4Info,
					user1Money,user2Money,user3Money,user4Money,
					c1b1, c1b2, c1b3, c2b1, c2b2, c2b3, c3b1, c3b2, c3b3,
					c4b1, c4b2, c4b3, c5b1, c5b2, c5b3, c6b1, c6b2, c6b3,
					c7b1, c7b2, c7b3, c8b1, c8b2, c8b3, c9b1, c9b2, c9b3,
					c10b1, c10b2, c10b3, c11b1, c11b2, c11b3, c12b1, c12b2, c12b3,
					c13b1, c13b2, c13b3, c14b1, c14b2, c14b3, c15b1, c15b2, c15b3,
					c16b1, c16b2, c16b3;
	private JTextArea gameInfo, chatScreen;
	private JTextField chatField;
	private JButton btn1, buttonStart, buttonFinish;
	private JLabel[] Jlist = new JLabel[24];
	private JLabel car;
	private JLabel cityInfoLabel = new JLabel("");
	private JLabel planeMsg = new JLabel("이동할 도시를 선택해주세요 ", JLabel.CENTER);
	private JLabel sellMsg = new JLabel("황금열쇠 : 도시 매각 \n매각할 도시를 선택해주세요 ", JLabel.CENTER);;
	private JLabel olympicMsg = new JLabel("황금열쇠 : 올림픽 \n올림픽을 개최할 도시를 선택해주세요 ", JLabel.CENTER);;
	private Cities[] ct = new Cities[24];
	private MarbleController controller;
	private ClientBackground client;
	
	public PageGame(MainFrame m){
				
		
		this.setSize(new Dimension(1200, 800));
		this.setLocation(120, 0);
		this.setLayout(null);
		
		Board();
		Chat();
		Info();

		getController().setBtn1(getBtn1());
		getController().setCar(car);
		getController().setPanelBoard(panelBoard);
		getController().setUserInfo(user1Money);
		getController().setCityInfoLabel(cityInfoLabel);
		getController().setPlaneMsg(planeMsg);
		getController().setSellMsg(sellMsg);
		getController().setOlympicMsgMsg(olympicMsg);
		getController().setJlist(Jlist);
		getController().makeTooltip();
		getController().setPg(this);
		
		/*
        Scanner scanner = new Scanner(System.in);
	    System.out.print("당신의 닉네임부터 설정하세요 : ");
	    nickName = scanner.nextLine() + " : ";
	    scanner.close();   
		
		client.setGui(this);
		client.setNickname(nickName);
        client.connet();
		*/
	}

	private void Board(){
		
		panelBoard = new JPanel();
		panelBoard.setLayout(null);
		panelBoard.setBounds(20, 30, 900, 550);
		//panelBoard.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		setController(new MarbleController());
		
		JlistInit();
		
		carInit();
		diceInit();
		
		panelBoard.add(c1b1);
		panelBoard.add(c1b2);
		panelBoard.add(c1b3);
		panelBoard.add(c2b1);
		panelBoard.add(c2b2);
		panelBoard.add(c2b3);
		panelBoard.add(c3b1);
		panelBoard.add(c3b2);
		panelBoard.add(c3b3);
		panelBoard.add(c4b1);
		panelBoard.add(c4b2);
		panelBoard.add(c4b3);
		panelBoard.add(c5b1);
		panelBoard.add(c5b2);
		panelBoard.add(c5b3);
		panelBoard.add(c6b1);
		panelBoard.add(c6b2);
		panelBoard.add(c6b3);
		panelBoard.add(c7b1);
		panelBoard.add(c7b2);
		panelBoard.add(c7b3);
		panelBoard.add(c8b1);
		panelBoard.add(c8b2);
		panelBoard.add(c8b3);
		panelBoard.add(c9b1);
		panelBoard.add(c9b2);
		panelBoard.add(c9b3);
		panelBoard.add(c10b1);
		panelBoard.add(c10b2);
		panelBoard.add(c10b3);
		panelBoard.add(c11b1);
		panelBoard.add(c11b2);
		panelBoard.add(c11b3);
		panelBoard.add(c12b1);
		panelBoard.add(c12b2);
		panelBoard.add(c12b3);
		panelBoard.add(c13b1);
		panelBoard.add(c13b2);
		panelBoard.add(c13b3);
		panelBoard.add(c14b1);
		panelBoard.add(c14b2);
		panelBoard.add(c14b3);
		panelBoard.add(c15b1);
		panelBoard.add(c15b2);
		panelBoard.add(c15b3);
		panelBoard.add(c16b1);
		panelBoard.add(c16b2);
		panelBoard.add(c16b3);
		panelBoard.add(car);
		panelBoard.add(getBtn1());
		panelBoard.add(planeMsg, 0);
		panelBoard.add(sellMsg);
		panelBoard.add(olympicMsg);
		panelBoard.add(cityInfoLabel, 0);
		
		this.add(panelBoard);
	}
	
	public void Chat(){
		
		// 채팅창
		chatScreen = new JTextArea("채팅창", 10, 5);
		JScrollPane scroll = new JScrollPane(chatScreen);
		//chatScreen.setPreferredSize(new Dimension(900, 100));
		scroll.setBounds(0, 0, 900, 100);
		scroll.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		scroll.setBorder(BorderFactory.createCompoundBorder
						(BorderFactory.createLineBorder(Color.GRAY), BorderFactory.createEmptyBorder(5,5,5,5)));
		
		// 채팅입력창
		chatField = new JTextField("입력");
		chatField.setBounds(0, 100, 900, 30);
		chatField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		chatField.setBorder(BorderFactory.createCompoundBorder
						(BorderFactory.createLineBorder(Color.GRAY), BorderFactory.createEmptyBorder(5,5,5,5)));
		chatField.addMouseListener(this);
		chatField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = chatField.getText() + "\n";
				client.sendMessage(msg);
				chatField.setText("");
			}});
		
		panelChat = new JPanel();
		panelChat.setLayout(null);
		panelChat.setBounds(20, 600, 900, 130);
		panelChat.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		panelChat.add(scroll);
		panelChat.add(chatField);
		
		this.add(panelChat);
	
		
	}
	
	private void Info() {

		// 타이틀
		infoLabel = new JLabel("블루마블 게임방");
		infoLabel.setBounds(35, 20, 160, 50);
		infoLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		// 이용자정보 타이틀
		infoLabel2 = new JLabel("이용자 정보");
		infoLabel2.setBounds(20, 95, 80, 20);
		
		// 이용자정보
		user1Label = new JLabel("1");
		user1Label.setBounds(20, 120, 40, 40);
		user1Label.setHorizontalAlignment(user1Label.CENTER);
		user1Label.setOpaque(true);
		user1Label.setBackground(new Color(238, 99, 99));
		user1Label.setForeground(Color.WHITE);
		
		user1Info = new JLabel("<html>아이디: <br>자산: </html>");
		user1Info.setFont(new Font("Gulim", Font.PLAIN, 12));
		
		user1Info.setBounds(60, 120, 140, 40);
		user1Info.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		user1Info.setBorder(BorderFactory.createCompoundBorder
				(BorderFactory.createLineBorder(Color.GRAY), BorderFactory.createEmptyBorder(0,5,0,0)));
		user1Money=new JLabel();
		user1Info.add(user1Money);
		user1Money.setBorder(null);
		user1Money.setBounds(40, 19, 70, 20);
		
		user2Label = new JLabel("2");
		user2Label.setBounds(20, 170, 40, 40);
		user2Label.setHorizontalAlignment(user2Label.CENTER);
		user2Label.setOpaque(true);
		user2Label.setBackground(new Color(113, 198, 113));
		user2Label.setForeground(Color.WHITE);
		
		user2Info = new JLabel("<html>아이디: <br>자산: </html>");
		user2Info.setFont(new Font("Gulim", Font.PLAIN, 12));
		user2Info.setBounds(60, 170, 140, 40);
		user2Info.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		user2Info.setBorder(BorderFactory.createCompoundBorder
				(BorderFactory.createLineBorder(Color.GRAY), BorderFactory.createEmptyBorder(0,5,0,0)));
		user2Money=new JLabel();
		user2Info.add(user2Money);
		user2Money.setBorder(null);
		user2Money.setBounds(40, 19, 70, 20);
		
		user3Label = new JLabel("3");
		user3Label.setBounds(20, 220, 40, 40);
		user3Label.setHorizontalAlignment(user2Label.CENTER);
		user3Label.setOpaque(true);
		user3Label.setBackground(new Color(99, 184, 255));
		user3Label.setForeground(Color.WHITE);
		
		user3Info = new JLabel("<html>아이디: <br>자산: </html>");
		user3Info.setFont(new Font("Gulim", Font.PLAIN, 12));
		user3Info.setBounds(60, 220, 140, 40);
		user3Info.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		user3Info.setBorder(BorderFactory.createCompoundBorder
				(BorderFactory.createLineBorder(Color.GRAY), BorderFactory.createEmptyBorder(0,5,0,0)));
		user3Money=new JLabel();
		user3Info.add(user3Money);
		user3Money.setBorder(null);
		user3Money.setBounds(40, 19, 70, 20);
		
		user4Label = new JLabel("4");
		user4Label.setBounds(20, 270, 40, 40);
		user4Label.setHorizontalAlignment(user2Label.CENTER);
		user4Label.setOpaque(true);
		user4Label.setBackground(new Color(142, 56, 142));
		user4Label.setForeground(Color.WHITE);
		
		user4Info = new JLabel("<html>아이디: <br>자산: </html>");
		user4Info.setFont(new Font("Gulim", Font.PLAIN, 12));
		user4Info.setBounds(60, 270, 140, 40);
		user4Info.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		user4Info.setBorder(BorderFactory.createCompoundBorder
				(BorderFactory.createLineBorder(Color.GRAY), BorderFactory.createEmptyBorder(0,5,0,0)));
		user4Money=new JLabel();
		user4Info.add(user4Money);
		user4Money.setBorder(null);
		user4Money.setBounds(40, 19, 70, 20);
		
		//게임정보창 타이틀
		infoLabel3 = new JLabel("게임안내창");
		infoLabel3.setBounds(20, 335, 100, 20);
		
		// 게임정보창
		setGameInfo(new JTextArea("게임안내창", 10, 5));
		getGameInfo().setBounds(20, 360, 180, 190);
		getGameInfo().setBorder(BorderFactory.createLineBorder(Color.GRAY));
		getGameInfo().setBorder(BorderFactory.createCompoundBorder
				(BorderFactory.createLineBorder(Color.GRAY), BorderFactory.createEmptyBorder(5,5,5,5)));
		getGameInfo().setEditable(false);
		
		// 버튼
		buttonStart = new JButton("게임시작");
		buttonStart.setBounds(20, 590, 180, 40);
		buttonStart.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		buttonStart.setBackground(new Color(255, 125, 64));
		buttonStart.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				client.sendSignial((byte)40);
				buttonStart.setEnabled(false);
				
				
				
			}});
		
		buttonFinish = new JButton("나가기");
		buttonFinish.setBounds(20, 640, 180, 40);
		buttonFinish.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		buttonFinish.setBackground(new Color(193, 193, 193));
		buttonFinish.addActionListener(this);
		
		
		panelInfo = new JPanel();
		panelInfo.setLayout(null);
		panelInfo.setBounds(940, 30, 220, 700);
		panelInfo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		panelInfo.add(infoLabel);
		panelInfo.add(infoLabel2);
		panelInfo.add(user1Label);
		panelInfo.add(user1Info);
		panelInfo.add(user2Label);
		panelInfo.add(user2Info);
		panelInfo.add(user3Label);
		panelInfo.add(user3Info);
		panelInfo.add(user4Label);
		panelInfo.add(user4Info);
		panelInfo.add(infoLabel3);
		panelInfo.add(getGameInfo());
		panelInfo.add(buttonStart);
		panelInfo.add(buttonFinish);
		
		this.add(panelInfo);
		
	}
	
	public void JlistInit() {
		Jlist[0] = new JLabel("출발지");
		Jlist[0].setHorizontalAlignment(Jlist[0].CENTER);
		Jlist[0].setBounds(0, 0, 150, 100);
		Jlist[0].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[1] = new JLabel("리스본");
		Jlist[1].setHorizontalAlignment(Jlist[1].CENTER);
		Jlist[1].setBounds(155, 0, 120, 100);
		Jlist[1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c1b1 = new JLabel();
		c1b1.setBounds(155, 80, 40, 20);
		c1b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c1b1.setOpaque(true);
		c1b1.setName("Jlist11");
		c1b2 = new JLabel();
		c1b2.setBounds(195, 80, 40, 20);
		c1b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c1b2.setOpaque(true);
		c1b2.setName("Jlist12");
		c1b3 = new JLabel();
		c1b3.setBounds(235, 80, 40, 20);
		c1b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c1b3.setOpaque(true);
		c1b3.setName("Jlist13");
		
		Jlist[2] = new JLabel("방콕");
		Jlist[2].setHorizontalAlignment(Jlist[2].CENTER);
		Jlist[2].setBounds(280, 0, 120, 100);
		Jlist[2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c2b1 = new JLabel();
		c2b1.setBounds(280, 80, 40, 20);
		c2b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c2b1.setOpaque(true);
		c2b1.setName("Jlist21");
		c2b2 = new JLabel();
		c2b2.setBounds(320, 80, 40, 20);
		c2b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c2b2.setOpaque(true);
		c2b2.setName("Jlist22");
		c2b3 = new JLabel();
		c2b3.setBounds(360, 80, 40, 20);
		c2b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c2b3.setOpaque(true);
		c2b3.setName("Jlist23");
	
		ImageIcon key1 = new ImageIcon("key90x100.png");
		Jlist[3] = new JLabel(key1);
		Jlist[3].setBounds(405, 0, 90, 100);
		Jlist[3].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[4] = new JLabel("도쿄");
		Jlist[4].setHorizontalAlignment(Jlist[4].CENTER);
		Jlist[4].setBounds(500, 0, 120, 100);
		Jlist[4].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c3b1 = new JLabel();
		c3b1.setBounds(500, 80, 40, 20);
		c3b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c3b1.setName("Jlist41");
		c3b1.setOpaque(true);
		c3b2 = new JLabel();
		c3b2.setBounds(540, 80, 40, 20);
		c3b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c3b2.setName("Jlist42");
		c3b2.setOpaque(true);
		c3b3 = new JLabel();
		c3b3.setBounds(580, 80, 40, 20);
		c3b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c3b3.setName("Jlist43");
		c3b3.setOpaque(true);
		
		Jlist[5] = new JLabel("베이징");
		Jlist[5].setHorizontalAlignment(Jlist[5].CENTER);
		Jlist[5].setBounds(625, 0, 120, 100);
		Jlist[5].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c4b1 = new JLabel();
		c4b1.setBounds(625, 80, 40, 20);
		c4b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c4b1.setOpaque(true);
		c4b1.setName("Jlist51");
		c4b2 = new JLabel();
		c4b2.setBounds(665, 80, 40, 20);
		c4b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c4b2.setOpaque(true);
		c4b2.setName("Jlist52");
		c4b3 = new JLabel();
		c4b3.setBounds(705, 80, 40, 20);
		c4b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c4b3.setOpaque(true);
		c4b3.setName("Jlist53");
		
		ImageIcon plane = new ImageIcon("plane.png");
		Jlist[6] = new JLabel(plane);
		Jlist[6].setBounds(750, 0, 150, 100);
		Jlist[6].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		
		Jlist[7] = new JLabel("뉴델리");
		Jlist[7].setHorizontalAlignment(Jlist[7].CENTER);
		Jlist[7].setBounds(750, 105, 150, 60);
		Jlist[7].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c5b1 = new JLabel();
		c5b1.setBounds(750, 105, 30, 20);
		c5b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c5b1.setOpaque(true);
		c5b1.setName("Jlist71");
		c5b2 = new JLabel();
		c5b2.setBounds(750, 125, 30, 20);
		c5b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c5b2.setOpaque(true);
		c5b2.setName("Jlist72");
		c5b3 = new JLabel();
		c5b3.setBounds(750, 145, 30, 20);
		c5b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c5b3.setOpaque(true);
		c5b3.setName("Jlist73");
		
		Jlist[8] = new JLabel("두바이");
		Jlist[8].setHorizontalAlignment(Jlist[8].CENTER);
		Jlist[8].setBounds(750, 170, 150, 60);
		Jlist[8].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c6b1 = new JLabel();
		c6b1.setBounds(750, 170, 30, 20);
		c6b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c6b1.setName("Jlist81");
		c6b1.setOpaque(true);
		c6b2 = new JLabel();
		c6b2.setBounds(750, 190, 30, 20);
		c6b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c6b2.setName("Jlist82");
		c6b2.setOpaque(true);
		c6b3 = new JLabel();
		c6b3.setBounds(750, 210, 30, 20);
		c6b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c6b3.setOpaque(true);
		c6b3.setName("Jlist83");
		
		ImageIcon key2 = new ImageIcon("key150x80.png");
		Jlist[9] = new JLabel(key2);
		Jlist[9].setBounds(750, 235, 150, 80);
		Jlist[9].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[10] = new JLabel("캔버라");
		Jlist[10].setHorizontalAlignment(Jlist[10].CENTER);
		Jlist[10].setBounds(750, 320, 150, 60);
		Jlist[10].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c7b1 = new JLabel();
		c7b1.setBounds(750, 320, 30, 20);
		c7b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c7b1.setOpaque(true);
		c7b1.setName("Jlist101");
		c7b2 = new JLabel();
		c7b2.setBounds(750, 340, 30, 20);
		c7b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c7b2.setOpaque(true);
		c7b2.setName("Jlist102");
		c7b3 = new JLabel();
		c7b3.setBounds(750, 360, 30, 20);
		c7b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c7b3.setOpaque(true);
		c7b3.setName("Jlist103");
		
		Jlist[11] = new JLabel("카이로");
		Jlist[11].setHorizontalAlignment(Jlist[11].CENTER);
		Jlist[11].setBounds(750, 385, 150, 60);
		Jlist[11].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c8b1 = new JLabel();
		c8b1.setBounds(750, 385, 30, 20);
		c8b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c8b1.setOpaque(true);
		c8b1.setName("Jlist111");
		c8b2 = new JLabel();
		c8b2.setBounds(750, 405, 30, 20);
		c8b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c8b2.setOpaque(true);
		c8b2.setName("Jlist112");
		c8b3 = new JLabel();
		c8b3.setBounds(750, 425, 30, 20);
		c8b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c8b3.setOpaque(true);
		c8b3.setName("Jlist113");
		
		ImageIcon olympic = new ImageIcon("olympic.png");
		Jlist[12] = new JLabel(olympic);
		Jlist[12].setBounds(750, 450, 150, 100);
		Jlist[12].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[13] = new JLabel("상파울로");
		Jlist[13].setHorizontalAlignment(Jlist[13].CENTER);
		Jlist[13].setBounds(625, 450, 120, 100);
		Jlist[13].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c9b1 = new JLabel();
		c9b1.setBounds(625, 450, 40, 20);
		c9b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c9b1.setOpaque(true);
		c9b1.setName("Jlist131");
		c9b2 = new JLabel();
		c9b2.setBounds(665, 450, 40, 20);
		c9b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c9b2.setOpaque(true);
		c9b2.setName("Jlist132");
		c9b3 = new JLabel();
		c9b3.setBounds(705, 450, 40, 20);
		c9b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c9b3.setOpaque(true);
		c9b3.setName("Jlist133");
		
		Jlist[14] = new JLabel("아테네");
		Jlist[14].setHorizontalAlignment(Jlist[14].CENTER);
		Jlist[14].setBounds(500, 450, 120, 100);
		Jlist[14].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c10b1 = new JLabel();
		c10b1.setBounds(500, 450, 40, 20);
		c10b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c10b1.setOpaque(true);
		c10b1.setName("Jlist141");
		c10b2 = new JLabel();
		c10b2.setBounds(540, 450, 40, 20);
		c10b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c10b2.setOpaque(true);
		c10b2.setName("Jlist142");
		c10b3 = new JLabel();
		c10b3.setBounds(580, 450, 40, 20);
		c10b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c10b3.setOpaque(true);
		c10b3.setName("Jlist143");
		
		Jlist[15] = new JLabel(key1);
		Jlist[15].setBounds(405, 450, 90, 100);
		Jlist[15].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[16] = new JLabel("코펜하겐");
		Jlist[16].setHorizontalAlignment(Jlist[16].CENTER);
		Jlist[16].setBounds(280, 450, 120, 100);
		Jlist[16].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c11b1 = new JLabel();
		c11b1.setBounds(280, 450, 40, 20);
		c11b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c11b1.setOpaque(true);
		c11b1.setName("Jlist161");
		c11b2 = new JLabel();
		c11b2.setBounds(320, 450, 40, 20);
		c11b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c11b2.setOpaque(true);
		c11b2.setName("Jlist162");
		c11b3 = new JLabel();
		c11b3.setBounds(360, 450, 40, 20);
		c11b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c11b3.setOpaque(true);
		c11b3.setName("Jlist163");
		
		Jlist[17] = new JLabel("베를린");
		Jlist[17].setHorizontalAlignment(Jlist[17].CENTER);
		Jlist[17].setBounds(155, 450, 120, 100);
		Jlist[17].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c12b1 = new JLabel();
		c12b1.setBounds(155, 450, 40, 20);
		c12b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c12b1.setOpaque(true);
		c12b1.setName("Jlist171");
		c12b2 = new JLabel();
		c12b2.setBounds(195, 450, 40, 20);
		c12b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c12b2.setOpaque(true);
		c12b2.setName("Jlist172");
		c12b3 = new JLabel();
		c12b3.setBounds(235, 450, 40, 20);
		c12b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c12b3.setOpaque(true);
		c12b3.setName("Jlist173");
		
		ImageIcon island = new ImageIcon("island.png");
		Jlist[18] = new JLabel(island);
		Jlist[18].setBounds(0, 450, 150, 100);
		Jlist[18].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[19] = new JLabel("런던");
		Jlist[19].setHorizontalAlignment(Jlist[19].CENTER);
		Jlist[19].setBounds(0, 385, 150, 60);
		Jlist[19].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c13b1 = new JLabel();
		c13b1.setBounds(120, 385, 30, 20);
		c13b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c13b1.setOpaque(true);
		c13b1.setName("Jlist191");
		c13b2 = new JLabel();
		c13b2.setBounds(120, 405, 30, 20);
		c13b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c13b2.setOpaque(true);
		c13b2.setName("Jlist192");
		c13b3 = new JLabel();
		c13b3.setBounds(120, 425, 30, 20);
		c13b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c13b3.setOpaque(true);
		c13b3.setName("Jlist193");
		
		Jlist[20] = new JLabel("파리");
		Jlist[20].setHorizontalAlignment(Jlist[20].CENTER);
		Jlist[20].setBounds(0, 320, 150, 60);
		Jlist[20].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c14b1 = new JLabel();
		c14b1.setBounds(120, 320, 30, 20);
		c14b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c14b1.setOpaque(true);
		c14b1.setName("Jlist201");
		c14b2 = new JLabel();
		c14b2.setBounds(120, 340, 30, 20);
		c14b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c14b2.setOpaque(true);
		c14b2.setName("Jlist202");
		c14b3 = new JLabel();
		c14b3.setBounds(120, 360, 30, 20);
		c14b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c14b3.setOpaque(true);
		c14b3.setName("Jlist203");
		
		Jlist[21] = new JLabel(key2);
		Jlist[21].setBounds(0, 235, 150, 80);
		Jlist[21].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[22] = new JLabel("뉴욕");
		Jlist[22].setHorizontalAlignment(Jlist[22].CENTER);
		Jlist[22].setBounds(0, 170, 150, 60);
		Jlist[22].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c15b1 = new JLabel();
		c15b1.setBounds(120, 170, 30, 20);
		c15b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c15b1.setOpaque(true);
		c15b1.setName("Jlist221");
		c15b2 = new JLabel();
		c15b2.setBounds(120, 190, 30, 20);
		c15b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c15b2.setOpaque(true);
		c15b2.setName("Jlist222");
		c15b3 = new JLabel();
		c15b3.setBounds(120, 210, 30, 20);
		c15b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c15b3.setOpaque(true);
		c15b3.setName("Jlist223");
		
		Jlist[23] = new JLabel("서울");
		Jlist[23].setHorizontalAlignment(Jlist[23].CENTER);
		Jlist[23].setBounds(0, 105, 150, 60);
		Jlist[23].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c16b1 = new JLabel();
		c16b1.setBounds(120, 105, 30, 20);
		c16b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c16b1.setOpaque(true);
		c16b1.setName("Jlist231");
		c16b2 = new JLabel();
		c16b2.setBounds(120, 125, 30, 20);
		c16b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c16b2.setOpaque(true);
		c16b2.setName("Jlist232");
		c16b3 = new JLabel();
		c16b3.setBounds(120, 145, 30, 20);
		c16b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c16b3.setOpaque(true);
		c16b3.setName("Jlist233");
		
		for(int i =0; i<Jlist.length;i++){
			panelBoard.add(Jlist[i]);
		}
		
		getController().addJlistEvent(Jlist);
	}
	
	public void carInit() {
		car = new JLabel("1");
		car.setOpaque(true);
		car.setHorizontalAlignment(car.CENTER);
		car.setForeground(Color.white);
		car.setBackground(new Color(238, 99, 99));
		car.setSize(15,15);
		car.setLocation(100,68);
		car.setBorder(BorderFactory.createLineBorder(Color.white, 1));
	}
	
	public void diceInit() {
		setBtn1(new JButton("주사위 버튼"));
		getBtn1().setLocation(300, 300);
		getBtn1().setSize(100, 50);
		getBtn1().setBorder(BorderFactory.createLineBorder(Color.black, 1));
		getBtn1().addActionListener(this);
		getBtn1().setName("btn1");
		getBtn1().setEnabled(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource()==chatField) {
			if (chatField.getText().equals("입력"))
				chatField.setText("");
		}
		
		else if (e.getSource()==buttonFinish)
			getController().exitMarble();
		
		else{			
				controller.rollDice(gameInfo);
			getBtn1().setEnabled(false);
			PageGame distribution = null;
			distribution = (PageGame) (client.getM().getPan3());
			MarbleController gift = null;
			gift = distribution.getController();
			try {
				client.getOos().writeObject(distribution);
				client.getOos().writeObject(gift);
			} catch (IOException ioe) {
				ioe.printStackTrace();

			}
			}

		}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource()==chatField) {
			if (chatField.getText().equals("입력"))
				chatField.setText("");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	public void appendMsg(String msg) {
		chatScreen.append(msg);
		chatScreen.setCaretPosition(chatScreen.getDocument().getLength());
		//스크롤바 아래로
	}
	public JLabel getUser1Info(){
		return user1Info;
	}
	public JLabel getUser2Info(){
		return user2Info;
	}
	public JLabel getUser3Info(){
		return user3Info;
	}
	public JLabel getUser4Info(){
		return user4Info;
	}
	
	public ClientBackground getClient() {
		return client;
	}
	
	public void setClient(ClientBackground client) {
		this.client = client;
	}
	
	public JLabel getUser1Money(){
		return this.user1Money;
	}
	public JLabel getUser2Money(){
		return this.user2Money;
	}
	public JLabel getUser3Money(){
		return this.user3Money;
	}
	public JLabel getUser4Money(){
		return this.user4Money;
	}
	
	public String getChatMsg() {
		return chatField.getText();
	}

	public JButton getBtn1() {
		return btn1;
	}

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	public MarbleController getController() {
		return controller;
	}

	public void setController(MarbleController controller) {
		this.controller = controller;
	}

	public JTextArea getGameInfo() {
		return gameInfo;
	}

	public void setGameInfo(JTextArea gameInfo) {
		this.gameInfo = gameInfo;
	}
	
}