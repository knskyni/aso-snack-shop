package snack.model;

import java.util.ArrayList;
import java.util.List;

import snack.bean.ItemBean;
import snack.dao.ItemDao;

public class ItemModel {

    //内容取得
    public List<ItemBean> getList(int Id){

        List<ItemBean> Cart = new ArrayList<ItemBean>();

        ItemDao itemDao = new ItemDao();

        try{
            //接続
            itemDao.connect();
            Cart = itemDao.getList(Id);

        } catch (Exception e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }finally{
            itemDao.close();
        }

        return Cart;
    }
}
