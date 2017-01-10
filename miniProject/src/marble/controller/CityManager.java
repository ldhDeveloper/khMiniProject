package marble.controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import marble.model.Charcter;
import marble.model.Cities;

public class CityManager extends JFrame{
		
	public int OwnCity(Cities city, Charcter c, JLabel user1Money){
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
			city.setFee(city.getGrandCost() * 2);
		}
		/*
		user1Info.setText("<html>아이디: " + c.getName()
		+ "<br>자산: " + c.getMoney() + "</html>");
		*/
		user1Money.setText(c.getMoney()+"");
		return result;

	}
	
	public String UpgradeCity(Cities city, Charcter c, JLabel user1Money) {
		
		String result = "";
		int cityStatus = city.getStatus();
		Object[] option1 = { "1", "2", "3" };
		Object[] option2 = { "1", "2" };
		Object[] option3 = { "예", "아니오" };
		
		if (cityStatus == 1) { // 건물이 0채인 경우
			
			result = (String) JOptionPane.showInputDialog(this,
				"건물을 지을까요?", "빌딩 건설", JOptionPane.PLAIN_MESSAGE, null,
				option1, "1");

			if (result.equals("1")) { // 다이얼로그에서 1을 선택 (한채 짓기)
				c.setMoney(c.getMoney() - 10); // 첫번째 건물 비용(10)
				city.setStatus(2); // 건물 1채인 상태로 변경
				city.setFee((city.getGrandCost() + 10) * 2);
			}
			
			else if (result.equals("2")) {
				c.setMoney(c.getMoney() - 10 - 15);
				city.setStatus(3);
				city.setFee((city.getGrandCost() + 10 + 15) * 2);
			}
			
			else {
				c.setMoney(c.getMoney() - 10 - 15 - 20);
				city.setStatus(4);
				city.setFee((city.getGrandCost() + 10 + 15 + 20) * 2);
			}
		}
		
		else if (cityStatus == 2) {
			
			result = (String) JOptionPane.showInputDialog(this,
					"건물을 지을까요", "빌딩 건설", JOptionPane.PLAIN_MESSAGE, null,
					option2, "1");
			
			if (result == null)
				System.out.println("널");
			
			else if (result.equals("1")) {
				c.setMoney(c.getMoney() - 15);
				city.setStatus(3);
				city.setFee((city.getGrandCost() + 10 + 15) * 2);
			}
			
			else {
				c.setMoney(c.getMoney() - 15 - 20);
				city.setStatus(4);
				city.setFee((city.getGrandCost() + 10 + 15 + 20) * 2);
			}
		}
		
		else if (cityStatus == 3) {
			result = (String) JOptionPane.showInputDialog(this,
					"건물을 지을까요", "빌딩 건설", JOptionPane.PLAIN_MESSAGE, null,
					option3, "예");
			if (result.equals("예")) {
				c.setMoney(c.getMoney() - 20); // 세번째 건물 비용(20)
				city.setStatus(4);
				city.setFee((city.getGrandCost() + 10 + 15 + 20) * 2);
				result = "1";
			}
			else result = "";
		}
		
		else if (cityStatus == 4) {
			result = buildLand(city, c);
		}

		/*
		user1Info.setText("<html>아이디: " + c.getName()
		+ "<br>자산: " + c.getMoney() + "</html>");
		*/
		user1Money.setText(c.getMoney()+"");
		return result;
	}

	public String buildLand(Cities city, Charcter c) {
		
		Object[] option = { "건설", "취소" };

		String result = JOptionPane.showOptionDialog(this,
				city.getName() + " 입니다. \n랜드마크를 짓겠습니까?", "랜드마크",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, option, option[1]) + "";

		if (result.equals("0")) {
			city.setOwner(c.getcNo());
			c.setMoney(c.getMoney() - 20);
			city.setStatus(5);
			city.setFee((city.getGrandCost() + 10 + 15 + 20 + 20) * 2);
		}
		
		else {
			result = "";
		}
		
		return result;
	}

	public int MAndACity(Cities city, Charcter c) {
		city.setOwner(c.getcNo());
		if (city.getStatus() == 1)
			return city.getGrandCost() + 10;
		else if (city.getStatus() == 2)
			return city.getGrandCost() + 10 + 15;
		else if (city.getStatus() == 3)
			return city.getGrandCost() + 10 + 15 + 20;
		else if (city.getStatus() == 4)
			return city.getGrandCost() + 10 + 15 + 20 + 20;
		else
			return 0;
	}

	public int FeeCity(Cities city) {
			return city.getFee();
	}
	
}
