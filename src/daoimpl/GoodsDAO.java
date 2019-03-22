package daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.SessionUtil;
import model.Goods;
import idao.IGoodsDAO;

public class GoodsDAO implements IGoodsDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> queryByPage(String hql, int offset, int pageSize) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Goods> list = null;
        tx = session.beginTransaction();
        Query query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
        list = query.list();   
        tx.commit();          
        session.close();                
        return list;
	}

	@Override
	public int getAllRowCount(String hql) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
        Transaction tx = null;
        int allRows = 0;
        tx = session.beginTransaction();            
        Query query = session.createQuery(hql);           
        allRows = query.list().size();           
        tx.commit();
        session.close();        
        return allRows;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> queryGoodsDetail(int goodsId) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql="from Goods where id=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, goodsId);
		List<Goods> goodsList = query.list();
		transaction.commit();
		session.close();
		return goodsList;
	}

	@Override
	public boolean addGoods(Goods goods) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(goods);
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteGoods(Goods goods) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(goods);
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public boolean updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(goods);
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public Goods querySingleGoods(String goodsName) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "from Goods where name = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, goodsName);
		@SuppressWarnings("unchecked")
		List<Goods> list = query.list();
		Goods goods=null;
		if(list.size()==1){
			goods = (Goods) list.get(0);
		}
		transaction.commit();
		session.close();
		return goods;
	}

	@Override
	public boolean updateGoodsFile(Goods goods, String fileName, String fileType) {  //更新商品简介或图片
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "update Goods set "+fileType+"=? where name= ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, fileName);
		query.setParameter(1, goods.getName());
		query.executeUpdate();
		transaction.commit();
		session.close();
		return false;
	}

	@Override
	public Goods querySingleGoodsById(int goodsId) {
		// TODO Auto-generated method stub
		Session session = SessionUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "from Goods where id = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, goodsId);
		@SuppressWarnings("unchecked")
		List<Goods> list = query.list();
		Goods goods=null;
		if(list.size()==1){
			goods = (Goods) list.get(0);
		}
		transaction.commit();
		session.close();
		return goods;
	}

}
