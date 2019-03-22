package model;

public class User {
	
	private String account;   //�˺�
	private String username;  //�û��ǳ�
	private String password;  //����
	private int role;      //��ݣ�0Ϊ����Ա��1Ϊ��ͨ��Ա
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public User(String account, String username, String password, int role) {
		this.account = account;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public User() {
	}

}
