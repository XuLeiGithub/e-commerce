package idao;

import java.util.List;

import model.OrderForm;

public interface IOrderFormDAO {
	
	public boolean addOrderForm(OrderForm orderForm);
	
	public List<OrderForm> queryOrderList(String account);
	
	public boolean deleteOrderForm(OrderForm orderForm);

}
