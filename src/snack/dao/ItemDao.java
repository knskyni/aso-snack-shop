package snack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import snack.bean.ItemBean;

public class ItemDao extends DaoBase {
    public boolean create(ItemBean item) {
        if(con == null) return false;

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

    public ItemBean show(int id) {
        if(con == null) return null;

        PreparedStatement stmt = null;
        ItemBean item = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM `items` WHERE `id` = ? AND `status` = 1;");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                item = new ItemBean();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setImagePath(rs.getString("image_path"));
                item.setCreatedAt(rs.getTimestamp("created_at"));
                item.setUpdatedAt(rs.getTimestamp("updated_at"));
                item.setPrice(rs.getInt("price"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    public boolean update(ItemBean item) {
        if(con == null) return false;

        PreparedStatement stmt = null;
        int result = 0;

        try {
            stmt = con.prepareStatement("UPDATE `items` SET `name` = ?, `description` = ?, `updated_at` = ?, `price` = ? WHERE `id` = ?;");

            stmt.setString(1, item.getName());
            stmt.setString(2, item.getDescription());
            stmt.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
            stmt.setInt(4, item.getPrice());
            stmt.setInt(5, item.getId());

            result = stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }

        return (result == 1) ? true : false;
    }

    public boolean delete(int id) {
        if(con == null) return false;

        PreparedStatement stmt = null;
        int result = 0;

        try {
            stmt = con.prepareStatement("UPDATE `items` SET `status` = 0 WHERE `id` = ?;");

            stmt.setInt(1, id);

            result = stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }

        return (result == 1) ? true : false;
    }
}
