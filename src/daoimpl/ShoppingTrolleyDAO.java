package daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.SessionUtil;
import model.ShoppingTrolley;
import idao.IShoppingTrolleyDAO;

public class ShoppingTrolleyDAO implements IShoppingTrolleyDAO{

	@Override
	public boolean addShoppingTrolley(ShoppingTrolley shoppingTrolley) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(shoppingTrolley);
		transaction.commit();
		session.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ShoppingTrolley querySingleShopping(int goodsId,String account) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from ShoppingTrolley where goodsId=? and account=?");
		query.setParameter(0, goodsId);
		query.setParameter(1, account);
		List<ShoppingTrolley> list = query.list();
		transaction.commit();
		session.close();
		if(list.size()==1){
			return (ShoppingTrolley)list.get(0);
		}
		return null;
	}

	@Override
	public boolean updateShoppingTrolley(ShoppingTrolley shoppingTrolley) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(shoppingTrolley);
		transaction.commit();
		session.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShoppingTrolley> queryShoppingList(String account) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from ShoppingTrolley where account=?");
		query.setParameter(0, account);
		List<ShoppingTrolley> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}

	@Override
	public boolean deleteShopping(ShoppingTrolley shoppingTrolley) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(shoppingTrolley);
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteShoppingNotById(int goodsId, String account) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("delete from ShoppingTrolley where goodsId=? and"
				+ " account=?");
		query.setParameter(0, goodsId);
		query.setParameter(1, account);
		query.executeUpdate();
		transaction.commit();
		session.close();
		return true;
	}

}
