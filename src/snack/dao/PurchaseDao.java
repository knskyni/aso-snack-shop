package snack.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import snack.bean.ItemBean;
import snack.bean.PurchaseBean;

public class PurchaseDao extends DaoBase{

    public boolean execute(PurchaseBean purchaseBean)throws SQLException {
        if(con == null) {
            return false;
        }
        boolean result = false;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            this.beginTransaction();

            //ordersに値を挿入する

            ps1 = con.prepareStatement("INSERT INTO `orders` (`user_id`, `created_at`, `total_price`) VALUES(?, ?, ?)");

            ps1.setInt(1, purchaseBean.getUserId());
            ps1.setTimestamp(2, new java.sql.Timestamp(new java.util.Date().getTime()));
            ps1.setInt(3, purchaseBean.getTotalPrice());

            ps1.executeUpdate();

            int orderId = getOrderId("orders");

            //buysに値を挿入する

            ps2 = con.prepareStatement("INSERT INTO `buys` (`order_id`, `item_id`, `count`, `price`) VALUE(?, ?, ?, ?)");

            for(ItemBean items : purchaseBean.getItems()) {

                ps2.setInt(1,orderId);
                ps2.setInt(2,items.getId());
                ps2.setInt(3,items.getCount());
                ps2.setInt(4,items.getPrice());

                ps2.addBatch();

            }

            ps2.executeBatch();

            this.commit();
            result = true;
        }catch (SQLException e) {
            //例外発生時はログを出力し、上位へそのままスロー
            this.rollback();
            throw e;
        }
        return result;
    }
}
