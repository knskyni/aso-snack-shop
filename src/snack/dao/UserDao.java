package snack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	public boolean updatePassword(UserBean updateBean) {
		if( con == null ){
			return false;
		}

		PreparedStatement stmt = null;
		int result = 0;

		try{
			///////////////////////////////////
			//SELECT文の発行
			stmt = con.prepareStatement("UPDATE users SET password=? WHERE id=?");

            stmt.setString(1, updateBean.getPassword());
			stmt.setInt(2, updateBean.getId());

			result = stmt.executeUpdate();
		}catch(SQLException e) {

			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
		}

		if(result == 1) {
		    return true;
		} else {
		    return false;
		}

	}
}
