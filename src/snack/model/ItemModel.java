package snack.model;

import java.util.ArrayList;
import java.util.List;

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

    public List<ItemBean> serch(String search) {
        List<ItemBean> itemBean = new ArrayList<ItemBean>();
        ItemDao itemDao = new ItemDao();

        try {
            itemDao.connect();
            itemBean = itemDao.serch(search);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            itemDao.close();
        }

        return itemBean;
    }

    public ItemBean show(int id) {
        ItemBean itemBean = null;
        ItemDao itemDao = new ItemDao();

        try {
            itemDao.connect();
            itemBean = itemDao.show(id);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            itemDao.close();
        }

        return itemBean;
    }

    public boolean update(ItemBean item) {
        ItemDao itemDao = new ItemDao();
        boolean result = false;

        try {
            itemDao.connect();
            result = itemDao.update(item);
        } catch(Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            itemDao.close();
        }

        return result;
    }

    public boolean delete(int id) {
        ItemDao itemDao = new ItemDao();
        boolean result = false;

        try {
            itemDao.connect();
            result = itemDao.delete(id);
        } catch(Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            itemDao.close();
        }

        return result;
    }
}
