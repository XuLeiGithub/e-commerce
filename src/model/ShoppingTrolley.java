package model;

public class ShoppingTrolley {
	
	private int id;  //���ﳵ���
	
	private int goodsId;   //��Ʒ���
	
	private int num;       //��Ʒ����
	
	private String account;   //�û��˺�

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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public ShoppingTrolley(int id, int goodsId, int num, String account) {
		this.id = id;
		this.goodsId = goodsId;
		this.num = num;
		this.account = account;
	}

	public ShoppingTrolley() {
	
	}
		

}
