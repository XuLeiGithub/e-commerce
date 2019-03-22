package action;

import iservice.IShoppingTrolleyService;
import model.Goods;
import model.ShoppingTrolley;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ShoppingTrolleyAction extends ActionSupport{
	private ShoppingTrolley shoppingTrolley;
	private Goods goods;
	private int page;
	private int buyStatus=0;
	
	
	public int getBuyStatus() {
		return buyStatus;
	}

	public void setBuyStatus(int buyStatus) {
		this.buyStatus = buyStatus;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	private IShoppingTrolleyService shoppingTrolleyService;

	public ShoppingTrolley getShoppingTrolley() {
		return shoppingTrolley;
	}

	public void setShoppingTrolley(ShoppingTrolley shoppingTrolley) {
		this.shoppingTrolley = shoppingTrolley;
	}

	public IShoppingTrolleyService getShoppingTrolleyService() {
		return shoppingTrolleyService;
	}

	public void setShoppingTrolleyService(
			IShoppingTrolleyService shoppingTrolleyService) {
		this.shoppingTrolleyService = shoppingTrolleyService;
	}
	
	public String addShoppingTrolley(){
		if(shoppingTrolleyService.addShopping(shoppingTrolley)){
			return SUCCESS;
		}
		return ERROR;
	}
	
	
	public String listShopping(){
		if(shoppingTrolleyService.listShoppingTrolley()){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String deleteShopping(){
		
		if(shoppingTrolleyService.deleteShopping(shoppingTrolley)){
			return SUCCESS;
		}
		
		return ERROR;
	}
	
	
}
