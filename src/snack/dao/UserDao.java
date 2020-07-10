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
    public boolean insert(UserBean userbean) {
        if(con == null) {
            return false;
        }

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("INSERT INTO users(first_name,last_name,first_name_frigana,last_name_frigana,email,password,postal_code,address,tel_number)VALUS(?,?,?,?,?,?,?,?,?");

            stmt.setString(1,userbean.getFirstName());
            stmt.setString(2,userbean.getLastName());
            stmt.setString(3,userbean.getFirstNameFurigana());
            stmt.setString(4,userbean.getLastNameFurigana());
            stmt.setString(5,userbean.getEmail());
            stmt.setString(6,userbean.getPassword());
            stmt.setString(7,userbean.getPostalCode());
            stmt.setString(8,userbean.getAddress());
            stmt.setString(9,userbean.getPhoneNumber());

            stmt.executeUpdate();
            return true;

        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
