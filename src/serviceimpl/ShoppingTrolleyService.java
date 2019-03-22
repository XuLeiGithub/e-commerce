package serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import model.Goods;
import model.ShoppingTrolley;
import model.User;
import idao.IGoodsDAO;
import idao.IShoppingTrolleyDAO;
import iservice.IShoppingTrolleyService;

public class ShoppingTrolleyService implements IShoppingTrolleyService{
	
	private IShoppingTrolleyDAO shoppingTrolleyDAO;
	
	private IGoodsDAO goodsDAO;
	
	

	public IGoodsDAO getGoodsDAO() {
		return goodsDAO;
	}

	public void setGoodsDAO(IGoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	public IShoppingTrolleyDAO getShoppingTrolleyDAO() {
		return shoppingTrolleyDAO;
	}

	public void setShoppingTrolleyDAO(IShoppingTrolleyDAO shoppingTrolleyDAO) {
		this.shoppingTrolleyDAO = shoppingTrolleyDAO;
	}

	@Override
	public boolean addShopping(ShoppingTrolley shoppingTrolley) {
		// TODO Auto-generated method stub
		ShoppingTrolley queryShopping = shoppingTrolleyDAO.querySingleShopping(shoppingTrolley.getGoodsId(),
				shoppingTrolley.getAccount());
		if(queryShopping!=null){
			int num = queryShopping.getNum();
			num+=shoppingTrolley.getNum();
			queryShopping.setNum(num);
			if(shoppingTrolleyDAO.updateShoppingTrolley(queryShopping)){
				return true;
			}
		}else{
			if(shoppingTrolleyDAO.addShoppingTrolley(shoppingTrolley)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean listShoppingTrolley() {
		// TODO Auto-generated method stub
		ActionContext context= ActionContext.getContext();
		Map<String,Object> session = context.getSession();
		User user = (User)session.get("user");
		List<ShoppingTrolley> shoppingList= shoppingTrolleyDAO.queryShoppingList(user.getAccount());
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Float> shoppingMoneyList = new ArrayList<Float>();
		for(int i=0;i<shoppingList.size();i++){
			Goods goods = goodsDAO.querySingleGoodsById(shoppingList.get(i).getGoodsId());
			if(goods!=null){
				goodsList.add(goods);
				shoppingMoneyList.add(goods.getMemberPrice()*shoppingList.get(i).getNum());
			}
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("goodsList", goodsList);
		request.setAttribute("shoppingList", shoppingList);
		request.setAttribute("moneyList", shoppingMoneyList);
		return true;
	}

	@Override
	public boolean deleteShopping(ShoppingTrolley shoppingTrolley) {
		// TODO Auto-generated method stub
		
		if(shoppingTrolleyDAO.deleteShopping(shoppingTrolley)){
			return true;
		}
		
		return false;
	}
	
	

}
