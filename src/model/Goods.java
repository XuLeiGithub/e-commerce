package model;

public class Goods {
	
	private int id;   //��Ʒid
	private String name;  //��Ʒ��
	private String picture;  //��Ʒ��Ƭ�ļ���
	private String content;  //��Ʒ����ļ���
	private float marketPrice;  //��Ʒ�г���
	private float memberPrice;  //��Ʒ��Ա��
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public float getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(float marketPrice) {
		this.marketPrice = marketPrice;
	}
	public float getMemberPrice() {
		return memberPrice;
	}
	public void setMemberPrice(float memberPrice) {
		this.memberPrice = memberPrice;
	}
	public Goods(int id, String name, String picture, String content,
			float marketPrice, float memberPrice) {
		this.id = id;
		this.name = name;
		this.picture = picture;
		this.content = content;
		this.marketPrice = marketPrice;
		this.memberPrice = memberPrice;
	}
	public Goods() {
	}
	

}
