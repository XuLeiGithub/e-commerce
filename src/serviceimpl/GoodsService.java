package serviceimpl;

import java.io.File;
import java.util.List;

import util.FileUtil;
import model.Goods;
import model.PageBean;
import idao.IGoodsDAO;
import iservice.IGoodsService;

public class GoodsService implements IGoodsService{

	private IGoodsDAO goodsDAO;
	
	public IGoodsDAO getGoodsDAO() {
		return goodsDAO;
	}

	public void setGoodsDAO(IGoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	@Override
	public PageBean getPageBean(int pageSize, int page) {
		// TODO Auto-generated method stub
        PageBean pageBean = new PageBean();
        
        String hql = "from Goods";
        
        int allRows = goodsDAO.getAllRowCount(hql);
        
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        
        int currentPage = pageBean.getCurPage(page);
        if(currentPage-totalPage==1){
        	currentPage--;
        }
        
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        
        List<Goods> list = goodsDAO.queryByPage(hql, offset, pageSize);
        
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        
        return pageBean;
	}

	@Override
	public Goods getGoodsDetail(int goodsId) {
		// TODO Auto-generated method stub
		List<Goods> list = goodsDAO.queryGoodsDetail(goodsId);
		if(list.size()==1){
			Goods goods = list.get(0);
			return goods;
		}
		return null;
	}

	@Override
	public boolean addGoods(Goods goods,File picture,File content) {
		// TODO Auto-generated method stub
		if(goodsDAO.addGoods(goods)){
			FileUtil.writeFile(picture, goods.getPicture(), "picture");
			FileUtil.writeFile(content, goods.getContent(), "content");
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteGoods(Goods goods) {
		// TODO Auto-generated method stub
		if(goodsDAO.deleteGoods(goods)){
			FileUtil.deleteFile(goods.getPicture(), "picture");
			FileUtil.deleteFile(goods.getContent(), "content");
			return true;
		}
		return false;
	}

	@Override
	public boolean updateGoods(Goods goods, File picture, File content,
			String pictureName, String contentName) {
		// TODO Auto-generated method stub
		Goods goodsQuery = goodsDAO.querySingleGoods(goods.getName());
		goods.setPicture(pictureName);
		goods.setContent(contentName);
		if(goodsQuery!=null){
			if(picture!=null){
				FileUtil.deleteFile(goodsQuery.getPicture(), "picture");
				FileUtil.writeFile(picture, pictureName, "picture");
				goodsDAO.updateGoodsFile(goodsQuery, pictureName, "picture");
			}else{
				goods.setPicture(goodsQuery.getPicture());
			}
			if(content!=null){
				FileUtil.deleteFile(goodsQuery.getContent(), "content");
				FileUtil.writeFile(content, contentName, "content");
				goodsDAO.updateGoodsFile(goodsQuery, contentName, "content");
			}else{
				goods.setContent(goodsQuery.getContent());
			}
			goodsDAO.updateGoods(goods);
			return true;
		}
		return false;
	}

}
