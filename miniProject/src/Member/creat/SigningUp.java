package Member.creat;
import java.io.*;
import java.util.*;

public class SigningUp implements Serializable {
	private String id;
	private String password;
	ArrayList<SigningUp> list = new ArrayList<SigningUp>();

	public SigningUp() {
	}

	public SigningUp(String id, String password) {// 추후 아이디 입력창에서 각각 입력받음
		this.id = id;
		this.password = password;
	}

	public void createMember() {

		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력) :"); // 확인용(로그인화면대용)
		this.setId(sc.next());
		String name = this.getId();
		System.out.print("비번 입력 : "); // 확인용 (로그인화면대용)
		this.setPassword(sc.next());
		String pwd = this.getPassword();

		try (ObjectOutputStream ow
				= new ObjectOutputStream(new FileOutputStream("memberInfo.dat"));
				ObjectInputStream or = new ObjectInputStream(new FileInputStream("memberInfo.dat"));) {
			ow.writeObject(new SigningUp(name, pwd));
			ow.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Login() {
		Scanner sc = new Scanner(System.in);
		try (ObjectInputStream or = new ObjectInputStream(new FileInputStream("memberInfo.dat"))) {
			System.out.println(or.readObject());// 제대로 읽혔는지 확인
			System.out.print("아이디  입력 : ");
			String name = sc.next();
			System.out.print("암호 입력: ");
			String pwd = sc.next();
			SigningUp cname;

			for (int i = 0; i < 100; i++) {
				System.out.println("sss");
				cname = (SigningUp)(or.readObject());
				if (cname.getId().equals(name) && cname.getPassword().equals(pwd)) {
					System.out.println(name);
					break;
				}
			}
			// 불리는지 확인
		} catch (EOFException ee) {
			System.out.println("아");
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public static void main(String args[]) {
		new SigningUp().createMember();
		new SigningUp().Login();
	}

	@Override
	public String toString() {
		return this.id + " " + this.password;
	}
}
