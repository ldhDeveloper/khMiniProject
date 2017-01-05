package gui.mvc.view;
import javax.swing.*;
import java.awt.*;
public class MainFrame extends JFrame{
	private CardLayout cardL= new CardLayout();
	
	public MainFrame(){
		this.setTitle("Blue Marble");
		this.setSize(new Dimension(1200, 800));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(cardL);
		JPanel pan1 = new pageLogIn(this);
		JPanel pan2 = new pageJoin(this);
		JPanel pan3 = new pageGame(this);
		this.getContentPane().add("Login", pan1);
		this.getContentPane().add("Join", pan2);
		this.getContentPane().add("game", pan3);
		this.setVisible(true);
		
	}
	public void changePanel(){
		cardL.next(this.getContentPane());
	}
	
	public CardLayout getCardLayout(){
		return cardL;
	}

}
