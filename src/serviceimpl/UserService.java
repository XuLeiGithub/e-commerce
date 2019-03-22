package serviceimpl;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import model.User;
import idao.IUserDAO;
import iservice.IUserService;

public class UserService implements IUserService{

	private IUserDAO userDAO;
	public IUserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		List<User> list;
		ActionContext context= ActionContext.getContext();
		Map<String,Object> session = context.getSession();
		User user1 = null;
		user1 = (User)session.get("user");
		if(user1==null){
			list = userDAO.login(user);
			if(list.size()==0){
				return false;
			}else if(list.size()==1){
				user1=(User) list.get(0);
				session.put("user", user1);
				return true;
			}
			
		}else{
			return true;
		}
		return false;
	}
	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		ActionContext context= ActionContext.getContext();
		Map<String,Object> session = context.getSession();
		session.remove("user");
		return true;
	}
	@Override
	public boolean register(User user,String twicePassword) {
		// TODO Auto-generated method stub
		user.setRole(1);
		if(user.getPassword().trim().equals(twicePassword.trim())){
			if(userDAO.register(user)){
				return true;
			}
		}
		return false;
	}



}
