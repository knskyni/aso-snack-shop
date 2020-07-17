package snack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<NewsBean> list(){
        if( con == null ){
            return null;
        }
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<NewsBean> news = new ArrayList<NewsBean>();
        try{
            stmt = con.prepareStatement("SELECT id, updated_at, subject FROM news  ORDER BY updated_at DESC");
            rs = stmt.executeQuery();
            while( rs.next() ) {
                NewsBean newsBean = new NewsBean();
                newsBean.setId(rs.getInt("id"));
                newsBean.setUpdatedAt(rs.getDate("updated_at"));
                newsBean.setSubject(rs.getString("subject"));
                news.add(newsBean);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    public NewsBean show(int id) {
        if(con == null) {
            return null;
        }

        PreparedStatement stmt = null;
        NewsBean news = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM `news` WHERE `id` = ? AND `status` = 1;");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                news = new NewsBean();
                news.setId(rs.getInt("id"));
                news.setSubject(rs.getString("subject"));
                news.setContent(rs.getString("content"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return news;
    }

    public boolean update(NewsBean news) {
        if(con == null) {
            return false;
        }

        PreparedStatement stmt = null;
        int result = 0;

        try {
            stmt = con.prepareStatement("UPDATE `news` SET `updated_at` = ?, `subject` = ?, `content` = ? WHERE `id` = ?;");

            stmt.setTimestamp(1, new java.sql.Timestamp(new java.util.Date().getTime()));
            stmt.setString(2, news.getSubject());
            stmt.setString(3, news.getContent());
            stmt.setInt(4, news.getId());

            result = stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }

        return (result == 1) ? true : false;
    }

    public boolean delete(int id) {
        if(con == null) {
            return false;
        }

        PreparedStatement stmt = null;
        int result = 0;

        try {
            stmt = con.prepareStatement("UPDATE `news` SET `status` = 0 WHERE `id` = ?;");

            stmt.setInt(1, id);

            result = stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }

        return (result == 1) ? true : false;
    }

}
