package daoimpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



import util.SessionUtil;
import model.User;
import idao.IUserDAO;
public class UserDAO implements IUserDAO{

	@SuppressWarnings("unchecked")
	public List<User> login(User user) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from User where account=? and password=?");
		query.setParameter(0, user.getAccount());
		query.setParameter(1, user.getPassword());
		List<User> list=query.list();
		transaction.commit();
		session.close();
		return list;
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		return true;
	}


}
