package gui.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class TestGui extends JFrame{
	
	Charcter c;
	JLabel car, carinfo, diceLabel;
	JLabel diceLabelImage1, diceLabelImage2;
	JButton btn1;
	JLabel[] Jlist = new JLabel[24];
	Cities[] ct = new Cities[24];
	
	
	public TestGui(){
		
		
		c = new Charcter(1, "1번", 2000, 0);
		
		
		ct[1] = new Cities("뉴욕", 50, 0, 0, 20, 10);
		ct[2] = new Cities("서울", 70, 0, 0, 20, 10);

		
		
		JFrame f = new JFrame();
		f.setTitle("부루마블");
		f.setSize(1000, 780);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		f.setLayout(null);
		
		car = new JLabel("A");
		car.setBackground(Color.RED);
		car.setSize(15,15);
		car.setLocation(100,70);
		car.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		carinfo = new JLabel("이름 : " + c.getName() + " 자금 : " + c.getMoney());
		carinfo.setSize(200,100);
		carinfo.setLocation(200,300);
		carinfo.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[0] = new JLabel("출발지");
		Jlist[0].setLocation(50, 50);
		Jlist[0].setSize(100, 50);
		Jlist[0].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[1] = new JLabel("도시2");
		Jlist[1].setLocation(160, 50);
		Jlist[1].setSize(100, 50);
		Jlist[1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[2] = new JLabel("도시3");
		Jlist[2].setLocation(270, 50);
		Jlist[2].setSize(100, 50);
		Jlist[2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[3] = new JLabel("도시4");
		Jlist[3].setLocation(380, 50);
		Jlist[3].setSize(100, 50);
		Jlist[3].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[4] = new JLabel("도시5");
		Jlist[4].setLocation(490, 50);
		Jlist[4].setSize(100, 50);
		Jlist[4].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[5] = new JLabel("도시6");
		Jlist[5].setLocation(600, 50);
		Jlist[5].setSize(100, 50);
		Jlist[5].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[6] = new JLabel("도시7");
		Jlist[6].setLocation(710, 50);
		Jlist[6].setSize(100, 50);
		Jlist[6].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[7] = new JLabel("도시8");
		Jlist[7].setLocation(710, 110);
		Jlist[7].setSize(100, 50);
		Jlist[7].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[8] = new JLabel("도시9");
		Jlist[8].setLocation(710, 170);
		Jlist[8].setSize(100, 50);
		Jlist[8].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[9] = new JLabel("도시10");
		Jlist[9].setLocation(710, 230);
		Jlist[9].setSize(100, 50);
		Jlist[9].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[10] = new JLabel("도시11");
		Jlist[10].setLocation(710, 290);
		Jlist[10].setSize(100, 50);
		Jlist[10].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[11] = new JLabel("도시12");
		Jlist[11].setLocation(710, 350);
		Jlist[11].setSize(100, 50);
		Jlist[11].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[12] = new JLabel("도시13");
		Jlist[12].setLocation(710, 410);
		Jlist[12].setSize(100, 50);
		Jlist[12].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[13] = new JLabel("도시14");
		Jlist[13].setLocation(600, 410);
		Jlist[13].setSize(100, 50);
		Jlist[13].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[14] = new JLabel("도시15");
		Jlist[14].setLocation(490, 410);
		Jlist[14].setSize(100, 50);
		Jlist[14].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[15] = new JLabel("도시16");
		Jlist[15].setLocation(380, 410);
		Jlist[15].setSize(100, 50);
		Jlist[15].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[16] = new JLabel("도시17");
		Jlist[16].setLocation(270, 410);
		Jlist[16].setSize(100, 50);
		Jlist[16].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[17] = new JLabel("도시18");
		Jlist[17].setLocation(160, 410);
		Jlist[17].setSize(100, 50);
		Jlist[17].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[18] = new JLabel("도시19");
		Jlist[18].setLocation(50, 410);
		Jlist[18].setSize(100, 50);
		Jlist[18].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[19] = new JLabel("도시20");
		Jlist[19].setLocation(50, 350);
		Jlist[19].setSize(100, 50);
		Jlist[19].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[20] = new JLabel("도시21");
		Jlist[20].setLocation(50, 290);
		Jlist[20].setSize(100, 50);
		Jlist[20].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[21] = new JLabel("도시22");
		Jlist[21].setLocation(50, 230);
		Jlist[21].setSize(100, 50);
		Jlist[21].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[22] = new JLabel("도시23");
		Jlist[22].setLocation(50, 170);
		Jlist[22].setSize(100, 50);
		Jlist[22].setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		Jlist[23] = new JLabel("도시24");
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

		ImageIcon diceImage[] = new ImageIcon[6];
		for (int i=0 ; i<6 ; i++) 
			diceImage[i] = new ImageIcon("dice" + (i+1) + ".png");
		
		diceLabel = new JLabel("");
		diceLabel.setLocation(240, 220);
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
		

		
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dice1 = new Random().nextInt(6) + 1;
				int dice2 = new Random().nextInt(6) + 1;
				int dice = dice1 + dice2;
				
				diceLabel.setText(dice + "칸 이동! ");
				
				diceLabelImage1.setIcon(diceImage[dice1-1]);
				diceLabelImage2.setIcon(diceImage[dice2-1]);

				int location = c.getLocation() + dice;
				
				if(location >= Jlist.length){
					location -= Jlist.length;
				}
				
				c.setLocation(location); // 캐릭터 위치 값 저장
				
				int xPoint = (int)Jlist[location].getLocation().getX() + 50;
				int yPoint = (int)Jlist[location].getLocation().getY() + 20;
				car.setLocation(xPoint, yPoint); // 말 위치 이동
				
				if(ct[location] != null){
					cityAction(location);
					carinfo.setText("이름 : " + c.getName()
					+ " 자금 : " + c.getMoney());
				}
			}

			

			
			
			
		});
		
	
		
		for(int i =0; i<Jlist.length;i++){
			f.add(Jlist[i]);
		}
		
		
		f.add(car);
		f.add(carinfo);
		f.add(btn1);
		f.add(diceLabel);
		f.add(diceLabelImage1);
		f.add(diceLabelImage2);
		
		f.setVisible(true);
	}
	
	
	
	
	public void cityAction(int location) {
		if(ct[location].getStatus() == 0){
			// 구입 했으면 1, 구입 X 0
			new CityManager().OwnCity(ct[location], c);
		}
		
	}




	public static void main(String[] args) {
		TestGui test = new TestGui();

	}

	
	


}
