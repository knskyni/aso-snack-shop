package snack.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import snack.bean.ItemBean;

public class ItemDao extends DaoBase {
    public boolean create(ItemBean item) {
        if(con == null) {
            return false;
        }

        PreparedStatement stmt = null;
        int result = 0;

        try {
            stmt = con.prepareStatement("INSERT INTO `items` (`name`, `description`, `image_path`, `status`, `created_at`, `updated_at`, `price`) VALUES (?, ?, ?, 1, ?, ?, ?);");

            stmt.setString(1, item.getName());
            stmt.setString(2, item.getDescription());
            stmt.setString(3, item.getImagePath());
            stmt.setTimestamp(4, new java.sql.Timestamp(new java.util.Date().getTime()));
            stmt.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
            stmt.setInt(6, item.getPrice());

            result = stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return (result == 1) ? true : false;
    }
}
