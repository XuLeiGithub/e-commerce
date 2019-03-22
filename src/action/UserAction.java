package action;

import iservice.IUserService;
import model.User;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport{
	private User user;
	private IUserService userService;
	private String twicePassword;
	private int registerStatus=0;
	
	
	public int getRegisterStatus() {
		return registerStatus;
	}


	public String getTwicePassword() {
		return twicePassword;
	}

	public void setTwicePassword(String twicePassword) {
		this.twicePassword = twicePassword;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public String login(){
		if(userService.login(user)){
			return SUCCESS; 
		}else{
			return ERROR;
		}
	}
	
	
	public String logout(){
		if(userService.logout()){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String register(){
		if(userService.register(user, twicePassword)){
			registerStatus=1;
			return SUCCESS;
		}
		return ERROR;
	}
	
	
}
