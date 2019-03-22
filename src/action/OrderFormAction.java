package action;

import iservice.IOrderFormService;
import model.OrderForm;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class OrderFormAction extends ActionSupport{
	
	private OrderForm orderForm;
	private IOrderFormService orderFormService;
	public OrderForm getOrderForm() {
		return orderForm;
	}
	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}
	public IOrderFormService getOrderFormService() {
		return orderFormService;
	}
	public void setOrderFormService(IOrderFormService orderFormService) {
		this.orderFormService = orderFormService;
	}
	
	public String addOrderForm(){
		if(orderFormService.addOrderForm(orderForm)){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String listOrderForm(){
		if(orderFormService.listOrderForm()){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String deleteOrderForm(){
		if(orderFormService.deleteOrderForm(orderForm)){
			return SUCCESS;
		}
		return ERROR;
	}
	
}
