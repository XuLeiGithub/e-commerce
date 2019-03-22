package daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.SessionUtil;
import model.OrderForm;
import idao.IOrderFormDAO;

public class OrderFormDAO implements IOrderFormDAO{

	
	@Override
	public boolean addOrderForm(OrderForm orderForm) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(orderForm);
		transaction.commit();
		session.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderForm> queryOrderList(String account) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from OrderForm where account=?");
		query.setParameter(0, account);
		List<OrderForm> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}

	@Override
	public boolean deleteOrderForm(OrderForm orderForm) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(orderForm);
		transaction.commit();
		session.close();
		return true;
	}

}
