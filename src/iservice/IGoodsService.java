package iservice;
import java.io.File;

import model.Goods;
import model.PageBean;
public interface IGoodsService {

	public PageBean getPageBean(int pageSize, int page);
	public Goods getGoodsDetail(int goodsId);
	public boolean addGoods(Goods goods,File picture,File content);
	public boolean deleteGoods(Goods goods);
	public boolean updateGoods(Goods goods,File picture,File content,String pictureName,String contentName);
}
