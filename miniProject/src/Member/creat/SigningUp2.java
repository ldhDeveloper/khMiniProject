package Member.creat;
import java.io.*;
import java.util.*;

public class SigningUp2 implements Serializable {
	private String id;
	private String password;
	ArrayList<SigningUp2> list = new ArrayList<SigningUp2>();

	public SigningUp2() {
	}

	public SigningUp2(String id, String password) {// 추후 아이디 입력창에서 각각 입력받음
		this.id = id;
		this.password = password;
	}

	public void createMember(String name, String pwd) {
		//에러 코드
		SigningUp2 sign =null;
		try(ObjectOutputStream oos
			= new ObjectOutputStream(new FileOutputStream("memberInfo.dat", true));
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("memberInfo.dat"))){
			for(;;){
				sign = (SigningUp2)ois.readObject();
				if(sign.getId().equals(name))
					System.out.println("이미 해당아이디가 존재합니다.");
				 return;
			}
		}catch(Exception e){
			try (ObjectOutputStream ow
					= new ObjectOutputStream(new FileOutputStream("memberInfo.dat", true));
					ObjectInputStream or = new ObjectInputStream(new FileInputStream("memberInfo.dat"));) {
				ow.writeObject(new SigningUp2(name, pwd));
				ow.flush();
			} catch (Exception ee) {
				e.printStackTrace();
			}
			
			}
		
	}

	public void Login(String name, String pwd) {
		
		try (ObjectInputStream or = new ObjectInputStream(new FileInputStream("memberInfo.dat"))) {
			
			SigningUp2 cname;
			
			for (int i = 0; i < 100; i++) {
				System.out.println("for문 동작 확인");
				cname = (SigningUp2)(or.readObject());
				if (cname.getId().equals(name) && cname.getPassword().equals(pwd)) {
					System.out.println(name);//회원정보 맞을때 출력
					break;
				}
			}
			// 불리는지 확인
		} catch (EOFException ee) {
			System.out.println("존재하지 않는 회원 정보 입니다.");
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
		new SigningUp2().createMember("이름", "비번");
		new SigningUp2().Login("이름", "비번");
	}

	@Override
	public String toString() {
		return this.id + " " + this.password;
	}
}
