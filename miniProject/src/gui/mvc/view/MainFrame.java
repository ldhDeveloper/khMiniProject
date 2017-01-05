package gui.mvc.view;
import javax.swing.*;
import java.awt.*;
public class MainFrame extends JFrame{
	public MainFrame(){
		this.setTitle("Blue Marble");
		this.setSize(new Dimension(1200, 800));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardLayout cardL = new CardLayout();
		this.setLayout(cardL);
		
		
		this.setVisible(true);
		
	}
	

}
