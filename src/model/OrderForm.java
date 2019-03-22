package model;

import java.sql.Timestamp;

public class OrderForm {
	
	private int id;   //订单编号
	private int goodsId;   //商品编号
	private String account;   //用户账号	
	private float totalMoney;   //订单总金额
	private Timestamp orderTime;   //订单提交时间
	private int num;          //商品数量
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public float getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	public OrderForm(int id, int goodsId, String account, float totalMoney,
			Timestamp orderTime) {
		this.id = id;
		this.goodsId = goodsId;
		this.account = account;
		this.totalMoney = totalMoney;
		this.orderTime = orderTime;
	}
	public OrderForm() {
	}
	
	

}
