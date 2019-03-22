package iservice;

import model.ShoppingTrolley;

public interface IShoppingTrolleyService {
	
	public boolean addShopping(ShoppingTrolley shoppingTrolley);
	
	public boolean listShoppingTrolley();
	
	public boolean deleteShopping(ShoppingTrolley shoppingTrolley);
}
