package idao;
import model.Goods;
import java.util.*;
public interface IGoodsDAO {
    public List<Goods> queryByPage(String hql, int offset, int pageSize);
    
    public List<Goods> queryGoodsDetail(int goodsId);
    
    public int getAllRowCount(String hql);
    
    public boolean addGoods(Goods goods);
    
    public boolean deleteGoods(Goods goods);
    
    public boolean updateGoods(Goods goods);
    
    public Goods querySingleGoods(String goodsName);
    
    public Goods querySingleGoodsById(int goodsId);
    
    public boolean updateGoodsFile(Goods goods,String fileName,String fileType);

}
