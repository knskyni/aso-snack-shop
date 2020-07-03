package snack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import snack.bean.UserBean;

public class UserDao extends DaoBase{

    public UserBean auth(String email,String password) {
        if(con == null ) {
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

                userbean.setId(rs.getInt("Id"));
                userbean.setLastName(rs.getString("last_name"));
                userbean.setFirstName(rs.getString("first_name"));
                userbean.setLastNameFurigana(rs.getString("last_name_furigana"));
                userbean.setFirstNameFurigana(rs.getString("first_name_furigana"));
                userbean.setEmail(rs.getString("email"));
                userbean.setPassword(rs.getString("password"));
                userbean.setType(rs.getString("type"));
                userbean.setPostalCode(rs.getString("address"));
                userbean.setPhoneNumber(rs.getString("Number"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return userbean;

    }

}
