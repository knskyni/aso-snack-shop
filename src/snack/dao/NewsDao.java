package snack.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import snack.bean.NewsBean;

public class NewsDao extends DaoBase {

    public boolean create(NewsBean news) {
        if(con == null) {
            return false;
        }

        PreparedStatement stmt = null;
        int result = 0;

        try {
            stmt = con.prepareStatement("INSERT INTO `news` (`created_at`, `updated_at`, `subject`, `content`) VALUES (?, ?, ?, ?)");

            stmt.setTimestamp(1, new java.sql.Timestamp(new java.util.Date().getTime()));
            stmt.setTimestamp(2, new java.sql.Timestamp(new java.util.Date().getTime()));
            stmt.setString(3, news.getSubject());
            stmt.setString(4, news.getContent());

            result = stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return (result == 1) ? true : false;
    }

}
