package marble.model;

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

