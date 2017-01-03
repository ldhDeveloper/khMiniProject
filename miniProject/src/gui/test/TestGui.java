package gui.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestGui extends JFrame{
	JLabel lb1;
	JLabel lb2;
	JButton btn1;
	
	Cities c1 = new Cities("뉴욕", 50);

	
	public TestGui(){
		
		JFrame f = new JFrame();
		f.setTitle("부루마블");
		f.setSize(900, 780);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		f.setLayout(null);
	
		lb1 = new JLabel("도시1");
		lb1.setLocation(50, 50);
		lb1.setSize(100, 50);
		lb1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		lb2 = new JLabel("도시2");
		lb2.setLocation(160, 50);
		lb2.setSize(100, 50);
		lb2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		lb2.addMouseListener(new MouseAdapter(){
			String title = lb2.getText();
			@Override
            public void mouseEntered(MouseEvent me) {
				lb2.setText(c1.getName());
            }
			
			@Override
			public void mouseExited(MouseEvent me){
				lb2.setText(title);
			}
			
			
			
		});
		
		btn1= new JButton("도시3");
		btn1.setLocation(270, 50);
		btn1.setSize(100, 50);
		btn1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		f.add(lb1);
		f.add(lb2);
		f.add(btn1);
		
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		TestGui test = new TestGui();

	}

	
	


}
