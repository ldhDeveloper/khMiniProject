package marble.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import gui.test.Cities;

public class pageGame extends JFrame {

	private JPanel panelBoard, panelChat, panelInfo;
	private JLabel infoLabel, infoLabel2, infoLabel3, user1Label, user2Label, 
					user3Label, user4Label, user1Info, user2Info, user3Info, user4Info,
					c1b1, c1b2, c1b3, c2b1, c2b2, c2b3, c3b1, c3b2, c3b3,
					c4b1, c4b2, c4b3, c5b1, c5b2, c5b3, c6b1, c6b2, c6b3,
					c7b1, c7b2, c7b3, c8b1, c8b2, c8b3, c9b1, c9b2, c9b3,
					c10b1, c10b2, c10b3, c11b1, c11b2, c11b3, c12b1, c12b2, c12b3,
					c13b1, c13b2, c13b3, c14b1, c14b2, c14b3, c15b1, c15b2, c15b3,
					c16b1, c16b2, c16b3;
	private JTextArea gameInfo, chatScreen;
	private JTextField chatField;
	private JButton buttonStart, buttonFinish;
	private JLabel[] Jlist = new JLabel[24];
	private JButton btn1;
	private Cities[] ct = new Cities[24];
	
	public pageGame(){
		this.setTitle("BlueMarble");
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		Board();
		diceInit();
		Chat();
		Info();
			
		this.setVisible(true);
	}

	private void Board(){
		
		panelBoard = new JPanel();
		panelBoard.setLayout(null);
		panelBoard.setBounds(20, 30, 900, 550);
		//panelBoard.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		Jlist[0] = new JLabel("출발지");
		Jlist[0].setHorizontalAlignment(Jlist[0].CENTER);
		Jlist[0].setBounds(0, 0, 150, 100);
		Jlist[0].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[1] = new JLabel("도시1");
		Jlist[1].setHorizontalAlignment(Jlist[1].CENTER);
		Jlist[1].setBounds(155, 0, 120, 100);
		Jlist[1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c1b1 = new JLabel();
		c1b1.setBounds(155, 80, 40, 20);
		c1b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c1b2 = new JLabel();
		c1b2.setBounds(195, 80, 40, 20);
		c1b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c1b3 = new JLabel();
		c1b3.setBounds(235, 80, 40, 20);
		c1b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		Jlist[2] = new JLabel("도시2");
		Jlist[2].setHorizontalAlignment(Jlist[2].CENTER);
		Jlist[2].setBounds(280, 0, 120, 100);
		Jlist[2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c2b1 = new JLabel();
		c2b1.setBounds(280, 80, 40, 20);
		c2b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c2b2 = new JLabel();
		c2b2.setBounds(320, 80, 40, 20);
		c2b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c2b3 = new JLabel();
		c2b3.setBounds(360, 80, 40, 20);
		c2b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	
		Jlist[3] = new JLabel("황금열쇠");
		Jlist[3].setHorizontalAlignment(Jlist[3].CENTER);
		Jlist[3].setBounds(405, 0, 90, 100);
		Jlist[3].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[4] = new JLabel("도쿄");
		Jlist[4].setHorizontalAlignment(Jlist[4].CENTER);
		Jlist[4].setBounds(500, 0, 120, 100);
		Jlist[4].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c3b1 = new JLabel();
		c3b1.setBounds(500, 80, 40, 20);
		c3b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c3b2 = new JLabel();
		c3b2.setBounds(540, 80, 40, 20);
		c3b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c3b3 = new JLabel();
		c3b3.setBounds(580, 80, 40, 20);
		c3b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		Jlist[5] = new JLabel("베이징");
		Jlist[5].setHorizontalAlignment(Jlist[5].CENTER);
		Jlist[5].setBounds(625, 0, 120, 100);
		Jlist[5].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c4b1 = new JLabel();
		c4b1.setBounds(625, 80, 40, 20);
		c4b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c4b2 = new JLabel();
		c4b2.setBounds(665, 80, 40, 20);
		c4b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c4b3 = new JLabel();
		c4b3.setBounds(705, 80, 40, 20);
		c4b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		Jlist[6] = new JLabel("세계여행");
		Jlist[6].setHorizontalAlignment(Jlist[6].CENTER);
		Jlist[6].setBounds(750, 0, 150, 100);
		Jlist[6].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		
		Jlist[7] = new JLabel("뉴델리");
		Jlist[7].setHorizontalAlignment(Jlist[7].CENTER);
		Jlist[7].setBounds(750, 105, 150, 60);
		Jlist[7].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c5b1 = new JLabel();
		c5b1.setBounds(750, 105, 30, 20);
		c5b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c5b2 = new JLabel();
		c5b2.setBounds(750, 125, 30, 20);
		c5b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c5b3 = new JLabel();
		c5b3.setBounds(750, 145, 30, 20);
		c5b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		Jlist[8] = new JLabel("두바이");
		Jlist[8].setHorizontalAlignment(Jlist[8].CENTER);
		Jlist[8].setBounds(750, 170, 150, 60);
		Jlist[8].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c6b1 = new JLabel();
		c6b1.setBounds(750, 170, 30, 20);
		c6b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c6b2 = new JLabel();
		c6b2.setBounds(750, 190, 30, 20);
		c6b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c6b3 = new JLabel();
		c6b3.setBounds(750, 210, 30, 20);
		c6b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		Jlist[9] = new JLabel("황금열쇠");
		Jlist[9].setHorizontalAlignment(Jlist[9].CENTER);
		Jlist[9].setBounds(750, 235, 150, 80);
		Jlist[9].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[10] = new JLabel("캔버라");
		Jlist[10].setHorizontalAlignment(Jlist[10].CENTER);
		Jlist[10].setBounds(750, 320, 150, 60);
		Jlist[10].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c7b1 = new JLabel();
		c7b1.setBounds(750, 320, 30, 20);
		c7b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c7b2 = new JLabel();
		c7b2.setBounds(750, 340, 30, 20);
		c7b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c7b3 = new JLabel();
		c7b3.setBounds(750, 360, 30, 20);
		c7b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		Jlist[11] = new JLabel("카이로");
		Jlist[11].setHorizontalAlignment(Jlist[11].CENTER);
		Jlist[11].setBounds(750, 385, 150, 60);
		Jlist[11].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c8b1 = new JLabel();
		c8b1.setBounds(750, 385, 30, 20);
		c8b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c8b2 = new JLabel();
		c8b2.setBounds(750, 405, 30, 20);
		c8b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c8b3 = new JLabel();
		c8b3.setBounds(750, 425, 30, 20);
		c8b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		Jlist[12] = new JLabel("올림픽");
		Jlist[12].setHorizontalAlignment(Jlist[12].CENTER);
		Jlist[12].setBounds(750, 450, 150, 100);
		Jlist[12].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[13] = new JLabel("상파울로");
		Jlist[13].setHorizontalAlignment(Jlist[13].CENTER);
		Jlist[13].setBounds(625, 450, 120, 100);
		Jlist[13].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c9b1 = new JLabel();
		c9b1.setBounds(625, 450, 40, 20);
		c9b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c9b2 = new JLabel();
		c9b2.setBounds(665, 450, 40, 20);
		c9b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c9b3 = new JLabel();
		c9b3.setBounds(705, 450, 40, 20);
		c9b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		Jlist[14] = new JLabel("아테네");
		Jlist[14].setHorizontalAlignment(Jlist[14].CENTER);
		Jlist[14].setBounds(500, 450, 120, 100);
		Jlist[14].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c10b1 = new JLabel();
		c10b1.setBounds(500, 450, 40, 20);
		c10b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c10b2 = new JLabel();
		c10b2.setBounds(540, 450, 40, 20);
		c10b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c10b3 = new JLabel();
		c10b3.setBounds(580, 450, 40, 20);
		c10b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		Jlist[15] = new JLabel("황금열쇠");
		Jlist[15].setHorizontalAlignment(Jlist[15].CENTER);
		Jlist[15].setBounds(405, 450, 90, 100);
		Jlist[15].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[16] = new JLabel("코펜하겐");
		Jlist[16].setHorizontalAlignment(Jlist[16].CENTER);
		Jlist[16].setBounds(280, 450, 120, 100);
		Jlist[16].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c11b1 = new JLabel();
		c11b1.setBounds(280, 450, 40, 20);
		c11b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c11b2 = new JLabel();
		c11b2.setBounds(320, 450, 40, 20);
		c11b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c11b3 = new JLabel();
		c11b3.setBounds(360, 450, 40, 20);
		c11b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		Jlist[17] = new JLabel("베를린");
		Jlist[17].setHorizontalAlignment(Jlist[17].CENTER);
		Jlist[17].setBounds(155, 450, 120, 100);
		Jlist[17].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c12b1 = new JLabel();
		c12b1.setBounds(155, 450, 40, 20);
		c12b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c12b2 = new JLabel();
		c12b2.setBounds(195, 450, 40, 20);
		c12b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c12b3 = new JLabel();
		c12b3.setBounds(235, 450, 40, 20);
		c12b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		Jlist[18] = new JLabel("무인도");
		Jlist[18].setHorizontalAlignment(Jlist[18].CENTER);
		Jlist[18].setBounds(0, 450, 150, 100);
		Jlist[18].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[19] = new JLabel("런던");
		Jlist[19].setHorizontalAlignment(Jlist[19].CENTER);
		Jlist[19].setBounds(0, 385, 150, 60);
		Jlist[19].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c13b1 = new JLabel();
		c13b1.setBounds(120, 385, 30, 20);
		c13b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c13b2 = new JLabel();
		c13b2.setBounds(120, 405, 30, 20);
		c13b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c13b3 = new JLabel();
		c13b3.setBounds(120, 425, 30, 20);
		c13b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		Jlist[20] = new JLabel("파리");
		Jlist[20].setHorizontalAlignment(Jlist[20].CENTER);
		Jlist[20].setBounds(0, 320, 150, 60);
		Jlist[20].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c14b1 = new JLabel();
		c14b1.setBounds(120, 320, 30, 20);
		c14b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c14b2 = new JLabel();
		c14b2.setBounds(120, 340, 30, 20);
		c14b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c14b3 = new JLabel();
		c14b3.setBounds(120, 360, 30, 20);
		c14b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		Jlist[21] = new JLabel("황금열쇠");
		Jlist[21].setHorizontalAlignment(Jlist[21].CENTER);
		Jlist[21].setBounds(0, 235, 150, 80);
		Jlist[21].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[22] = new JLabel("뉴욕");
		Jlist[22].setHorizontalAlignment(Jlist[22].CENTER);
		Jlist[22].setBounds(0, 170, 150, 60);
		Jlist[22].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c15b1 = new JLabel();
		c15b1.setBounds(120, 170, 30, 20);
		c15b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c15b2 = new JLabel();
		c15b2.setBounds(120, 190, 30, 20);
		c15b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c15b3 = new JLabel();
		c15b3.setBounds(120, 210, 30, 20);
		c15b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		Jlist[23] = new JLabel("서울");
		Jlist[23].setHorizontalAlignment(Jlist[23].CENTER);
		Jlist[23].setBounds(0, 105, 150, 60);
		Jlist[23].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		c16b1 = new JLabel();
		c16b1.setBounds(120, 105, 30, 20);
		c16b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c16b2 = new JLabel();
		c16b2.setBounds(120, 125, 30, 20);
		c16b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		c16b3 = new JLabel();
		c16b3.setBounds(120, 145, 30, 20);
		c16b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		for(int i =0; i<Jlist.length;i++){
			panelBoard.add(Jlist[i]);
		}
		
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
		
		this.add(panelBoard);
	}
	
	private void Chat(){
		
		// 채팅창
		chatScreen = new JTextArea("채팅창", 10, 5);
		/*JScrollPane scroll = new JScrollPane(chatScreen);
		chatScreen.setPreferredSize(new Dimension(900, 100));*/
		chatScreen.setBounds(0, 0, 900, 100);
		chatScreen.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		chatScreen.setBorder(BorderFactory.createCompoundBorder
						(BorderFactory.createLineBorder(Color.GRAY), BorderFactory.createEmptyBorder(5,5,5,5)));
		
		// 채팅입력창
		chatField = new JTextField("입력");
		chatField.setBounds(0, 100, 900, 30);
		chatField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		chatField.setBorder(BorderFactory.createCompoundBorder
						(BorderFactory.createLineBorder(Color.GRAY), BorderFactory.createEmptyBorder(5,5,5,5)));
		
		
		panelChat = new JPanel();
		panelChat.setLayout(null);
		panelChat.setBounds(20, 600, 900, 130);
		panelChat.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		panelChat.add(chatScreen);
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
		
		//게임정보창 타이틀
		infoLabel3 = new JLabel("게임안내창");
		infoLabel3.setBounds(20, 335, 100, 20);
		
		// 게임정보창
		gameInfo = new JTextArea("게임안내창", 10, 5);
		gameInfo.setBounds(20, 360, 180, 190);
		gameInfo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		gameInfo.setBorder(BorderFactory.createCompoundBorder
				(BorderFactory.createLineBorder(Color.GRAY), BorderFactory.createEmptyBorder(5,5,5,5)));
		
		// 버튼
		buttonStart = new JButton("게임시작");
		buttonStart.setBounds(20, 590, 180, 40);
		buttonStart.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		buttonStart.setBackground(new Color(255, 125, 64));
		
		
		buttonFinish = new JButton("나가기");
		buttonFinish.setBounds(20, 640, 180, 40);
		buttonFinish.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		buttonFinish.setBackground(new Color(193, 193, 193));
		
		
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
		panelInfo.add(gameInfo);
		panelInfo.add(buttonStart);
		panelInfo.add(buttonFinish);
		
		this.add(panelInfo);
		
	}
	
	public void diceInit() {
		btn1 = new JButton("주사위 버튼");
		btn1.setLocation(300, 200);
		btn1.setSize(100, 50);
		btn1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panelBoard.add(btn1);
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
}
