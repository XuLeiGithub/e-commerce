package iservice;

import model.User;

public interface IUserService {
	public boolean login(User user);
	public boolean logout();
	public boolean register(User user,String twicePassword);
}
