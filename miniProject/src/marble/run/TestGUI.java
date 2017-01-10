package marble.run;

import java.io.IOException;
import marble.controller.ClientBackground;
import marble.view.*;

public class TestGUI {

	public static void main(String[] args) {
		try {
			ClientBackground client = new ClientBackground();
			MainFrame m = new MainFrame();
			client.setM(m);
			PageLogIn pl = (PageLogIn)m.getPan1();
			PageJoin pj = (PageJoin)m.getPan2();
			pl.setClient(client);
			pl.setClient(client);
			client.connet();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*
		//new PageLogIn();
		//new PageJoin();
		//new PageGame();
		MainFrame m = new MainFrame();
		m.getCardLayout().show(m.getContentPane(), "game");
		m.represent();*/
	}

}
