package serviceimpl;

import idao.IGoodsDAO;
import idao.IOrderFormDAO;
import idao.IShoppingTrolleyDAO;
import iservice.IOrderFormService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import util.DateUtil;
import model.Goods;
import model.OrderForm;
import model.User;

public class OrderFormService implements IOrderFormService{

	private IOrderFormDAO orderFormDAO;
	private IShoppingTrolleyDAO shoppingTrolleyDAO;
	private IGoodsDAO goodsDAO;
	
	
	public IShoppingTrolleyDAO getShoppingTrolleyDAO() {
		return shoppingTrolleyDAO;
	}


	public void setShoppingTrolleyDAO(IShoppingTrolleyDAO shoppingTrolleyDAO) {
		this.shoppingTrolleyDAO = shoppingTrolleyDAO;
	}


	public IGoodsDAO getGoodsDAO() {
		return goodsDAO;
	}


	public void setGoodsDAO(IGoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}


	public IOrderFormDAO getOrderFormDAO() {
		return orderFormDAO;
	}


	public void setOrderFormDAO(IOrderFormDAO orderFormDAO) {
		this.orderFormDAO = orderFormDAO;
	}


	@Override
	public boolean addOrderForm(OrderForm orderForm) {
		// TODO Auto-generated method stub
		orderForm.setOrderTime(Timestamp.valueOf(DateUtil.getNowDate()));
		if(orderFormDAO.addOrderForm(orderForm)){
			int goodsId = orderForm.getGoodsId();
			String account = orderForm.getAccount();
			if(shoppingTrolleyDAO.deleteShoppingNotById(goodsId, account)){
				return true;
			}
		}
		return false;
	}


	@Override
	public boolean listOrderForm() {
		// TODO Auto-generated method stub
		ActionContext context= ActionContext.getContext();
		Map<String,Object> session = context.getSession();
		User user = (User)session.get("user");
		List<OrderForm> orderList = orderFormDAO.queryOrderList(user.getAccount());
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Float> singleMoneyList = new ArrayList<Float>();
		for(int i=0;i<orderList.size();i++){
			Goods goods = goodsDAO.querySingleGoodsById(orderList.get(i).getGoodsId());
			if(goods!=null){
				goodsList.add(goods);
				int num = orderList.get(i).getNum();
				float totalMoney = orderList.get(i).getTotalMoney();
				float singleMoney = totalMoney/(float)num;
				singleMoneyList.add(singleMoney);
			}
			//System.out.println("time: "+orderList.get(i).getOrderTime());
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("orderList", orderList);
		request.setAttribute("goodsList", goodsList);
		request.setAttribute("singleMoneyList", singleMoneyList);
		return true;
	}


	@Override
	public boolean deleteOrderForm(OrderForm orderForm) {
		// TODO Auto-generated method stub
		if(orderFormDAO.deleteOrderForm(orderForm)){
			return true;
		}	
		return false;
	}

}
