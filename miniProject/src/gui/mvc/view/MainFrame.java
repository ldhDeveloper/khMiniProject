package gui.mvc.view;
import javax.swing.*;import java.awt.*;
public class MainFrame extends JFrame{
	private CardLayout cardL= new CardLayout();
private	JPanel pan1 = new pageLogIn(this);
private	JPanel pan2 = new pageJoin(this);
private	JPanel pan3 = new pageGame(this);
	public MainFrame(){
		this.setTitle("Blue Marble");
		this.setSize(new Dimension(1200, 800));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(cardL);
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
	public void setPan1(JPanel pan){
		this.pan1=pan;
	}
	public void setPan2(JPanel pan){
		this.pan2=pan;
	}
	public void setPan3(JPanel pan){
		this.pan3=pan;
	}
	public JPanel getPan1(){
		return this.pan1;
	}

	public JPanel getPan2(){
		return this.pan2;
	}

	public JPanel getPan3(){
		return this.pan3;
	}
}
