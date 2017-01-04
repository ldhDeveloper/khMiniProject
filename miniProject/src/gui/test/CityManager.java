package gui.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CityManager extends JFrame{
		
	public int OwnCity(Cities city, Charcter c){
		Object[] option = {"구입", "취소"};
		
		int result = JOptionPane.showOptionDialog(this,
				city.getName() + " 입니다. \n땅을 구입하시겠습니까?",
				"토지구입", 
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, 
				null, option, option[1]);
		
		if(result == 0){
			city.setOwner(c.getcNo());
			c.setMoney(c.getMoney() - city.getGrandCost());
			city.setStatus(1);
		}
		
		return result;
		
	}
}
