package model;

public class User {
	
	private String account;   //账号
	private String username;  //用户昵称
	private String password;  //密码
	private int role;      //身份，0为管理员，1为普通会员
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
