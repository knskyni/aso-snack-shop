package snack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import snack.bean.ItemBean;

public class ItemDao extends DaoBase{

    //カート商品追加
    public List<ItemBean> getList(int Id){

        if( con == null ) {
            return null;
        }
        List<ItemBean> Cart = new ArrayList<ItemBean>();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM items WHERE id=?");
            stmt.setInt(1,Id);
            rs = stmt.executeQuery();

            while( rs.next() ) {
                ItemBean listCart = new ItemBean();

                listCart.setId(rs.getInt("id"));
                listCart.setName(rs.getString("name"));
                listCart.setDescription(rs.getString("description"));
                listCart.setImage(rs.getString("image_path"));
                listCart.setPrice(rs.getInt("price"));

                Cart.add(listCart);
            }

        }catch(SQLException e) {
            //エラー発生した場合にコンソールにログを出力する
            e.printStackTrace();
        }

                return Cart;
    }
}
