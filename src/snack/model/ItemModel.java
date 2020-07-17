package snack.model;

import snack.bean.ItemBean;
import snack.dao.ItemDao;

public class ItemModel {
    public boolean create(ItemBean item) {
        ItemDao itemDao = new ItemDao();
        boolean result = false;

        try {
            itemDao.connect();
            result = itemDao.create(item);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            itemDao.close();
        }

        return result;
    }
}
