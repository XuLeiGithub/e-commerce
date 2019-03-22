package idao;

import java.util.List;

import model.ShoppingTrolley;

public interface IShoppingTrolleyDAO {
	
	public boolean addShoppingTrolley(ShoppingTrolley shoppingTrolley);
	
	public ShoppingTrolley querySingleShopping(int goodsId,String account);
	
	public boolean updateShoppingTrolley(ShoppingTrolley shoppingTrolley);
	
	public List<ShoppingTrolley> queryShoppingList(String account);
	
	public boolean deleteShopping(ShoppingTrolley shoppingTrolley);
	
	public boolean deleteShoppingNotById(int goodsId,String account);
	
}
