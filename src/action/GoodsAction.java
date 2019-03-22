package action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import util.FileUtil;
import model.Goods;
import model.PageBean;
import iservice.IGoodsService;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GoodsAction extends ActionSupport{
	
	private IGoodsService goodsService;
	private int page;
	private Goods goods;
	private String goodsContent;
	private File picture;
	private String pictureFileName;
	private String pictureContentType;
	private File content;
	private String contentFileName;
	private String contentContentType;
	private int addStatus=0;
	private int updateStatus=0;
	private String addMessage;
	private int addShoppingStatus=0;
	

	public int getAddShoppingStatus() {
		return addShoppingStatus;
	}

	public void setAddShoppingStatus(int addShoppingStatus) {
		this.addShoppingStatus = addShoppingStatus;
	}

	public int getUpdateStatus() {
		return updateStatus;
	}

	public String getAddMessage() {
		return addMessage;
	}


	public int getAddStatus() {
		return addStatus;
	}

	public File getContent() {
		return content;
	}

	public void setContent(File content) {
		this.content = content;
	}

	public String getContentFileName() {
		return contentFileName;
	}

	public void setContentFileName(String contentFileName) {
		this.contentFileName = contentFileName;
	}

	public String getContentContentType() {
		return contentContentType;
	}

	public void setContentContentType(String contentContentType) {
		this.contentContentType = contentContentType;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public String getPictureFileName() {
		return pictureFileName;
	}

	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	public String getPictureContentType() {
		return pictureContentType;
	}

	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
	}

	public String getGoodsContent() {
		return goodsContent;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public IGoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	public String pagination(){
		 //表示每页显示5条记录，page表示当前网页
        PageBean pageBean = goodsService.getPageBean(4, page);
        
        HttpServletRequest request = ServletActionContext.getRequest();
        
        request.setAttribute("pageBean", pageBean);
        
        return SUCCESS;
	}
	
	public String watchGoodsDetail(){
		Goods a = goodsService.getGoodsDetail(goods.getId());
		if(a!=null){
			goods = a;
			goodsContent = FileUtil.readGoodsContentFile(goods.getContent());
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String addGoods(){
		goods.setPicture(pictureFileName);
		goods.setContent(contentFileName);
		if(goodsService.addGoods(goods, picture, content)){
			addStatus=1;
			addMessage="成功添加商品："+goods.getName()+","+goods.getMemberPrice()+"元！！！";
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String deleteGoods(){
		if(goodsService.deleteGoods(goods)){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String inUpdate(){
		return SUCCESS;
	}
	
	public String updateGoods(){
		if(goodsService.updateGoods(goods, picture, content, pictureFileName, contentFileName)){
			updateStatus=1;
			return SUCCESS;
		}
		return ERROR;
	}
	

}
