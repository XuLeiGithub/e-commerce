package iservice;

import model.OrderForm;

public interface IOrderFormService {
	
	public boolean addOrderForm(OrderForm orderForm);

	public boolean listOrderForm();
	
	public boolean deleteOrderForm(OrderForm orderForm);
}
