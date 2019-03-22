package idao;

import java.util.List;

import model.User;

public interface IUserDAO {
	
	@SuppressWarnings("rawtypes")
	public List login(User user);
	
	public boolean register(User user);

}
