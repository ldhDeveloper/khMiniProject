package Member.creat;

import java.io.*;
import java.util.*;

public class Member implements Serializable {
	private String id;
	private String password;

	public Member() {
	}

	public Member(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public int createMember(String name, String pwd, String confirm) {//arguments는 텍스트필드에서 입력받음
		
		int result = 2;
		
		if (name.equals("") || pwd.equals("") || confirm.equals(""))
			result = 3;
		
		else if (pwd.equals(confirm)) {
			String[] compareName = null;
			try (BufferedWriter ow = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("memberInfo.dat", true)));
					BufferedReader or = new BufferedReader(new InputStreamReader(new FileInputStream("memberInfo.dxt")));) {
				for (;;) {
					compareName = or.readLine().split(" ");
					if (compareName[0].equals(name)) {
						result = 1;
						break;
					}
				}

			} catch (Exception e) {
				try (BufferedWriter ow = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("memberInfo.dat", true)));
						BufferedReader or = new BufferedReader(new InputStreamReader(new FileInputStream("memberInfo.dat")));) {
					ow.write(name + " " + pwd + "\n");
					ow.flush();
					result =0;
					return result;
				} catch (Exception ee) {
				}
			}
		}
		return result;
	}

	public int Login(String name, String pwd) {//arguments는 텍스트필드에서 입력받음
		String compare = name + " " + pwd;
		int result = 1;
		try (BufferedReader or = new BufferedReader(new FileReader("memberInfo.dat"))) {
			for (;;) {
				if (compare.equals(or.readLine())) {
					result = 0;
					break;
				}
			}
		} catch (Exception e) {
			return result;
			}
		return result;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return this.id + " " + this.password;
	}
}
