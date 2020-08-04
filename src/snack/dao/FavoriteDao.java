package snack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import snack.bean.ItemBean;

public class FavoriteDao extends DaoBase {
    public boolean exist(int userId, int itemId) {
        if(con == null) {
            return false;
        }

        PreparedStatement stmt = null;
        boolean result = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM `favorites` WHERE `user_id` = ? AND `item_id` = ?;");
            stmt.setInt(1, userId);
            stmt.setInt(2, itemId);

            ResultSet rs = stmt.executeQuery();
            result = rs.next();

        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }

        return result;
    }

    public boolean create(int userId, int itemId) {
        if(con == null) {
            return false;
        }

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO `favorites` (`user_id`, `item_id`, `created_id`) VALUES (?, ?, ?);");

            stmt.setInt(1, userId);
            stmt.setInt(2, itemId);
            stmt.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));

            stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean delete(int userId, int itemId) {
        if(con == null) {
            return false;
        }

        PreparedStatement stmt = null;
        int result = 0;

        try {
            stmt = con.prepareStatement("DELETE FROM `favorites` WHERE `user_id` = ? AND `item_id` = ?;");

            stmt.setInt(1, userId);
            stmt.setInt(2, itemId);

            result = stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }

        return (result == 1) ? true : false;
    }

    public List<ItemBean> userFavorite(int userId) {
        if(con == null) {
            return new ArrayList<ItemBean>();
        }

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ItemBean> items = new ArrayList<ItemBean>();

        try {
            stmt = con.prepareStatement("SELECT `items`.`id`, `items`.`name`, `items`.`description`, `items`.`image_path`, `items`.`created_at`, `items`.`updated_at`, `items`.`price` FROM `favorites` INNER JOIN `items` ON `favorites`.`item_id` = `items`.`id` WHERE `items`.`status` = 1 AND `favorites`.`user_id` = ?;");

            stmt.setInt(1, userId);

            rs = stmt.executeQuery();
            while(rs.next()) {
                ItemBean item = new ItemBean();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setImagePath(rs.getString("image_path"));
                item.setCreatedAt(rs.getTimestamp("created_at"));
                item.setUpdatedAt(rs.getTimestamp("updated_at"));
                item.setPrice(rs.getInt("price"));

                items.add(item);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            return new ArrayList<ItemBean>();
        }

        return items;
    }
}
