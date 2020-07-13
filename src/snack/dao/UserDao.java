package snack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import snack.bean.UserBean;

public class UserDao extends DaoBase{

    public UserBean auth(String email,String password) {
        if(con == null) {
            return null;
        }

        PreparedStatement stmt = null;
        ResultSet rs = null;
        UserBean userbean = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");

            stmt.setString(1, email);
            stmt.setString(2 ,password);
            rs = stmt.executeQuery();

            while(rs.next()) {
                userbean = new UserBean();

                userbean.setId(rs.getInt("id"));
                userbean.setType(rs.getString("type"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return userbean;

    }
    public UserBean show(int id) {
        if(con == null ) {
            return null;
        }

        PreparedStatement stmt = null;
        ResultSet rs = null;
        UserBean userInfo = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM users WHERE id = ?");

            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while(rs.next()) {
                userInfo = new UserBean();

                userInfo.setId(rs.getInt("Id"));
                userInfo.setLastName(rs.getString("last_name"));
                userInfo.setFirstName(rs.getString("first_name"));
                userInfo.setLastNameFurigana(rs.getString("last_name_furigana"));
                userInfo.setFirstNameFurigana(rs.getString("first_name_furigana"));
                userInfo.setEmail(rs.getString("email"));
                userInfo.setType(rs.getString("postal_code"));
                userInfo.setPostalCode(rs.getString("address"));
                userInfo.setPhoneNumber(rs.getString("phone_number"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return userInfo;

    }
    public UserBean update(UserBean userUpdateInfo) {
        if(con == null) {
            return null;
        }

        PreparedStatement stmt = null;

            try {
                stmt = con.prepareStatement("UPDATE `users` SET `last_name` = ? , `first_name` = ? , `last_name_furigana` = ? , `first_name_furigana` = ? , `email` = ? , `postal_code` = ? , `address` = ? , `phone_number` = ? ,`updated_at` = ? WHERE `id` = ?");

                stmt.setString(1, userUpdateInfo.getLastName());
                stmt.setString(2, userUpdateInfo.getFirstName());
                stmt.setString(3, userUpdateInfo.getLastNameFurigana());
                stmt.setString(4, userUpdateInfo.getFirstNameFurigana());
                stmt.setString(5, userUpdateInfo.getEmail());
                stmt.setString(6, userUpdateInfo.getPostalCode());
                stmt.setString(7, userUpdateInfo.getAddress());
                stmt.setString(8,userUpdateInfo.getPhoneNumber());
                stmt.setTimestamp(9, new java.sql.Timestamp(new java.util.Date().getTime()));
                stmt.setInt(10,userUpdateInfo.getId());

                stmt.executeUpdate();


        }catch(Exception e) {
            e.printStackTrace();
        }
        return userUpdateInfo;

    }


}
