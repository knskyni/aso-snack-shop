package snack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
