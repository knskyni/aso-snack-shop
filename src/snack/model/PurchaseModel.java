package snack.model;

import snack.bean.PurchaseBean;
import snack.dao.PurchaseDao;

public class PurchaseModel {
    public boolean execute(PurchaseBean purchaseBean) {
        PurchaseDao purchaseDao = new PurchaseDao();
        boolean result = false;

        try {
            purchaseDao.connect();
            result = purchaseDao.execute(purchaseBean);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            purchaseDao.close();
        }

        return result;
    }
}
