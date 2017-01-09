package marble.run;

import marble.view.*;

public class TestGUI {

	public static void main(String[] args) {
		MainFrame m = new MainFrame();
		m.getCardLayout().show(m.getContentPane(), "game");
		//new PageLogIn();
		//new PageJoin();
		//new PageGame(new MainFrame());
	}

}
